package app;

abstract class Abstrak{
    protected String menu;
	protected int price;
    protected int id;
    
    abstract String getMenu();
    abstract int getPrice();
    abstract int getId();
}