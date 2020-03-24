import java.util.Date;

public class Transaction {
    private int transactionType;
    private Date dateOfTransaction;
    private int amount;
    private int toFromAccountNumber;

    public Transaction(int transactionType, Date dateOfTransaction, int amount) {
        this.transactionType = transactionType;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
    }
    public Transaction(int transactionType, Date dateOfTransaction, int amount, int toFromAccountNumber) {
        this.transactionType = transactionType;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.toFromAccountNumber = toFromAccountNumber;
    }

    public void printDetails() {
        if (transactionType == 0) {
            //Deposit
            System.out.printf("Date of transaction \t: %s", dateOfTransaction);
            System.out.printf("Amount \t\t: %d", amount);
        } else if (transactionType == 1) {
            //Withdrawal
            System.out.printf("Date of transaction \t: %s", dateOfTransaction);
            System.out.printf("Amount \t\t: %d", amount);
        } else if (transactionType == 2) {
            //Transfer to
            System.out.printf("Date of transaction \t: %s", dateOfTransaction);
            System.out.printf("Destination account number\t: %d", toFromAccountNumber);
            System.out.printf("Amount \t\t: %d", amount);
        } else if (transactionType == 3) {
            //Transfer from
            System.out.printf("Date of transaction \t: %s", dateOfTransaction);
            System.out.printf("Origin account number\t: %d", toFromAccountNumber);
            System.out.printf("Amount \t\t: %d", amount);
        }
    }
}
