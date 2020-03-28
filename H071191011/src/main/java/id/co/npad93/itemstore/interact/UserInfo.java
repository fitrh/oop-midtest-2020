package id.co.npad93.itemstore.interact;

import java.io.*;
import java.util.*;

import id.co.npad93.itemstore.*;
import id.co.npad93.itemstore.items.*;

final class UserInfo implements Serializable
{
	private static final long serialVersionUID = 1L;

	public UserInfo(String username, User u)
	{
		this.username = username;
		user = u;
	}

	public User getUser()
	{
		return user;
	}

	public String getUsername()
	{
		return username;
	}

	private String username;
	private User user;

	private void writeObject(ObjectOutputStream out) throws IOException
	{
		// Write basic info
		out.writeUTF(username);
		out.writeUTF(user.getName());
		out.writeInt(user.getMoney());

		// Write items
		Item[] items = user.getInventory();
		out.writeInt(items.length);
		for (Item i: items)
		{
			out.writeObject(i.getID());
			out.writeInt(i.getAmount());
		}
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		// Read basic info
		username = in.readUTF();
		String name = in.readUTF();
		int money = in.readInt();
		user = new User(name, money);

		// Read items
		int itemAmount = in.readInt();
		for (int i = 0; i < itemAmount; i++)
		{
			UUID itemUUID = (UUID) in.readObject();
			int itemQuantity = in.readInt();
			user.addItem(ItemFactory.newItemFromUUID(itemUUID, itemQuantity));
		}
	}

	private void readObjectNoData() throws ObjectStreamException
	{
		throw new InvalidObjectException("cannot deserialize");
	}
}
