package id.co.npad93.itemstore.items;

import java.util.UUID;

import id.co.npad93.itemstore.*;

public class Water extends Item implements Consumable
{
	/** Water item identifier */
	public static final UUID uuid = UUID.fromString("c9f615e6-dd48-4d49-8f3d-e91910d5318d");

	/**
	 * https://www.facebook.com/woterrrr
	 * 
	 * @param amount Amount of woterrrr
	 */
	public Water(int amount)
	{
		super(uuid, amount);
	}

	@Override
	public String getName()
	{
		return "Water";
	}

	@Override
	public String getDescription()
	{
		return "Just a bottle full of mineral water, nothing special.";
	}

	@Override
	protected Item clone(int amount)
	{
		return new Water(amount);
	}

	@Override
	public void use(User player)
	{
		if (amount > 0)
		{
			amount--;
			System.out.println(player.getName() + " now hydrated");
		}
	}
}
