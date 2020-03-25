package id.co.npad93.itemstore;

// Abstract Item class
// Any class derive this class requires
// methods below to be implemented
public abstract class Item
{
	// Retrieve the name of the item
	public abstract String getName();

	// Retrieve the description of the item
	public abstract String getDescription();

	// Separate the item into new item
	public abstract Item separate(int amount);

	// Retrieve the quantity of the item
	public final int getAmount()
	{
		return amount;
	}

	// Add item only if it's equal. The passed item object
	// has amount of 0 after this function called.
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

	// Checks whetever the items are equal
	@Override
	public boolean equals(Object item)
	{
		if (item instanceof Item)
			return ((Item) item).uuid.equals(uuid);

		return false;
	}

	// Override hashCode method for HashMap
	@Override
	public int hashCode()
	{
		return uuid.hashCode();
	}

	// Quantity of the item
	protected int amount;
	// UUID/identifier of the item
	protected final String uuid;

	protected Item(String uuid, int amount)
	{
		if (amount <= 0) throw new IllegalArgumentException("amount <= 0");
		this.amount = amount;
		this.uuid = uuid;
	}
}
