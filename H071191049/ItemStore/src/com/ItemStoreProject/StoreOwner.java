package com.ItemStoreProject;
import java.util.ArrayList;
public class StoreOwner extends User{
    //Constructor StoreOwner
    StoreOwner(String name, int money, ArrayList<Item> items) {
        super(name, money, items);
    }
    //Overiding Method
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
        System.out.println("[t] Tutup Toko");
        System.out.println("[h] Hapus Akun");
        System.out.println("[k] Kembali");
        System.out.println("-----------------------------");
    }
}
