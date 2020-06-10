package com.bankingsystem.transactionlog;

import java.util.Date;

public class OutboundTransfer extends Transaction {

    //Outbound transfer : transfer of money to another user
    public OutboundTransfer(Date dateOfTransaction, int amount, int recipientOrigin) {
        super(dateOfTransaction, amount, recipientOrigin);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date              : %s\n", dateOfTransaction);
        System.out.println("Transaction type  : Outbound Transfer");
        System.out.printf("Amount            : %s\n", amount);
        System.out.printf("To                : %s\n", recipientOrigin);
    }

    @Override
    public String getDetails() {
        return String.format("2;%s;%d;%d",dateOfTransaction,amount, recipientOrigin);
    }
}
