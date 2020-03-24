import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        ArrayList<Bank> banks = new ArrayList<>();
        banks.add(new Bank());
        banks.get(0).registerCustomer();
    }
}
