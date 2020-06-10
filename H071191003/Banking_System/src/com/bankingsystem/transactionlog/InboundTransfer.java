package com.bankingsystem.transactionlog;

import java.util.Date;

public class InboundTransfer extends Transaction {

    //Inbound transfer : transfer of money from another user
    public InboundTransfer(Date dateOfTransaction, int amount, int recipientOrigin) {
        super(dateOfTransaction, amount, recipientOrigin);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date              : %s\n", dateOfTransaction);
        System.out.println("Transaction type  : Inbound Transfer");
        System.out.printf("Amount            : %s\n", amount);
        System.out.printf("From              : %s\n", recipientOrigin);
    }
    @Override
    public String getDetails() {
        return String.format("3;%s;%d;%d",dateOfTransaction,amount, recipientOrigin);
    }
}
