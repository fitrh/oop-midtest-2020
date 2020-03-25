package id.co.npad93.itemstore;

// Abstract Item class
// Any class derive this class requires
// methods below to be implemented
public abstract class Item
{
	protected int amount;

	protected Item()
	{
		amount = 1;
	}

	public abstract String getName();

	public abstract String getDescription();

	public abstract int getPrice();

	public int getAmount()
	{
		return amount;
	}

	public void use(User user)
	{}

	public abstract Item separate(int amount);
}
