package id.co.npad93.itemstore.interact;

import java.io.*;
import java.util.*;

import id.co.npad93.itemstore.*;
import id.co.npad93.itemstore.items.*;

public class InteractMain
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();

		try
		{
			FileInputStream input = new FileInputStream("user.dat");
			ObjectInputStream objectIn = new ObjectInputStream(input);

			Object list = objectIn.readObject();
			if (list instanceof ArrayList<?>)
			{
				ArrayList<?> arrayList = (ArrayList<?>) list;
				for (Object obj: arrayList)
				{
					if (obj instanceof UserInfo)
						users.add((UserInfo) obj);
				}
			}

			objectIn.close();
		}
		catch (FileNotFoundException e)
		{ }

		// Read input
		Scanner sc = new Scanner(System.in);
		System.out.print("Who are you? ");
		String username = sc.nextLine();

		User user = null;
		for (UserInfo u: users)
		{
			if (u.getUsername().equals(username))
			{
				user = u.getUser();
				break;
			}
		}

		// If new user is not exist, create new user
		if (user == null)
		{
			sc.nextLine();
			System.out.print("Please enter your name: ");
			String name = sc.nextLine();
			user = new User(name, 5000);
			users.add(new UserInfo(username, user));
		}

		// Start interaction
		System.out.println("Welcome, " + user.getName());
		interaction(user, sc);
		System.out.println("Goodbye, " + user.getName());

		// Save result
		FileOutputStream out = new FileOutputStream("user.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(users);
		objectOut.close();
	}

	private static User generateUser(Xorshift rng)
	{
		int money = (int) (rng.nextDouble() * 100.0) * 1000;
		String userName = Main.generateName(rng);
		User user = new User(userName, money);

		Main.stockRandomItems(user, rng);
		return user;
	}

	private static void startStoreInteraction(User user, User owner, Store store, Scanner sc)
	{
		while (true)
		{
			StoreItem[] items = store.getItems();
			System.out.println("You're now at " + owner.getName() + "'s store and they sell these items");
			for (int i = 0; i < items.length; i++)
			{
				StoreItem it = items[i];
				System.out.printf(
					"%d. %s (%d) price %d\n",
					i + 1,
					it.getName(),
					it.getAmount(),
					it.getPrice()
				);
				System.out.println("   " + it.getDescription());
			}
			System.out.println("0. Quit");
			System.out.print("Which item do you want to buy? ");
			int selectionIndex = sc.nextInt();
			
			if (selectionIndex == 0)
				break;
			
			selectionIndex--;

			if (selectionIndex >= 0 && selectionIndex < items.length)
			{
				StoreItem selectedItem = items[selectionIndex];
				System.out.println("Please enter amount to buy (<=0 to cancel): ");
				int amount = sc.nextInt();

				if (amount > 0)
				{
					if (amount > selectedItem.getAmount())
						System.out.println("Store doesn't have that much amount");
					else
					{
						int price = amount * selectedItem.getPrice();
						if (user.getMoney() >= price)
						{
							System.out.println("You bought " + amount + " " + selectedItem.getName() + " for " + price);
							user.addItem(selectedItem.buy(user, amount));
						}
						else
							System.out.printf(
								"Not enough money (price %d, your money %d)\n",
								price, user.getMoney()
							);
					}
				}
			}
		}
	}

	private static void startPlayerInteraction(User user, User target, Scanner sc)
	{
		Xorshift rng = new Xorshift(target.hashCode() | (target.getName().hashCode() << 32));
		System.out.println(target.getName() + ": Oh, you're approaching me? Ok");

		System.out.println("What you do?");
		System.out.println("0. Quit");
		System.out.println("1. Sell Items");
		System.out.println("2. Buy Items");

		while (true)
		{
			int mainSel = sc.nextInt();

			switch (mainSel)
			{
				case 0:
					// Quit
					return;
				case 1:
				{
					// Sell items
					Main.printUserInfo(user);
					Item[] playerItems = user.getInventory();
					int selectedItemIndex;

					// Select item index
					while (true)
					{
						selectedItemIndex = sc.nextInt();
						if (selectedItemIndex == 0)
						{
							System.out.println("Cancelled");
							return;
						}
						else if (selectedItemIndex >= 1 && selectedItemIndex <= playerItems.length)
						{
							selectedItemIndex--;
							break;
						}
						
						System.out.println("Invalid input");
					}

					Item tradedItem = playerItems[selectedItemIndex];
					System.out.println("You want to trade 1 " + tradedItem.getName());

					if (rng.nextDouble() >= 0.5)
					{
						// Target player make a deal of the price
						int targetPrice = Math.min((3 + (int) (rng.nextDouble() * 13)) * 1000, target.getMoney());
						System.out.println(target.getName() + " want it for " + targetPrice);
						System.out.print("Agree (0/1)? ");

						int choice = -1;
						while (choice != 0 && choice != 1)
							choice = sc.nextInt();
						
						if (choice == 1)
						{
							// Player agrees
							System.out.println("You traded one " + tradedItem.getName() + " for " + targetPrice);
							if (tradedItem.getAmount() == 1)
							{
								target.addItem(tradedItem);
								user.removeItem(tradedItem.getID(), 1);
							}
							else
								target.addItem(tradedItem.separate(1));

							target.giveMoney(user, targetPrice);
						}
						else
							System.out.println("You declined.");
					}
					else
					{
						int targetPrice = Integer.MIN_VALUE;
						System.out.println(target.getName() + " asks for price");
						System.out.print("How much is the price of the item? ");
						while (targetPrice <= 0)
						{
							if (targetPrice != Integer.MIN_VALUE)
								System.out.println("Invalid price");
							targetPrice = sc.nextInt();
						}
						
						double chance = (double) targetPrice / (double) target.getMoney();
						if (rng.nextDouble() >= chance)
						{
							// Target player agrees
							System.out.println("You traded one " + tradedItem.getName() + " for " + targetPrice);
							if (tradedItem.getAmount() == 1)
							{
								target.addItem(tradedItem);
								user.removeItem(tradedItem.getID(), 1);
							}
							else
								target.addItem(tradedItem.separate(1));

							target.giveMoney(user, targetPrice);
						}
						else
							System.out.println(target.getName() + " declined");
					}
					return;
				}
				case 2:
				{
					// Buy items
					Item[] targetItems = target.getInventory();
					Item selectedItem = targetItems[(int) (rng.nextDouble() * targetItems.length)];
					int price = (3 + (int) (rng.nextDouble() * 13)) * 1000;

					System.out.println(target.getName() + " want to trade one " + selectedItem.getName() + " for " + price);
					System.out.print("Agree (0/1)? ");
					
					int choice = -1;
					while (choice != 0 && choice != 1)
						choice = sc.nextInt();
					
					if (choice == 1)
					{
						// You agree
						if (user.getMoney() >= price)
						{
							System.out.println(target.getName() + " traded one " + selectedItem.getName() + " for " + price);
							
							if (selectedItem.getAmount() == 1)
							{
								user.addItem(selectedItem);
								target.removeItem(selectedItem.getID(), 1);
							}
							else
								user.addItem(selectedItem.separate(1));

							user.giveMoney(target, price);
						}
						else
							System.out.println("You don't have enough money");
					}
					else
						System.out.println("You declined.");

					return;
				}
				default:
				{
					System.out.println("Invalid input");
					break;
				}
			}
		}
	}

	private static void interaction(User user, Scanner sc)
	{
		Xorshift rng = new Xorshift();
		ArrayList<Action> actions = new ArrayList<Action>();

		// Give player money at 10% chance
		if (rng.nextDouble() <= 0.1)
		{
			int amount = (int) (1 + rng.nextDouble() * 10) * 1000;
			System.out.println("You received money " + amount);
			user.addMoney(amount);
		}

		Main.printUserInfo(user);

		// Actions to show user info
		actions.add(new Action()
		{
			@Override
			public String name() {return "Show Status";}

			@Override
			public void action(User u, Scanner sc) {Main.printUserInfo(u);}
		});

		// Generate stores or players
		int actionsToGenerate = 1 + (int) (rng.nextDouble() * 4);
		for (int i = 0; i < actionsToGenerate; i++)
		{
			if (rng.nextDouble() >= 0.5)
			{
				// Store interaction
				User owner = generateUser(rng);
				Store store = new Store(owner);
				Main.stockRandomItems(store, owner, rng);
				String description = "Go To " + owner.getName() + "'s Store";

				// Define action
				actions.add(new Action()
				{
					@Override
					public String name() {return description;}
					
					@Override
					public void action(User u, Scanner sc)
					{
						startStoreInteraction(u, owner, store, sc);
					}
				});
			}
			else
			{
				// Player interaction
				User target = generateUser(rng);

				// Fill with random items
				Main.stockRandomItems(target, rng);

				// Define action
				String description = "Approach " + target.getName();
				actions.add(new Action()
				{
					@Override
					public String name() {return description;}
					
					@Override
					public void action(User u, Scanner sc)
					{
						startPlayerInteraction(u, target, sc);
						actions.remove(this);
					}
				});
			}
		}

		// Main loop interaction
		int scannerResult = -1;
		do
		{
			System.out.println("What you want to do?");
			System.out.println("0. Quit");
			for (int i = 0; i < actions.size(); i++)
				System.out.println((i + 1) + ". " + actions.get(i).name());

			System.out.print("Your input? ");
			scannerResult = sc.nextInt();
			scannerResult = scannerResult >= 0 ? scannerResult : -1;
			if (scannerResult > 0)
			{
				Action act = null;
				try
				{
					act = actions.get(scannerResult - 1);
				}
				catch (IndexOutOfBoundsException e)
				{}

				if (act != null)
					act.action(user, sc);
				else
					System.out.println("Invalid input " + scannerResult);
			}
		} while (scannerResult != 0);
	}
}
