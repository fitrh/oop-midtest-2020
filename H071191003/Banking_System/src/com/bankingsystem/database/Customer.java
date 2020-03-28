package com.bankingsystem.database;

import com.bankingsystem.transactionlog.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private final String username;
    private char[] password;
    private final int accountNumber;
    private final ArrayList<Transaction> transactionLog;
    private boolean authenticated = false;
    private int balance;
    private final int KTPNumber;
    private final String bank;

    protected Customer(String username, char[] password, int accountNumber, int KTPNumber, ArrayList<Transaction> transactionLog, int balance, String bank) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.KTPNumber = KTPNumber;
        this.balance = balance;
        this.transactionLog = transactionLog;
        this.bank = bank;
    }

    public String getBank() {
        return bank;
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
            updateTransactionLog(new Deposit(new Date(), amount));
        }
    }

    protected boolean withdraw(int amount) {
        if (authenticated && balance >= amount) {
            balance -= amount;
            updateTransactionLog(new Withdrawal(new Date(), amount));
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
            updateTransactionLog(new OutboundTransfer(new Date(), amount, recipient.getAccountNumber()));
            return true;
        } else {
            return false;
        }
    }
    private void updateTransactionLog(Transaction transaction) {
        transactionLog.add(transaction);
    }

    protected String getLastTransactionDetails() {
        return transactionLog.get(transactionLog.size()-1).getDetails();
    }
    private void inboundTransfer(int amount, int accountNumber) {
        balance += amount;
        updateTransactionLog(new InboundTransfer(new Date(), amount, accountNumber));
    }


    protected boolean isAuthenticated() {
        return authenticated;
    }
    @SuppressWarnings("EmptyMethod")
    protected void validAccount() {
        //Checks if an account isn't null
    }

    protected void changePassword(Database database) {
        if (authenticated) {
            Console input = System.console();
            int tries = 3;
            while (tries >= 0) {
                clearScreen();
                System.out.println("===Change Password===");
                char[] oldPassword = input.readPassword("Input old password : ");
                if (Arrays.equals(this.password, oldPassword)) {
                    Arrays.fill(oldPassword, '0');
                    while (true) {
                        clearScreen();
                        System.out.println("===Change Password===");
                        password = input.readPassword("Input new password : ");
                        if (password.length >=6) {
                            break;
                        } else {
                            System.out.println("Invalid password");
                            pause();
                        }
                    }
                    System.out.println("Password successfully changed");
                    String destination = String.format("Banks/%s/Customers/%s.txt",bank, accountNumber);
                    database.updateUserPassword(String.valueOf(password), destination);
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

    protected String getUsername() {
        return username;
    }

    protected ArrayList<Transaction> getTranactionLog() {
        if (authenticated) {
            return transactionLog;
        }
        return null;
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
