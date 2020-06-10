package app;

class Burger extends Abstrak {
    //constructor
    public Burger (int  id, String menu, int price){ 
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