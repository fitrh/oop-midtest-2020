package app;
import java.util.ArrayList;

public class Store{
    private String name;
    private String motto = "";
    private int penjualan;
    private int star;
    private StoreOwner owner;
    public Store(StoreOwner owner, String name, int penjualan, String motto){
        this.owner = owner;
        this.name = name;
        this.penjualan = penjualan;
        this.motto = motto;
        myStar();
    }
    public void setPenjualan (int penjualan){
        this.penjualan = penjualan;
    }
    public int getPenjualan(){
        return penjualan;
    }
    public void myMotto(String motto) {
        this.motto = motto;
    }
    public void myStar() {
        if(penjualan<=1){
            star = 1;
        }else if(penjualan<=3){
            star = 2;
        }else if(penjualan<=5){
            star = 3;
        }else if(penjualan<=7){
            star = 4;
        }else {
            star = 5;
        }
    }
    public String getName(){
        return name;
    }
    public String getMotto (){
        return motto;
    }
    public int getStar(){
        myStar();
        return star;
    }
    public StoreOwner getOwner(){
        return owner;
    }
    public void myStore(){
        ArrayList <Item> items = owner.getItems();
        System.out.println("-----------------------------");
        System.out.println("\tMY STORE ");
        System.out.println("-----------------------------");
        System.out.println("Name : "+name);
        System.out.println("Star : "+star);
        System.out.println("-----------------------------");
        for(int i=0;i<items.size();i++){
            System.out.println( (i+1)+". "+items.get(i).getName()+"\n\tStok : "+items.get(i).getKuantitas());
        }
        System.out.println("-----------------------------");
        System.out.println("[o] Ubah Motto");
        System.out.println("[m] Market Place");
        System.out.println("[b] Back");
        System.out.println("-----------------------------");
    }
}
