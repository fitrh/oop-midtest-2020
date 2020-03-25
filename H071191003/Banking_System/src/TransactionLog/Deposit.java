package TransactionLog;

import java.util.Date;

public class Deposit extends Transaction {
    public Deposit(Date dateOfTransaction, int amount) {
        super(dateOfTransaction, amount);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date : %s\n", dateOfTransaction);
        System.out.printf("Amount : %s\n", amount);
    }
}
