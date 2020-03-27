package app;

class Addition extends Abstrak {
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
    public void showMenu(){
        bs.showMenuAddition();
    }
}