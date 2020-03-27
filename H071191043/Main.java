package app;

class Main {
    public static void main(String[] args) {
        BurgerStore bs = new BurgerStore();
        Burger b = new Burger();

        Burger burger1 = new Burger();
        burger1.setId(1);
        burger1.setMenu("Cheese Burger");
        burger1.setPrice(35000);
        bs.addToCart(burger1);

        Burger burger2 = new Burger();
        burger2.setId(2);
        burger2.setMenu("Burger King Teriyaki");
        burger2.setPrice(35000);
        bs.addToCart(burger2);

        Burger burger3 = new Burger();
        burger3.setId(3);
        burger3.setMenu("Burger King Deluxe Beffbacon");
        burger3.setPrice(37000);
        bs.addToCart(burger3);

        Burger burger4 = new Burger();
        burger4.setId(4);
        burger4.setMenu("Burger King Mushroom Swiss");
        burger4.setPrice(42000);
        bs.addToCart(burger4);

        Burger burger5 = new Burger();
        burger5.setId(5);
        burger5.setMenu("Burger King BBQ Beffbacon");
        burger5.setPrice(41000);
        bs.addToCart(burger5);

        Addition addition1 = new Addition();
        addition1.setId(1);
        addition1.setMenu("Coke");
        addition1.setPrice(7000);
        bs.addToCart(addition1);

        Addition addition2 = new Addition();
        addition2.setId(2);
        addition2.setMenu("Lemon Tea");
        addition2.setPrice(10000);
        bs.addToCart(addition2);

        Addition addition3 = new Addition();
        addition3.setId(3);
        addition3.setMenu("Mineral Water");
        addition3.setPrice(8000);
        bs.addToCart(addition3);

        Addition addition4 = new Addition();
        addition4.setId(4);
        addition4.setMenu("Cheesy Fries");
        addition4.setPrice(29000);
        bs.addToCart(addition4);

        Addition addition5 = new Addition();
        addition5.setId(1);
        addition5.setMenu("Waffle Fries");
        addition5.setPrice(22000);
        bs.addToCart(addition5);

        Cart cartt = new Cart();
        Cart cart = new BurgerStore(); //Polymorphism
        
        cartt.showMenuBurger();
        cart.showMenuBurger();
        bs.showBurger();
        cart.showMenuAddition();
        bs.showAddition();
        bs.buyBurger();
        bs.checkout(); 
    }
}