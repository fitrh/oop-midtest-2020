package com.bankingsystem.transactionlog;

import java.util.Date;

public class Withdrawal extends Transaction {
    public Withdrawal(Date dateOfTransaction, int amount) {
        super(dateOfTransaction, amount);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date              : %s\n", dateOfTransaction);
        System.out.println("Transaction type  : Withdrawal");
        System.out.printf("Amount            : %s\n", amount);
    }

    @Override
    public String getDetails() {
        return String.format("1;%s;%d",dateOfTransaction,amount);
    }
}
