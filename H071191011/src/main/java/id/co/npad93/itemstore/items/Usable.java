package id.co.npad93.itemstore.items;

import id.co.npad93.itemstore.*;

/**
 * {@link Item Items} which can be wear/equipped implements this interface
 */
interface Usable
{
	/**
	 * Equip the item
	 * 
	 * @param player Player who wants to equip the item
	 */
	void equip(User player);

	/**
	 * Unequip the item
	 * 
	 * @param player Player who wants to equip the item
	 */
	void unequip(User player);
}
