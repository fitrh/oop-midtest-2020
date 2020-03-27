package com.bankingsystem.database;

import java.io.Console;

public class Portal {
    private static Portal portal;
    private Database database;
    private Customer customer;
    private static Console input = System.console();
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
            if (customer == null) {
                return;
            }
            clearScreen();
            System.out.printf("====Bank %s====\n", bank.getBankName());
            System.out.printf("Hello, %s\n", customer.getUsername());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Change password");
            System.out.println("7. Logout");
            int choice;
            while (true) {
                choice = Integer.parseInt(input.readLine("Choice : "));
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
        customer.logout();
        customer = null;
        bank = null;
    }
    private void changePassword() {
        clearScreen();
        customer.changePassword();
        if (!customer.isAuthenticated()) {
            logout();
            pause(2000);
            return;
        }
        pause(1000);
    }

    private void printTransactionLog() {
        clearScreen();
        customer.printTransactionLog();
        pause(-1);
    }

    private void withdraw() {
        clearScreen();
        System.out.println("===Withdraw===");
        int amount = Integer.parseInt(input.readLine("Input amount Rp."));
        if (customer.withdraw(amount)) {
            System.out.printf("Successfully withdrew Rp.%d from account number %d\n", amount, customer.getAccountNumber());
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
        pause(-1);
    }

    private void transfer() {
        while (true) {
            clearScreen();
            System.out.println("===Transfer===");
            printBanks();
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
                pause(1000);
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
        pause(-1);
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
        clearScreen();
        bank.registerCustomer();
        pause(-1);
    }
    private void printBanks() {
        for (int i = 0; i < database.getBanks().size(); i++) {
            System.out.printf("%d. %s\n", i+1, database.getBank(i).getBankName());
        }
    }
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause(long time) {
        if (time == -1) {
            System.out.println("Type anything to continue...");
            input.readLine();
            return;
        }
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored){

        }
    }



}
