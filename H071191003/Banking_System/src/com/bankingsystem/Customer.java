package com.bankingsystem;

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

    public Customer(String username, char[] password, int accountNumber, int citizenIdentificationNam) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.KTPNumber = citizenIdentificationNam;
        balance = 0;
        transactionLog = new ArrayList<>();
    }
    public int getBalance() {
        return balance;
    }
    public void login(char[] password) {
        if (Arrays.equals(this.password, password)) {
            authenticated = true;
        }
    }

    public void deposit(int amount) {
        if (authenticated) {
            balance += amount;
            transactionLog.add(new Deposit(new Date(), amount));
        }
    }

    public boolean withdraw(int amount) {
        if (authenticated && balance >= amount) {
            balance -= amount;
            transactionLog.add(new Withdrawal(new Date(), amount));
            return true;
        }
        return false;
    }

    public void logout() {
        authenticated = false;
    }

    public boolean outboundTransfer(int amount, Customer recipient) {
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


    public boolean isAuthenticated() {
        return authenticated;
    }

    public void changePassword() {
        if (authenticated) {
            Console input = System.console();
            char[] oldPassword = input.readPassword("Input old password : ");
            if (Arrays.equals(this.password, oldPassword)) {
                password = input.readPassword("Input new password : ");
            }
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void printUserDetails() {
        if (authenticated){
            System.out.printf("Name : %s\n", username);
            System.out.printf("Citizen Identification Number : %d", KTPNumber);
            System.out.printf("Account number : %d", accountNumber);
        }
    }
    public String getUsername() {
        return username;
    }
    public void printTransactionLog() {
        if (authenticated) {
            System.out.println("===Transaction History===");

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
}
