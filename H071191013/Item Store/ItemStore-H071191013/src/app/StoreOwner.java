package app;
import java.util.ArrayList;
public class StoreOwner extends User{
    public StoreOwner(String name, int money, ArrayList<Item> items) {
        super(name, money, items);
    }
    @Override
    public void action() {
        System.out.println("-----------------------------");
        System.out.println("  "+getName().toUpperCase());
        System.out.println("  Status : Store Owner");
        System.out.println("-----------------------------");
        System.out.println("  Modal Rp.: "+ getMoney());
        System.out.println("-----------------------------");
        System.out.println("[m] Tokoku");
        System.out.println("[p] Penawaran Player");
        System.out.println("[h] Hapus Akun");
        System.out.println("[k] Kembali");
        System.out.println("-----------------------------");
    }
}