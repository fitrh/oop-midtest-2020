package com.bankingsystem;

import com.bankingsystem.database.Portal;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Portal portal = Portal.getInstance();
        Console input = System.console();
        while (true) {
            portal.welcomeScreen();
        }
    }
}
