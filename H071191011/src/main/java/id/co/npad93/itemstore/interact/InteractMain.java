package id.co.npad93.itemstore.interact;

import java.io.*;
import java.util.*;

import id.co.npad93.itemstore.*;

public class InteractMain
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<UserInfo> users;

		try
		{
			FileInputStream input = new FileInputStream("user.dat");
			ObjectInputStream objectIn = new ObjectInputStream(input);
			users = (ArrayList<UserInfo>) objectIn.readObject();
			objectIn.close();
		}
		catch (FileNotFoundException e)
		{
			users = new ArrayList<UserInfo>();
		}
	}
}
