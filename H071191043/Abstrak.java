package app;

abstract class Abstrak{
    protected String menu;
	protected int price;
    protected int id;
    
    abstract void setMenu(String menu);
    abstract void setPrice(int price);
    abstract void setId(int id);
    
    abstract String getMenu();
    abstract int getPrice();
    abstract int getId();

    public void showMenu(){
        System.out.println("Menu Burger Store");
    }
}