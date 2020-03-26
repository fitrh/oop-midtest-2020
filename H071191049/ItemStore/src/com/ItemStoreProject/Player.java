package com.ItemStoreProject;

import java.util.HashMap;
import java.util.Map;

public class Player extends User {

    public Player(int id, String name, int money, Map<String, Integer> myItem) {
        super(id, name, money, myItem);
    }
}
