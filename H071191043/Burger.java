package app;

class Burger extends Abstrak {
    public Burger (int  id, String menu, int price){ //constructor
        super.id = id;
        super.menu = menu;
        super.price = price;
    }

    //method @Override from abstract class
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