package id.co.npad93.itemstore;

/**
 * Abstract Item class. Any class derive this class requires methods below to
 * be implemented.
 */
public abstract class Item
{
	/**
	 * Retrieve the name of the item
	 * 
	 * @return Name of the item
	 */
	public abstract String getName();

	/**
	 * Retrieve the description of the item
	 * 
	 * @return Description of the item
	 */
	public abstract String getDescription();

	/**
	 * Split the item into new item
	 * @param amount Amount of the newly splitted item to return
	 * @return Splitted <code>Item</code> which has <code>amount</code>
	 *   quantity
	 * @exception IllegalArgumentException if amount specified is bigger
	 *              than or equal to current item {@link #getAmount quantity}
	 */
	public abstract Item separate(int amount);

	/**
	 * Retrieve the quantity of the item
	 *
	 * @return Quantity of the item
	 */
	public final int getAmount()
	{
		return amount;
	}

	// Add item only if it's equal. The passed item object
	// has amount of 0 after this function called.
	/**
	 * Add quantity of the current item. The passed <code>item</code> has
	 * {@link #getAmount() quantity} of 0 after this function called
	 * 
	 * @param item Same item to took the quantity from
	 * @exception IllegalArgumentException if the item is not equal to
	 *              passed item.
	 */
	public final void add(Item item)
	{
		if (equals(item))
		{
			this.amount += item.amount;
			item.amount = 0;
		}
		else
			throw new IllegalArgumentException("this != item");
	}

	@Override
	public boolean equals(Object item)
	{
		if (item instanceof Item)
			return ((Item) item).uuid.equals(uuid);

		return false;
	}

	@Override
	public int hashCode()
	{
		return uuid.hashCode();
	}

	/** Quantity of the item */
	protected int amount;
	/** UUID/identifier of the item */
	protected final String uuid;

	/**
	 * All class which derive this class MUST call this constructor!
	 * 
	 * @param uuid Identifier of the item
	 * @param amount Quantity of the item
	 * @exception IllegalArgumentException if <code>amount</code> is 0 or
	 *              negative
	 */
	protected Item(String uuid, int amount)
	{
		if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
		this.amount = amount;
		this.uuid = uuid;
	}
}
