package app;

class Main {
    public static void main(String[] args) {
        BurgerStore bs = new BurgerStore();
        //Polymorphism
        Cart cart = new BurgerStore(); 
        //Polymorphism
        Cart cartt = new Cart(); 

        bs.readFileBurger();
        bs.readFileAddition();
        cartt.showMenuBurger();
        cart.showMenuBurger();
        bs.showBurger();
        cartt.showMenuAddition();
        cart.showMenuAddition();
        bs.showAddition();
        bs.buyBurger();
        bs.checkout(); 
    }
}