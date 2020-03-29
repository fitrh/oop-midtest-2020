package app;
public class Penawaran{
    private int idPlayer;
    private Item itemDitawarkan;
    private int hargaPenawaran;

    //setter
    public void setItem(Item item){
        itemDitawarkan = item;
    }
    public void setPrice(int price){
        hargaPenawaran = price;
    }
    //getter
    public int getIdPlayer(){
        return idPlayer;
    }
    public Item getItemDitawarkan(){
        return itemDitawarkan;
    }
    public int getHargaPenawaran(){
        return hargaPenawaran;
    }
}