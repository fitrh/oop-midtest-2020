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
		System.out.println("Who are you?");
		String username = sc.next();

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

		// TODO: Start interaction

		FileOutputStream out = new FileOutputStream("user.dat");
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(users);
		objectOut.close();
	}
}
