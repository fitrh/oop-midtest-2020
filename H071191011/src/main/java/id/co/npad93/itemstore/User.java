package id.co.npad93.itemstore;

import java.util.*;

/**
 * User class represent player or store owner or both
 */
public class User
{
	public User(String name, int money)
	{
		this.name = name;
		this.money = money;
	}

	public String getName()
	{
		return name;
	}

	public int getMoney()
	{
		return money;
	}

	public void addMoney(int amount)
	{
		if ((money + amount) < 0)
			throw new IllegalArgumentException("money < 0");

		money += amount;
	}

	public void giveMoney(User player, int amount)
	{
		if ((money - amount) < 0)
			throw new IllegalArgumentException("money < 0");
		
		money -= amount;
		player.money += amount;
	}

	public Item[] getInventory()
	{
		Item[] result = new Item[inventory.size()];
		inventory.toArray(result);
		return result;
	}

	private String name;
	private int money;
	private ArrayList<Item> inventory;
}
