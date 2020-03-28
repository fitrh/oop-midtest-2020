package id.co.npad93.itemstore.interact;

import java.io.*;
import java.util.*;

import id.co.npad93.itemstore.*;

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
		System.out.println("Welcome " + user.getName());
		Main.printUserInfo(user);

		// Start interaction
		interaction(user, sc);

		// Save result
		FileOutputStream out = new FileOutputStream("user.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(users);
		objectOut.close();
	}

	private static void interaction(User user, Scanner sc)
	{
		Xorshift rng = new Xorshift();
		ArrayList<Action> actions = new ArrayList<Action>();

		// Actions to show user info
		actions.add(new Action() {
			@Override
			public String name() {return "Show Status";}
			@Override
			public void action(User u) {Main.printUserInfo(u);}
		});

		// Generate stores
		int actionsToGenerate = 1 + (int) (rng.nextDouble() * 4);
		for (int i = 0; i < actionsToGenerate; i++)
		{
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
					act.action(user);
				else
					System.out.println("Invalid input " + scannerResult);
			}
		} while (scannerResult != 0);
	}
}
