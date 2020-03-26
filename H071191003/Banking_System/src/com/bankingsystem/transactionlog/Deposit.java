package com.bankingsystem.transactionlog;

import java.util.Date;

public class Deposit extends Transaction {
    public Deposit(Date dateOfTransaction, int amount) {
        super(dateOfTransaction, amount);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date              : %s\n", dateOfTransaction);
        System.out.println("Transaction type  : Deposit");
        System.out.printf("Amount            : %s\n", amount);
    }
}
