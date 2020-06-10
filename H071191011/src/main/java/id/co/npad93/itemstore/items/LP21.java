package id.co.npad93.itemstore.items;

import java.util.UUID;

import id.co.npad93.itemstore.*;

public final class LP21 extends Item implements Usable
{
	public static final UUID uuid = UUID.fromString("6d30ee84-28a3-42da-a937-dede2aaf8ded");

	public LP21(int amount)
	{
		super(uuid, amount);
	}

	@Override
	public void equip(User player)
	{
		System.out.println(player.getName() + " equips LP-2.1 and turn it on");
	}

	@Override
	public void unequip(User player)
	{
		System.out.println(player.getName() + " shuts off LP-2.1 and unequip it");
	}

	@Override
	public String getName()
	{
		return "LP-2.1";
	}

	@Override
	public String getDescription()
	{
		return "Most mainstream weapon from Utpala Industries. Color: Pink; Length: Long";
	}

	@Override
	protected Item clone(int amount)
	{
		return new LP21(amount);
	}	
}
