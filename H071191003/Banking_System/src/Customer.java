import TransactionLog.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Customer {
    private String username;
    private char[] password;
    private int accountNumber;
    private ArrayList<Transaction> transactionLog;
    private boolean authenticated = false;
    private int balance;
    private int KTPNumber;

    public Customer(String username, char[] password, int accountNumber, int citizenIdentificationNam) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.KTPNumber = citizenIdentificationNam;
        balance = 0;
    }

    public void Authenticate(String password) {
        char[] charPassword = password.toCharArray();
        if (Arrays.equals(this.password, charPassword)) {
            authenticated = true;
        }
    }

    public void deposit(int amount) {
        if (authenticated) {
            balance += amount;
            transactionLog.add(new Deposit(new Date(), amount));
        }
    }

    public void withdraw(int amount) {
        if (authenticated) {
            balance -= amount;
            transactionLog.add(new Withdrawal(new Date(), amount));
        }
    }

    public void logout() {
        authenticated = false;
    }

    public void outboundTransfer(int amount, Customer recipient) {
        if (authenticated && balance >= amount){
            recipient.inboundTransfer(amount, accountNumber);
            balance -= amount;
            transactionLog.add(new OutboundTransfer(new Date(),amount, recipient.getAccountNumber()));
        }
    }

    private void inboundTransfer(int amount, int accountNumber) {
        balance += amount;
        transactionLog.add(new InboundTransfer(new Date(), amount, accountNumber));
    }


    public boolean getAuthenticationStatus() {
        return authenticated;
    }

    public void changePassword() {
        if (authenticated) {
            Console input = System.console();
            char[] oldPassword = input.readPassword("Input old password : ");
            if (Arrays.equals(this.password, oldPassword)) {
                java.util.Arrays.fill(oldPassword, ' ');
                char[] newPassword = input.readPassword("Input Password : ");
                password = newPassword;
                java.util.Arrays.fill(newPassword, ' ');
            } else {
                System.out.println("Invalid password!");
            }
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void printUserDetails() {
        if (authenticated){
            System.out.printf("Name : %s\n", username);
            System.out.printf("Citizen Identification Number : %d", KTPNumber);
            System.out.printf("Account number : %d", accountNumber);
        }
    }

    public void printTransactionLof() {
        if (authenticated) {
            Console input = System.console();
            System.out.println("===Transaction History===");
            System.out.println("1. Deposits");
            System.out.println("2. Withdrawals");
            System.out.println("3. Outbound Transfers");
            System.out.println("4. Inbound Transfers");
        }
    }
}
