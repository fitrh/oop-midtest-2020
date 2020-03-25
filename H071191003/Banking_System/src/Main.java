import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        System.out.println(database.getBank(1).getCustomer(1000001).getAuthenticationStatus());
        database.getBank(1).getCustomer(1000001).Authenticate("12efg4");
        System.out.println(database.getBank(1).getCustomer(1000001).getAuthenticationStatus());
    }
}
