package id.co.npad93.itemstore.items;

import id.co.npad93.itemstore.*;

/**
 * {@link Item Items} which can be consumed implements this interface
 */
interface Consumable
{
	/**
	 * Consume the item
	 * 
	 * @param player {@link User Player} who wants to consume the item
	 */
	void use(User player);
}
