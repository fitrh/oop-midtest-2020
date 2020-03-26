package id.co.npad93.itemstore.items;

import java.util.UUID;

import id.co.npad93.itemstore.*;

public final class HPRestorator50 extends Item implements Consumable
{
	public static final UUID uuid = UUID.fromString("6691321f-8f28-42b3-beed-83135b1f7ce9");

	public HPRestorator50(int amount)
	{
		super(uuid, amount);
	}

	@Override
	public void use(User player)
	{
		if (amount > 0)
		{
			amount--;
			System.out.println(player.getName() + " restores 50 HP");
		}
	}

	@Override
	public String getName()
	{
		return "HP Restorator Fifties";
	}

	@Override
	public String getDescription()
	{
		return "Made in Utpala Industries. Restores 50 HP!";
	}

	@Override
	protected Item clone(int amount)
	{
		return new HPRestorator50(amount);
	}
}
