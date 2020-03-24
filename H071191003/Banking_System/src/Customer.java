import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private String username;
    private char[] password;
    private int accountNumber;
    private ArrayList<String> accountLog;
    private boolean authenticated = false;

    public Customer(String username, char[] password, int accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public void Authenticate(char[] password) {
        if (Arrays.equals(this.password, password)) {
            authenticated = true;
        }
    }

}
