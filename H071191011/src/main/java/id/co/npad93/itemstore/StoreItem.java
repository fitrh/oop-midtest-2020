package id.co.npad93.itemstore;

// Item object encapsulated to prevent item stealing
public class StoreItem
{
	// Construct new StoreItem
	public StoreItem(Item item, int price, Store store)
	{
		this.item = item;
		this.price = price;
		this.store = store;
	}

	// Retrieve the name of the item
	public String getName()
	{
		return item.getName();
	}

	// Retrieve item description
	public String getDescription()
	{
		return item.getDescription();
	}

	// Retrieve the quantity of the item
	public int getAmount()
	{
		return item.getAmount();
	}

	// Retrieve the price of the item
	public int getPrice()
	{
		return price;
	}

	// Buy item
	public Item buy(User player, int amount)
	{
		if (amount > item.getAmount())
			throw new IllegalArgumentException("item amount < requested amount");

		int totalPrice = price * amount;
		if (player.getMoney() < totalPrice)
			throw new IllegalArgumentException("not enough money");
		
		player.addMoney(-totalPrice);
		Item result = item.separate(amount);

		// If item quantity is 0, remove it from shop item list
		if (item.getAmount() == 0)
			store.removeItem(this);
		
		return result;
	}

	// Override equals method
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof StoreItem)
			return ((StoreItem) obj).item.equals(this);
		
		return false;
	}

	// Override hashCode method
	@Override
	public int hashCode()
	{
		return item.hashCode() + store.hashCode() + price;
	}

	// Check whetever an Item is encapsulated in this StoreItem
	public boolean isContainedItem(Item item)
	{
		return this.item.equals(item);
	}

	public void add(Item item)
	{
		this.item.add(item);
	}

	// Item object
	private Item item;
	// Item price
	private int price;
	// Store parent object
	private Store store;
}
