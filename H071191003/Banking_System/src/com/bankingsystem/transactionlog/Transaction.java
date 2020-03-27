package com.bankingsystem.transactionlog;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Transaction {
    protected String dateOfTransaction;
    protected int amount;
    protected int recipientOrigin;

    public Transaction(Date dateOfTransaction, int amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss z");
        this.dateOfTransaction = formatter.format(dateOfTransaction);
        this.amount = amount;
    }
    public Transaction(Date dateOfTransaction, int amount, int recipientOrigin) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss z ");
        this.dateOfTransaction = formatter.format(dateOfTransaction);
        this.amount = amount;
        this.recipientOrigin = recipientOrigin;
    }

    abstract public void printDetails();
}
