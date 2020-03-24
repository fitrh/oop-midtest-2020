import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private String username;
    private char[] password;
    private int accountNumber;
    private ArrayList<String> accountLog;
    private boolean authenticated = false;
    private int balance;

    public Customer(String username, char[] password, int accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public void Authenticate(char[] password) {
        if (Arrays.equals(this.password, password)) {
            authenticated = true;
        }
    }

    public void deposit(int amount) {
        if (authenticated) {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (authenticated) {
            balance -= amount;
        }
    }

    public void logout() {
        authenticated = false;
    }

    public void transfer(int amount, Customer recipient) {

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


}
