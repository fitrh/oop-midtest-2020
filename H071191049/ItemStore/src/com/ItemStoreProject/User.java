package com.ItemStoreProject;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int money;

    public User(int id, String name, int money, Map<String, Integer> myItem){
        this.id = id;
        this.money = money;
        this.name = name;
    }
    public int getId (){
        return id;
    }
    public String getName (){
        return name;
    }
    public int getMoney (){
        return money;
    }
//    public Item getItem (){
//        return Item;
//    }
}
