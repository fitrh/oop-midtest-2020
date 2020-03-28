package com.bankingsystem.database;

import com.bankingsystem.transactionlog.Transaction;

import java.io.Console;
import java.util.ArrayList;

public class Portal {
    private static Portal portal;
    private final Database database;
    private Customer customer;
    private static final Console input = System.console();
    private Bank bank;


    private Portal() {
        database = Database.getInstance();
    }
    public static Portal getInstance() {
        if (portal == null) {
            portal = new Portal();
        }
        return portal;
    }

    private void login() {
        String accountNumber;
        while (true){
            clearScreen();
            System.out.println("===LOGIN===");
            try {
                accountNumber = input.readLine("Account number : ");
                if (accountNumber.equalsIgnoreCase("exit")) {
                    System.out.println("===========");
                    return;
                }
                customer = bank.getCustomer(Integer.parseInt(accountNumber));
                customer.validAccount(); //Checks if account is valid
                break;
            } catch (Exception e) {
                System.out.println("Invalid account number!");
                System.out.println("Type exit to cancel login");
                pause(1000);
            }
        }
        int triesLeft = 3;
        while (triesLeft >=0) {
            clearScreen();
            System.out.println("===LOGIN===");
            customer.login(input.readPassword("Password : "));
            if (customer.isAuthenticated()) {
                //if login is successful, then show bank menu
                System.out.println("===========");
                bankMenu();
                return;
            } else {
                System.out.println("Invalid password!");
                if (triesLeft == 0) {
                    //If user has run out of tries, then cancel login
                    return;
                }
                System.out.printf("Tries left : %d\n", triesLeft);
                triesLeft--;
                pause(1000);
            }
        }
    }

