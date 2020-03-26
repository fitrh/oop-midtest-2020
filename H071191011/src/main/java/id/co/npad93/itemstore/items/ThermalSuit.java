package id.co.npad93.itemstore.items;

import java.util.UUID;

import id.co.npad93.itemstore.*;

public final class ThermalSuit extends Item implements Usable
{
	public static final UUID uuid = UUID.fromString("a0cd9aef-d97c-4b0a-8c65-44be2a8f26a8");

	public ThermalSuit(int amount)
	{
		super(uuid, amount);
	}

	@Override
	public void equip(User player)
	{
		System.out.println(player.getName() + " wear Thermal Suit");
	}

	@Override
	public void unequip(User player)
	{
		System.out.println(player.getName() + " unwear Thermal Suit");
	}

	@Override
	public String getName() {
		return "Thermal Suit";
	}

	@Override
	public String getDescription()
	{
		return "Basic thermal suit which can whitstand hot and cold temperature.";
	}

	@Override
	protected Item clone(int amount)
	{
		return new ThermalSuit(amount);
	}
}
