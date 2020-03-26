package id.co.npad93.itemstore.items;

import java.lang.reflect.*;
import java.util.*;
import id.co.npad93.itemstore.*;

public final class ItemFactory
{
	public static Item newItemFromUUID(UUID uuid, int amount)
	{
		// If item factory is null, create new one
		if (itemFactory == null)
		{
			itemFactory = new HashMap<UUID, Class<?>>();

			// TODO: Put more items here
			itemFactory.put(Water.uuid, Water.class);
		}

		// Get object class
		Class<?> object = itemFactory.get(uuid);
		if (object == null)
			return null;
		
		// Find suitable constructor, with 1 arg (int)
		Constructor<?>[] constructor = object.getConstructors();
		for (Constructor<?> con: constructor)
		{
			Class<?>[] params = con.getParameterTypes();
			if (params.length == 1 && params[0] == int.class)
			{
				try
				{
					return (Item) con.newInstance(new Integer(amount));
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return null;
				}
			}
		}

		return null;
	}

	/** List of complete {@link Item} classes */
	private static Map<UUID, Class<?>> itemFactory;
}
