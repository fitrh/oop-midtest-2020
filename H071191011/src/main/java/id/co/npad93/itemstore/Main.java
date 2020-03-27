package id.co.npad93.itemstore;

import java.util.*;

import id.co.npad93.itemstore.items.*;

public class Main 
{
	private static class Xorshift
	{
		private static long wangHash64(long key)
		{
			key = (~key) + (key << 21); // key = (key << 21) - key - 1;
			key = key ^ (key >>> 24);
			key = (key + (key << 3)) + (key << 8); // key * 265
			key = key ^ (key >>> 14);
			key = (key + (key << 2)) + (key << 4); // key * 21
			key = key ^ (key >>> 28);
			key = key + (key << 31);
			return key;
		}

		public Xorshift(long seed)
		{
			setSeed(seed);
		}

		public Xorshift()
		{
			this(System.nanoTime() * 88172645463325252L);
		}

		public void setSeed(long seed)
		{
			do
			{
				seed = wangHash64(seed);
			} while (seed == 0);
			state = seed;
		}

		public long nextLong()
		{
			step();
			return state * 2685821657736338717L;
		}

		public double nextDouble()
		{
			return Double.longBitsToDouble(((0x3FFL) << 52) | (nextLong() >>> 12)) - 1.0;
		}

		private long state;

		private void step()
		{
			state ^= (state >>> 12);
			state ^= (state << 25);
			state ^= (state >>> 27);
		}
	}

	public static void main(String[] args) throws Exception
	{
		if (args.length == 0)
		{
			// Initialize RNG
			Xorshift rng = new Xorshift();
			
			// Interaction type: Player-Player vs Player-Store
			double ret = rng.nextDouble();
			if (ret >= 0.0)
				interactionPlayerByPlayer(rng);
			else
				interactionPlayerByStore(rng);
		}
		else
		{
			// TODO: non-RNG interaction
		}
	}

	private static Character[] syllables = {'a', 'i', 'u', 'e', 'o'};

