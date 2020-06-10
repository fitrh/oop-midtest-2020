package id.co.npad93.itemstore;

import java.util.*;

/**
 * User class represent player or store owner or both
 */
public class User
{
	/**
	 * Create new user with specified name and amount of money
	 * 
	 * @param name Player name
	 * @param money Player money
	 */
	public User(String name, int money)
	{
		this.name = name;
		this.money = money;
		this.inventory = new ArrayList<Item>();
	}

	/**
	 * Retrieve user name
	 * 
	 * @return User name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Retrieve user money
	 * 
	 * @return User money
	 */
	public int getMoney()
	{
		return money;
	}

	/**
	 * Add/subtract user money
	 * @param amount Amount to add/subtract
	 * @exception IllegalArgumentException if {@link #getMoney() money} +
	 *              <code>amount</code> &lt; 0
	 */
	public void addMoney(int amount)
	{
		if ((money + amount) < 0)
			throw new IllegalArgumentException("money < 0");

		money += amount;
	}

	/**
	 * Give money to another player
	 * 
	 * @param player Target player
	 * @param amount Amount to give
	 * @exception IllegalArgumentException if there's not enough money to
	 *              perform this operation
	 */
	public void giveMoney(User player, int amount)
	{
		if ((money - amount) < 0)
			throw new IllegalArgumentException("money < 0");
		
		money -= amount;
		player.money += amount;
	}

	/**
	 * Retrieve user inventory
	 * 
	 * TODO: Encapsulate player inventory
	 * @return List of user {@link Item items}
	 */
	public Item[] getInventory()
	{
		Item[] result = new Item[inventory.size()];
		inventory.toArray(result);
		return result;
	}

	/**
	 * Add new item to user inventory
	 * 
	 * @param item {@link Item} to add
	 * @exception NullPointerException if <code>item</code> is null
	 */
	public void addItem(Item item)
	{
		if (item == null)
			throw new NullPointerException("item");

		for (Item i: inventory)
		{
			if (i.equals(item))
			{
				i.add(item);
				return;
			}
		}

		inventory.add(item);
	}

	/**
	 * Remove item from user inventory
	 * 
	 * @param uuid {@link Item#getID() item identifier}
	 * @param amount amount to remove
	 * @return <code>true</code> if operation success, <code>false</code>
	 *         otherwise
	 */
	public boolean removeItem(UUID uuid, int amount)
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			Item item = inventory.get(i);
			if (item.getID().equals(uuid))
			{
				int a = item.getAmount();
				boolean status = true;

				if (a > amount)
					// Subtract
					item.separate(amount);
				else if (a == amount)
					// Remove
					inventory.remove(i);
				else
					// amount to remove > amount available
					status = false;
				
				return status;
			}
		}

		return false;
	}

	/** User name */
	private String name;
	/** User money */
	private int money;
	/** User inventory */
	private ArrayList<Item> inventory;
}
