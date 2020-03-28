package com.bankingsystem.database;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Bank {
    private final String bankName;
    private final int bankCode;
    private final HashMap<Integer, Customer> customers ;
    private final HashSet<Integer> registeredKTP;

    protected Bank(String bankName, int bankCode, HashMap<Integer, Customer> customers, HashSet<Integer> registeredKTP) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.customers = customers;
        this.registeredKTP = registeredKTP;
    }
    private void addCustomer(String username, char[] password, int accountNumber, int KTPNumber) {
        customers.put(accountNumber ,new Customer(username, password, accountNumber, KTPNumber, new ArrayList<>(),0,bankName));
    }

    protected void registerCustomer(Database database) {
        Console input = System.console();
        int KTPNumber;
        try {
            while (true) {
                clearScreen();
                System.out.printf("====Bank %s====\n", getBankName());
                KTPNumber = Integer.parseInt(input.readLine("Input KTP number : "));
                if (Integer.toString(KTPNumber).length() < 6) {
                    System.out.println("Invalid KTP number!");
                } else if (registeredKTP.contains(KTPNumber)){
                    //if ktp already exists in the bank system
                    System.out.println("KTP number has already been registered!");
                    return;
                } else {
                    break;
                }
                pause();
            }
        } catch (Exception e) {
            System.out.println("Registration failed!");
            return;
        }

        String username;
        while (true) {
            clearScreen();
            System.out.printf("====Bank %s====\n", getBankName());
            username = input.readLine("Input full name : ");
            if (username.equals("/exit")) {
                //exit
                return;
            } else if (!username.equals("")){
                break;
            }else {
                System.out.println("Invalid name!");
            }
            pause();
        }
        char[] password;
        while (true) {
            clearScreen();
            System.out.printf("====Bank %s====\n", getBankName());
            password = input.readPassword("Input Password : ");
            if (Arrays.toString(password).equals("/exit")) {
                //exit
                return;
            } else if (isValidPassword(password)) {
                break;
            } else {
                System.out.println("Password must be 6 characters long!");
            }
            pause();
        }
        int accountNumber = Integer.parseInt( String.format("%d%06d", bankCode, customers.size()+1) );
        addCustomer(username, password, accountNumber, KTPNumber);
        String destination = String.format("Banks/%s/Customers/%s.txt", bankName, accountNumber);
        //Prepares user data to be saved locally
        String temp = String.format("%s;%s;%d;%d", username, String.valueOf(password), accountNumber, KTPNumber);
        database.updateData(temp, destination,false);
        registeredKTP.add(KTPNumber);
        System.out.println("Success!");
        pause();
        clearScreen();
        //Displays the account overview
        System.out.println("===Account Overview===");
        System.out.printf("Customer name : %s\n", username);
        System.out.printf("Account Number: %s\n", accountNumber);
        System.out.printf("Bank          : %s\n", bankName);
        System.out.println("======================");
    }

    private boolean isValidPassword(char[] password) {
        return password.length >= 6;
    }

    protected String getBankName() {
        return bankName;
    }

    protected Customer getCustomer(int accountNumber) {
        return customers.get(accountNumber);
    }

    private void clearScreen() {
        //"clears" screen
        //Hacky Solution
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause() {
        //Pause program
        try {
            //wait for a 1 of second
            Thread.sleep(1000);
        } catch (InterruptedException ignored){

        }
    }

}