	private static <T> boolean contains(T[] a, T v)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == v)
				return true;
		
		return false;
	}

	/** Generate random name */
	private static String generateName(Xorshift rng)
	{
		int syllableLength = 1 + (int) (rng.nextDouble() * 6);
		int length = 0;
		char[] ch = new char[syllableLength * 3];

		for (int i = 0; i < syllableLength; i++)
		{
			char syllable = syllables[(int) (rng.nextDouble() * 5)];
			double cpre = rng.nextDouble() * 0.5 + 0.3;
			double cpost = rng.nextDouble() * 0.4 + 0.3;
			boolean doPre = false, doPost = false;

			if (syllableLength == 1)
				if (rng.nextDouble() >= 0.5)
					doPre = true;
				else
					doPost = true;
			
			if (rng.nextDouble() >= cpre || doPre)
			{
				// prepend
				char pre;
				do
				{
					pre = (char) (97 + rng.nextDouble() * 26);
				} while (Main.<Character>contains(syllables, pre));
				ch[length++] = pre;
			}

			ch[length++] = syllable;

			if (rng.nextDouble() >= cpost || doPost)
			{
				// append
				char post;
				do
				{
					post = (char) (97 + rng.nextDouble() * 26);
				} while (Main.<Character>contains(syllables, post));
				ch[length++] = post;
			}
		}

		ch[0] = Character.toUpperCase(ch[0]);
		return new String(ch, 0, length);
	}

	private static UUID[] consumableItems = {
		Water.uuid,
		HPRestorator50.uuid
	};

	private static UUID[] usableItems = {
		LP21.uuid,
		ThermalSuit.uuid
	};

	private static UUID[] allItems = {
		Water.uuid,
		HPRestorator50.uuid,
		LP21.uuid,
		ThermalSuit.uuid
	};

	private static void printUserInfo(User user)
	{
		System.out.printf("Player %s (money %d) inventory:\n", user.getName(), user.getMoney());
		for (Item i: user.getInventory())
		{
			System.out.println("- " + i.getName() + " (" + i.getAmount() + ")");
			System.out.println("  " + i.getDescription());
		}
	}

	private static void interactionPlayerByPlayer(Xorshift rng)
	{
		// Player-Player trade
		int money1 = (int) (rng.nextDouble() * 100.0) * 1000;
		String user1Name = generateName(rng);
		User user1 = new User(user1Name, money1);
		int money2 = (int) (rng.nextDouble() * 100.0) * 1000;
		String user2Name = generateName(rng);
		User user2 = new User(user2Name, money2);

		// Stock some items
		boolean[] user1Equipped = new boolean[usableItems.length];
		for (int i = 0; i < 10; i++)
		{
			boolean itemAdded = false;

			// 10% chance to have equipable item
			if (rng.nextDouble() < 0.1)
			{
				// Usable items
				int index = (int) (rng.nextDouble() * usableItems.length);
				if (user1Equipped[index] == false)
				{
					user1.addItem(ItemFactory.newItemFromUUID(usableItems[index], 1));
					user1Equipped[index] = true;
				}
			}

			if (!itemAdded)
				// Consumable items
				user1.addItem(ItemFactory.newItemFromUUID(
					consumableItems[(int) (rng.nextDouble() * consumableItems.length)], 1
				));
		}
			
		// Inventory checklist
		printUserInfo(user1);

		// Trade system
		System.out.println(user2Name + " meet " + user1Name);

		// Which item to trade
		Item[] user1Inv = user1.getInventory();
		Item tradeItem = user1Inv[(int) (rng.nextDouble() * user1Inv.length)];
		int tradePrice = (int) (rng.nextDouble() * 50.0) * 1000;
		System.out.println(user2Name + " wants " + tradeItem.getName() + " for " + tradePrice);

		// 50% agrees
		if (rng.nextDouble() >= 0.5)
		{
			if (money2 >= tradePrice)
			{
				// Give user money
				user2.giveMoney(user1, tradePrice);
				// Remove item
				user1.removeItem(tradeItem.getID(), tradeItem.getAmount());
				// Add item
				user2.addItem(tradeItem);
				System.out.println(user1Name + " traded " + tradeItem.getName() + " for ");
				printUserInfo(user2);
			}
			else
			{
				// Not enough money
				System.out.println(user1Name + " agrees but " + user2Name + " doesn't have enough money");
			}
		}
		else
			System.out.println(user1Name + " declines");
	}

	private static void interactionPlayerByStore(Xorshift rng)
	{
		// Player-Store interaction
		String user1Name = generateName(rng);
		User user1 = new User(user1Name, 50000);
		int money2 = (int) (rng.nextDouble() * 120.0) * 1000;
		String user2Name = generateName(rng);
		User user2 = new User(user2Name, money2);

		// New store
		Store store = new Store(user1);

		// What kind of items to stock?
		Set<UUID> itemsToAdd = new HashSet<UUID>();
		for (int i = 0; i < allItems.length; i++)
			itemsToAdd.add(allItems[(int) (rng.nextDouble() * allItems.length)]);
		
		// Ok prepare items for stock
		int amountOfUniqueItems = itemsToAdd.size();
		UUID[] itemUUIDs = new UUID[amountOfUniqueItems];
		Item[] items = new Item[amountOfUniqueItems];
		int[] itemPrices = new int[amountOfUniqueItems];
		itemsToAdd.toArray(itemUUIDs);
		System.out.println("Items in store");
		for (int i = 0; i < amountOfUniqueItems; i++)
		{
			int itemAmount = 1 + (int) (rng.nextLong() & 31);
			int price = 2000 + (int) (rng.nextDouble() * 20) * 100;
			Item item = ItemFactory.newItemFromUUID(itemUUIDs[i], itemAmount);
			items[i] = item;
			itemPrices[i] = price;

			System.out.println("- " + item.getName() + " (" + itemAmount + ") price " + price);
			System.out.println("  " + item.getDescription());
		}

		// Finally, stock items
		store.stockItems(user1, items, itemPrices);
	}
}
