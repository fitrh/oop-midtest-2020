package TransactionLog;

import java.util.Date;

public class Transaction {
    protected Date dateOfTransaction;
    protected int amount;
    protected int recipientOrigin;

    public Transaction(Date dateOfTransaction, int amount) {
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }
    public Transaction(Date dateOfTransaction, int amount, int recipientOrigin) {
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.recipientOrigin = recipientOrigin;
    }

    public void printDetails() {

    }
}
