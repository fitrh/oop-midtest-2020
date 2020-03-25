package com.bankingsystem;

import com.bankingsystem.transactionlog.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private String username;
    private String password;
    private int accountNumber;
    private ArrayList<Transaction> transactionLog;
    private boolean authenticated = false;
    private int balance;
    private int KTPNumber;

    public Customer(String username, String password, int accountNumber, int citizenIdentificationNam) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.KTPNumber = citizenIdentificationNam;
        balance = 0;
    }

    public void login(String password) {
        if (this.password.equals(password)) {
            authenticated = true;
        }
    }

    public void deposit(int amount) {
        if (authenticated) {
            balance += amount;
            transactionLog.add(new Deposit(new Date(), amount));
        }
    }

    public void withdraw(int amount) {
        if (authenticated) {
            balance -= amount;
            transactionLog.add(new Withdrawal(new Date(), amount));
        }
    }

    public void logout() {
        authenticated = false;
    }

    public void outboundTransfer(int amount, Customer recipient) {
        if (authenticated && balance >= amount){
            recipient.inboundTransfer(amount, accountNumber);
            balance -= amount;
            transactionLog.add(new OutboundTransfer(new Date(),amount, recipient.getAccountNumber()));
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
            String oldPassword = Arrays.toString(input.readPassword("Input old password : "));
            if (this.password.equals(oldPassword)) {
                password = Arrays.toString(input.readPassword("Input new password : "));
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
        if (authenticated) {
            return username;
        }
        return null;
    }
    public void printTransactionLog() {
        if (authenticated) {
            Console input = System.console();
            System.out.println("===Transaction History===");
            for (Transaction transaction:
                 transactionLog) {
                System.out.println("-------------------------");
                transaction.printDetails();
                System.out.println("-------------------------");
            }
        }
    }
}
