package com.ItemStoreProject;

import java.util.ArrayList;
public class Player extends User implements PenawaranProperty {
    private Penawaran penawaran;
    //Konstruktor Player
    Player(String name, int money, ArrayList<Item> items, Item itemPenawaran, int hargaItem) {
        super(name, money, items);
        penawaran = new Penawaran();
        if(itemPenawaran!=null){
            penawaran.setItem(itemPenawaran);
            penawaran.setPrice(hargaItem);
        }
    }
    //Overiding Method dari User
    @Override
    public void action() {
        System.out.println("-----------------------------");
        System.out.println("  "+getName().toUpperCase());
        System.out.println("  Status : Player");
        System.out.println("-----------------------------");
        System.out.println("  Cash Rp."+ getMoney());
        System.out.println("-----------------------------");
        System.out.println("[i] Item");
        System.out.println("[t] Toko");
        System.out.println("[p] Penawaran Player");
        System.out.println("[b] Buat Toko");
        System.out.println("[h] Hapus Akun");
        System.out.println("[k] Kembali");
        System.out.println("-----------------------------");
    }
    //Penawaran Modif dari PenawranProperty
    public void takeItemToPenawaran(int indexitem, int price){
        if(items.get(indexitem)!=null&&penawaran.getItemDitawarkan()==null){
            penawaran.setItem(items.get(indexitem));
            penawaran.setPrice(price);
            items.remove(indexitem);
        }
    }
    public Penawaran getPenawaran(){
        return penawaran;
    }
    public void kosongkanPenawaran(){
        penawaran = new Penawaran();
    }
}
