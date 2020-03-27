package app;

import java.util.ArrayList;
import java.util.List;

class Cart {
    protected List<Burger> items = new ArrayList();
    protected List<Addition> itemAdditions = new ArrayList();
    public void addToCart(Burger bm){
        items.add(bm);
    }
    public List<Burger> getItems(){
        return items;
    }

    public void addToCart(Addition a){
        itemAdditions.add(a);
    }
    public List<Addition> getAdditions(){
        return itemAdditions;
    }
    public void showMenuBurger() {
        System.out.println("=========================");
        System.out.println("BURGER STORE MENU");
    }
    public void showMenuAddition() {
        System.out.println("BURGER STORE MENU");
    }
}