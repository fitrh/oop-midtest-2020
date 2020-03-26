package com.bankingsystem.database;
import com.bankingsystem.Bank;
import com.bankingsystem.Customer;
import java.io.Console;
import java.util.Arrays;

public class Portal {
    private static Portal portal;
    private Database database;
    private static Customer customer;
    private static Console input = System.console();


    private Portal() {
        database = Database.getInstance();
    }
    public static Portal getInstance() {
        if (portal == null) {
            portal = new Portal();
        }
        return portal;
    }

    private void login(Bank bank) {
        System.out.println("===LOGIN===");
        String accountNumber;
        while (true){
            try {
                accountNumber = input.readLine("Account number : ");
                if (accountNumber.equalsIgnoreCase("exit")) {
                    System.out.println("===========");
                    return;
                }
                customer = bank.getCustomer(Integer.parseInt(accountNumber));
                customer.getAccountNumber(); //Checks if account is valid
                break;
            } catch (Exception e) {
                System.out.println("Invalid account number!");
                System.out.println("Type exit to cancel login");
            }
        }
        int triesLeft = 3;
        while (triesLeft >=0) {
            customer.login(input.readPassword("Password : "));
            if (customer.isAuthenticated()) {
                System.out.println("===========");
                userActions();
                return;
            } else {
                System.out.println("Invalid password!");
                if (triesLeft == 0) {
                    return;
                }
                System.out.printf("Tries left : %d\n", triesLeft);
                triesLeft--;
            }
        }
    }

    private void userActions() {
        while (true) {
            System.out.printf("Hello, %s\n", customer.getUsername());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Logout");
            int choice;
            while (true) {
                choice = Integer.parseInt(input.readLine("Choice : "));
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
            int amount;
            switch (choice) {
                case 1 :
                    System.out.println("===Deposit===");
                    amount = Integer.parseInt(input.readLine("Input amount Rp."));
                    customer.deposit(amount);
                    System.out.printf("Successfully deposited Rp.%d to account number %d\n", amount, customer.getAccountNumber());
                    System.out.println("==============");
                    break;
                case 2 :
                    System.out.println("===Withdraw===");
                    amount = Integer.parseInt(input.readLine("Input amount Rp."));
                    if (customer.withdraw(amount)) {
                        System.out.printf("Successfully withdrew Rp.%d from account number %d\n", amount, customer.getAccountNumber());
                    } else {
                        System.out.printf("Insufficient funds in account number %d\n", customer.getAccountNumber());

                    }
                    System.out.println("==============");
                    break;
                case 3 :
                    transfer();
                    break;
                case 4 :
                    balance();
                    break;
                case 5 :
                    customer.printTransactionLog();
                    break;
                case 6 :
                    customer.logout();
                    return;
            }
        }
    }
    private void transfer() {
        System.out.println("===Transfer===");
        printBanks();
        Bank bank;
        while (true) {
            try {
                String bankCode = input.readLine("Input bank code : ");
                if (bankCode.equalsIgnoreCase("exit")) {
                    System.out.println("===========");
                    return;
                }
                bank = database.getBank(Integer.parseInt(bankCode)-1);
                break;
            } catch (Exception e) {
                System.out.println("Invalid bank code");
                System.out.println("Type exit to cancel");
            }
        }
        Customer recipient;
        while (true) {
            try {
                String accountNumber = input.readLine("Transfer to (account number):");
                if (accountNumber.equalsIgnoreCase("exit")) {
                    System.out.println("===========");
                    return;
                }
                recipient= bank.getCustomer(Integer.parseInt(accountNumber));
                if (recipient == null) {
                    System.out.println("Invalid account number");
                    continue;
                } else if (recipient.getAccountNumber() == customer.getAccountNumber()) {
                    System.out.println("Invalid account number");
                    System.out.println("Type exit to cancel");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid bank code");
            }
        }
        int amount;
        while (true) {
            try {
                amount = Integer.parseInt(input.readLine("Input amount : Rp."));
                if (amount == 0) {
                    return;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid amount!");
            }
        }
        if (customer.outboundTransfer(amount, recipient)) {
            System.out.printf("Successfully transferred Rp.%d to account %d\n", amount, recipient.getAccountNumber());
        } else {
            System.out.println("Insufficient funds!");
        }

    }

    private void balance() {
        System.out.println("==============");
        System.out.printf("Balance : %d\n", customer.getBalance());
        System.out.println("==============");
    }

    public void accessBank(int index) {
        Bank bank = database.getBank(index);
        System.out.printf("===Welcome to Bank %s===\n", bank.getBankName());
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        switch (Integer.parseInt(input.readLine("Choice : "))) {
            case 1:
                login(bank);
                break;
            case 2:
                register();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid");
        }
    }
    public void register() {

    }
    public void printBanks() {
        for (int i = 0; i < database.getBanks().size(); i++) {
            System.out.printf("%d. %s\n", i+1, database.getBank(i).getBankName());
        }
    }


}