    private void bankMenu() {
        while (true) {
            if (customer == null) {
                return;
            }
            clearScreen();
            //Bank menu
            System.out.printf("====Bank %s====\n", bank.getBankName());
            System.out.printf("Hello, %s\n", customer.getUsername());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Change password");
            System.out.println("7. Logout");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(input.readLine("Choice : "));
                } catch (Exception e) {
                    System.out.println("Invalid choice!");
                }
                if (choice >= 1 && choice <= 7) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
            switch (choice) {
                case 1 :
                    deposit();
                    break;
                case 2 :
                    withdraw();
                    break;
                case 3 :
                    transfer();
                    break;
                case 4 :
                    balance();
                    break;
                case 5 :
                    printTransactionLog();
                    break;
                case 6:
                    changePassword();
                    break;
                case 7 :
                    logout();
                    return;
            }
        }
    }

    private void logout() {
        //Logsout customer and removes customer and it's respective bank data from portal
        customer.logout();
        customer = null;
        bank = null;
    }
    private void changePassword() {
        clearScreen();
        customer.changePassword(database);
        if (!customer.isAuthenticated()) { //if customer has been logged out for security reasons, then logout
            logout();
            pause(2000);
            return;
        }
        pause(1000);
    }

    private void printTransactionLog() {
        ArrayList<Transaction> transactionLog = customer.getTranactionLog();
        int page = 0;
        int totalPages = (int)Math.ceil((double)transactionLog.size()/2) == 0 ? 1 : (int)Math.ceil((double)transactionLog.size()/2);
        int choice = 0;
        while (true) {
            clearScreen();
            System.out.println("===Transaction History===");
            System.out.printf("Customer name  : %s\n", customer.getUsername());
            System.out.printf("Account number : %d\n", customer.getAccountNumber());
            for (int i = page*2; i < (page * 2) +2; i++) {
                if (i <= transactionLog.size()-1) {
                    //Handles array index out of bounds exception
                    System.out.println("-------------------------");
                    transactionLog.get(i).printDetails();
                    System.out.println("-------------------------");
                }
            }
            if (transactionLog.size() == 0) {
                System.out.println("No transactions available");
            }
            System.out.println("=========================");
            System.out.printf("Page %d/%d\n", page+1, totalPages);
            System.out.println("1. Previous Page");
            System.out.println("2. Next Page");
            System.out.println("3. Exit");
            try {
                choice = Integer.parseInt(input.readLine("Choice : "));
            } catch (Exception e) {
                System.out.println("Invalid choice");
                pause(1000);
            }
            if (choice == 1 && page > 0) {
                //previous page
                page--;
            } else if (choice == 2 && page < totalPages-1) {
                //next page
                page++;
            } else if (choice == 3) {
                //exit
                return;
            } else {
                System.out.println("Invalid choice");
                pause(1000);
            }
        }
    }

    private void withdraw() {
        clearScreen();
        System.out.println("===Withdraw===");
        int amount = Integer.parseInt(input.readLine("Input amount Rp."));
        if (customer.withdraw(amount)) {
            System.out.printf("Successfully withdrew Rp.%d from account number %d\n", amount, customer.getAccountNumber());
            updateTransactionLog(customer);
        } else {
            System.out.printf("Insufficient funds in account number %d\n", customer.getAccountNumber());
        }
        System.out.println("==============");
        pause(-1);
    }
    private void deposit() {
        clearScreen();
        System.out.println("===Deposit===");
        int amount = Integer.parseInt(input.readLine("Input amount Rp."));
        customer.deposit(amount);
        System.out.printf("Successfully deposited Rp.%d to account number %d\n", amount, customer.getAccountNumber());
        System.out.println("==============");
        updateTransactionLog(customer);
        pause(-1);
    }

    private void transfer() {
        while (true) {
            try {
                clearScreen();
                System.out.println("===Transfer===");
                printBanks();
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
                pause(1000);
            }
        }
        Customer recipient;
        while (true) {
            clearScreen();
            System.out.println("===Transfer===");
            try {
                String accountNumber = input.readLine("Transfer to (account number):");
                if (accountNumber.equalsIgnoreCase("exit")) {
                    System.out.println("===========");
                    return;
                }
                recipient= bank.getCustomer(Integer.parseInt(accountNumber));
                if (recipient == null || recipient.getAccountNumber() == customer.getAccountNumber()) {
                    System.out.println("Invalid account number");
                    System.out.println("Type exit to cancel");
                    pause(1000);
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid account number");
                System.out.println("Type exit to cancel");
                pause(1000);
            }
        }
        int amount;
        while (true) {
            clearScreen();
            System.out.println("===Transfer===");
            try {
                amount = Integer.parseInt(input.readLine("Input amount : Rp."));
                if (amount == 0) {
                    return;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid amount!");
                pause(1000);
            }
        }
        if (customer.outboundTransfer(amount, recipient)) {
            System.out.printf("Successfully transferred Rp.%d to account %d\n", amount, recipient.getAccountNumber());
            updateTransactionLog(customer);
            updateTransactionLog(recipient);
        } else {
            System.out.println("Insufficient funds!");
        }
        pause(-1);
    }

    protected void updateTransactionLog(Customer user) {
        //Update transaction log locally
        String destination = String.format("Banks/%s/Customers/%s.txt", user.getBank(), user.getAccountNumber());
        database.updateData(user.getLastTransactionDetails(), destination, true);
    }

    private void balance() {
        clearScreen();
        System.out.println("==============");
        System.out.printf("Account number : %d\n", customer.getAccountNumber());
        System.out.printf("Balance        : %d\n", customer.getBalance());
        System.out.println("==============");
        pause(-1);
    }

    public void welcomeScreen() {
        while (true) {
            clearScreen();
            database.printErrorLog();
            System.out.println("===BANKS===");
            printBanks();
            try {
                bank = database.getBank(Integer.parseInt(input.readLine("Choose a bank : "))-1);
                break;
            } catch (Exception e) {
                System.out.println("Invalid Bank!");
                System.out.println("===========");
                pause(1000);
            }
        }
        accessBank();
    }

    private void accessBank() {
        clearScreen();
        System.out.printf("===Welcome to Bank %s===\n", bank.getBankName());
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        switch (Integer.parseInt(input.readLine("Choice : "))) {
            case 1:
                login();
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
        //registers new user to a bank
        clearScreen();
        bank.registerCustomer(database);
        pause(-1);
    }
    private void printBanks() {
        //prints a list of banks
        for (int i = 0; i < database.getBanks().size(); i++) {
            System.out.printf("%d. %s\n", i+1, database.getBank(i).getBankName());
        }
    }
    private void clearScreen() {
        //"clears" screen
        //Hacky Solution
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause(long time) {
        //Pause program

        if (time == -1) {
            //waits for user input
            System.out.println("Type anything to continue...");
            input.readLine();
            return;
        }
        try {
            //wait for a set number of milliseconds
            Thread.sleep(time);
        } catch (InterruptedException ignored){

        }
    }



}
