package app;

class Burger extends Abstrak {
    public static String txt;
	BurgerStore bs = new BurgerStore();
    @Override
    void setMenu(String menu){
        super.menu = menu;
    }
    @Override
    void setPrice(int price){
        super.price = price;
    }
    @Override
    void setId(int id){
        super.id = id;
    }

    @Override
    String getMenu() {
        return super.menu;
    }
    @Override
    int getPrice(){
        return super.price;
    }
    @Override
    int getId(){
        return super.id;
    }
}