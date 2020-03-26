package com.bankingsystem;

import com.bankingsystem.database.Portal;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Portal portal = Portal.getInstance();
        Console input = System.console();
        while (true) {
            try{
                System.out.println("===BANKS===");
                portal.printBanks();
                portal.accessBank(Integer.parseInt(input.readLine("Choose a bank : "))-1);
            } catch (Exception e) {
                System.out.println("Invalid Bank!");
                System.out.println("===========");
            }
        }
    }
}
