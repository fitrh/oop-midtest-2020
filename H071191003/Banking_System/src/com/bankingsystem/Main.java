package com.bankingsystem;

import com.bankingsystem.database.Portal;

public class Main {
    public static void main(String[] args) {
        Portal portal = Portal.getInstance();
        //noinspection InfiniteLoopStatement
        while (true) {
            portal.welcomeScreen();
        }
    }
}
