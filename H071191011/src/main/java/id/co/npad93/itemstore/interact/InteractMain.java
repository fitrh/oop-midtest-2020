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

		// Print info
		System.out.println("Welcome, " + user.getName());
		Main.printUserInfo(user);

		// Start interaction
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
		return new User(userName, money);
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
							user.addItem(selectedItem.buy(user, amount));
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
		System.out.println(target.getName() + ": Oh, you're approaching me? Ok");

		System.out.println("What you do?");
		System.out.println("0. Quit");
		System.out.println("1. Sell Items");
		System.out.println("2. Buy Items");

		// TODO
		while (true)
		{
			int mainSel = sc.nextInt();

			switch (mainSel)
			{
				case 0:
					return;
				case 1:
				{
					Main.printUserInfo(user);
					
					break;
				}
				case 2:
				{
					break;
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
