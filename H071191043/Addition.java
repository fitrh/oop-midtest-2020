package app;

class Addition extends Abstrak {
    //constructor
    public Addition (int  id, String menu, int price){ 
        super.id = id;
        super.menu = menu;
        super.price = price;
    }

    //method @Override from abstract class
    @Override
    String getMenu(){
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