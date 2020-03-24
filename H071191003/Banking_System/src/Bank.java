import java.util.ArrayList;
import java.io.Console;

public class Bank {
    private String bankName;
    private int bankCode;
    private ArrayList<Customer> customers = new ArrayList<>();

    private void addCustomer(String username, char[] password, int accountNumber) {
        customers.add(new Customer(username, password, accountNumber));
    }

    public void registerCustomer() {
        Console input = System.console();
        String username = input.readLine("Input full name : ");
        char[] password = input.readPassword("Input Password : ");
        System.out.println(new String(password));
        int accountNumber = Integer.parseInt( String.format("%03d%05d", bankCode, customers.size()) );
        addCustomer(username, password, accountNumber);
        java.util.Arrays.fill(password, ' ');
    }
}
