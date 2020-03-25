package com.bankingsystem.database;
import com.bankingsystem.Bank;
import com.bankingsystem.Customer;
import java.io.Console;
import java.util.Arrays;

public class Portal {
    private static Portal portal;
    private Database database;
    private static Customer customer;

    private Portal() {
        database = Database.getInstance();
    }
    public Portal getInstance() {
        if (portal == null) {
            portal = new Portal();
        }
        return portal;
    }

    private void login(Bank bank) {
        Console input = System.console();
        System.out.println("===LOGIN===");
        System.out.print("Account number : ");
        int accountNumber = Integer.parseInt(input.readLine("Account number : "));
        String password = Arrays.toString(input.readPassword("Password : "));
        customer = bank.getCustomer(accountNumber);
        customer.login(password);
        if (customer.isAuthenticated()) {
            userActions();
        } else {
            System.out.println("Invalid password!");
        }
    }
    private void userActions() {
        Console input = System.console();
        System.out.printf("Hello, %s", customer.getUsername());
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Transaction History");
        System.out.println("5. Logout");
        int choice;
        while (true) {
            choice = Integer.parseInt(input.readLine("Choice : "));
            if (choice >= 1 && choice <=4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        int amount;
        switch (choice) {
            case 1 :
                amount = Integer.parseInt(input.readLine());
                customer.deposit(amount);
                break;
            case 2 :
                amount = Integer.parseInt(input.readLine());
                customer.withdraw(amount);
                break;
            case 3 :

                break;
            case 4 :
                break;
            case 5 :
                customer.logout();
        }

    }

    public void accessBank(int index) {
        Console input = System.console();
        Bank bank = database.getBank(index);
        System.out.printf("===Welcome to Bank %s===", bank.getBankName());
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        switch (Integer.parseInt(input.readLine())) {
            case 1:
                login(bank);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Invaid ");
        }
    }

    private int printBanks() {
        System.out.println("===BANKS===");
        for (int i = 0; i < database.getBanks().size(); i++) {
            System.out.printf("%d. %s", i+1, database.getBank(i).getBankName());
        }
        return database.getBanks().size();
    }


}
