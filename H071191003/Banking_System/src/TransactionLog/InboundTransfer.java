package TransactionLog;

import java.util.Date;

public class InboundTransfer extends Transaction {
    public InboundTransfer(Date dateOfTransaction, int amount, int recipientOrigin) {
        super(dateOfTransaction, amount, recipientOrigin);
    }

    @Override
    public void printDetails() {
        System.out.printf("Date : %s\n", dateOfTransaction);
        System.out.printf("Amount : %s\n", amount);
        System.out.printf("From : %s\n", recipientOrigin);
    }
}
