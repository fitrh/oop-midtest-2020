package com.ItemStoreProject;
import java.util.ArrayList;
public class User {
    //Attribut User
    private String name;
    private int money;
    ArrayList <Item> items;

    //Konnstruktor User
    User(String name, int money, ArrayList<Item> items){
        this.money = money;
        this.name = name;
        this.items = items;
    }
    //set money
    void setMoney(int money){
        this.money = money;
    }
    //getter
    String getName(){
        return name;
    }
    ArrayList<Item> getItems(){
        checkItem();
        return items;
    }
    Item getItem(int i){
        return items.get(i);
    }
    int getMoney(){
        return money;
    }

    //polymerpisme action
    public void action(){};

    //Item modifier
    void showItems(){
        checkItem();
        int i=0;
        System.out.println("-----------------------------");
        for (Item myItem:items){
            i++;
            System.out.printf("[%d] %s \n\tHarga : Rp.%d \n\tStock : %d\n",i,myItem.getName(),myItem.getPrice(), myItem.getKuantitas());
            System.out.println("-----------------------------");
        }
    }
    private void checkItem(){
        for (int i=0;i<items.size();i++){
            if(items.get(i).getKuantitas()<1){
                items.remove(i);
            }
        }
    }
    void setItem(int id, String itemName, int price, String info, int kuantitas){
        checkItem();
        boolean ada = false;
        for (Item item : items) {
            if (itemName.equals(item.getName())) {
                item.setKuantitas(item.getKuantitas() + kuantitas);
                ada = true;
                return;
            }
        }
        if(!ada){
            items.add(new Item(id, itemName,price,kuantitas,info));
        }
    }
}
