import java.util.ArrayList;
import java.io.Console;
import java.util.HashMap;
import java.util.HashSet;

public class Bank {
    private String bankName;
    private int bankCode;
    private ArrayList<Customer> customers = new ArrayList<>();
    private HashSet<Integer> registeredKTP = new HashSet<>();
    private void addCustomer(String username, char[] password, int accountNumber, int citizenIdentificationNum) {
        customers.add(new Customer(username, password, accountNumber, citizenIdentificationNum));
    }

    public void registerCustomer() {
        Console input = System.console();
        int citizenIdentificationNum = Integer.parseInt(input.readLine("Input KTP number : "));
        if (registeredKTP.contains(citizenIdentificationNum)){
            System.out.println("KTP number has already been registered!");
            return;
        }
        String username = input.readLine("Input full name : ");
        char[] password = input.readPassword("Input Password : ");
        System.out.println(new String(password));
        int accountNumber = Integer.parseInt( String.format("%03d%05d", bankCode, customers.size()) );
        addCustomer(username, password, accountNumber, citizenIdentificationNum);
        java.util.Arrays.fill(password, ' ');
    }
}
