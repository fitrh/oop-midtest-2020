package com.bankingsystem.database;

import com.bankingsystem.transactionlog.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private String username;
    private char[] password;
    private int accountNumber;
    private ArrayList<Transaction> transactionLog;
    private boolean authenticated = false;
    private int balance;
    private int KTPNumber;

    protected Customer(String username, char[] password, int accountNumber, int citizenIdentificationNam, ArrayList<Transaction> transactionLog, int balance) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.KTPNumber = citizenIdentificationNam;
        this.balance = balance;
        this.transactionLog = transactionLog;
    }
    protected int getBalance() {
        if (authenticated) {
            return balance;
        }
        return 0;
    }
    protected void login(char[] password) {
        if (Arrays.equals(this.password, password)) {
            authenticated = true;
        }
        Arrays.fill(password, '0');
    }

    protected void deposit(int amount) {
        if (authenticated) {
            balance += amount;
            transactionLog.add(new Deposit(new Date(), amount));
        }
    }

    protected boolean withdraw(int amount) {
        if (authenticated && balance >= amount) {
            balance -= amount;
            transactionLog.add(new Withdrawal(new Date(), amount));
            return true;
        }
        return false;
    }

    protected void logout() {
        authenticated = false;
    }

    protected boolean outboundTransfer(int amount, Customer recipient) {
        if (authenticated && balance >= amount){
            balance -= amount;
            recipient.inboundTransfer(amount, accountNumber);
            transactionLog.add(new OutboundTransfer(new Date(), amount, recipient.getAccountNumber()));
            return true;
        } else {
            return false;
        }
    }

    private void inboundTransfer(int amount, int accountNumber) {
        balance += amount;
        transactionLog.add(new InboundTransfer(new Date(), amount, accountNumber));
    }


    protected boolean isAuthenticated() {
        return authenticated;
    }
    protected void validAccount() {
        //Checks if an account isn't null
    }

    protected void changePassword() {
        if (authenticated) {
            Console input = System.console();
            int tries = 3;
            while (tries >= 0) {
                clearScreen();
                char[] oldPassword = input.readPassword("Input old password : ");
                if (Arrays.equals(this.password, oldPassword)) {
                    Arrays.fill(oldPassword, '0');
                    password = input.readPassword("Input new password : ");
                    System.out.println("Password successfully changed");
                    pause();
                    return;
                } else {
                    System.out.println("Invalid password!");
                    tries--;
                    pause();
                }
            }
            System.out.println("You have been logged out for security reasons, please re login");
            authenticated = false;
        }
    }

    protected int getAccountNumber() {
        return accountNumber;
    }

    protected void printUserDetails() {
        if (authenticated){
            System.out.printf("Name : %s\n", username);
            System.out.printf("Citizen Identification Number : %d", KTPNumber);
            System.out.printf("Account number : %d", accountNumber);
        }
    }
    protected String getUsername() {
        return username;
    }

    protected void printTransactionLog() {
        if (authenticated) {
            System.out.println("===Transaction History===");
            System.out.printf("Customer name  : %s\n", getUsername());
            System.out.printf("Account number : %d\n", getAccountNumber());
            for (Transaction transaction:
                 transactionLog) {
                System.out.println("-------------------------");
                transaction.printDetails();
                System.out.println("-------------------------");
            }
            if (transactionLog.size() == 0) {
                System.out.println("No transactions available");
            }
            System.out.println("=========================");
        }
    }
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored){

        }

    }

}
