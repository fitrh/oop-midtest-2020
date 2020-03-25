package TransactionLog;

import java.util.Date;

public class Withdrawal extends Transaction {
    public Withdrawal(Date dateOfTransaction, int amount) {
        super(dateOfTransaction, amount);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date : %s\n", dateOfTransaction);
        System.out.printf("Amount : %s\n", amount);
    }
}
