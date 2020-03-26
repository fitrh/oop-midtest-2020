package id.co.npad93.itemstore;

import java.util.*;

// Store
public class Store
{
	// New store object
	public Store(User owner)
	{
		this.owner = owner;
	}

	// Add items. Rest assured items are unusable after passed to this function
	public void stockItems(User player, Item[] items, int[] prices)
	{
		// Sanity check: Ensure only store owner can stock items
		if (owner.equals(player) == false)
			throw new IllegalArgumentException("player != owner");

		// Sanity check: ensure all the arrays have same length
		if (items.length != prices.length)
			throw new IllegalArgumentException("length doesn't match each other");

		// Stock items, in loop
		for (int i = 0; i < items.length; i++)
		{
			boolean found = false;

			// FIXME: Optimize this loop?
			for (StoreItem storeItem: this.items)
			{
				if (storeItem.isContainedItem(items[i]))
				{
					storeItem.add(items[i]);
					found = true;
					break;
				}
			}

			// If not found, add new StoreItem
			if (!found)
				this.items.add(new StoreItem(items[i], prices[i], this));
		}
	}

	// Remove item
	public void removeItem(StoreItem item)
	{
		items.remove(item);
	}

	// List of items for sale
	protected ArrayList<StoreItem> items;
	// Store owner, which is a user
	protected User owner;
}
