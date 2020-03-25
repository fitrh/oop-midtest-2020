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

	// Checks whetever the items are equal
	@Override
	public boolean equals(Object item)
	{
		if (item instanceof Item)
			return ((Item) item).uuid.equals(uuid);

		return false;
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
