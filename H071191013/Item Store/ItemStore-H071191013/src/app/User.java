package app;
import java.util.ArrayList;
public class User {
    protected String name;
    protected int money;
    protected ArrayList <Item> items;
    //konstruktor User
    public User(String name, int money, ArrayList<Item> items2){
        this.money = money;
        this.name = name;
        this.items = items2;
    }
    //set money
    public void setMoney(int money){
        this.money = money;
    }
    //getter
    public String getName (){
        return name;
    }
    public ArrayList<Item> getItems (){
        checkItem();
        return items;
    }
    public Item getItem(int i){
        return items.get(i);
    }
    public int getMoney(){
        return money;
    }

    //polymerpisme action
    public void action(){};

    //Item modif
    public void showItems (){
        checkItem();
        int i=0;
        System.out.println("-----------------------------");
        for (Item myItem:items){
            i++;
            System.out.printf("[%d] %s \n\tHarga : Rp.%d \n\tStock : %d\n",i,myItem.getName(),myItem.getPrice(), myItem.getKuantitas());
            System.out.println("-----------------------------");
        }
    }
    public void checkItem(){
        for (int i=0;i<items.size();i++){
            if(items.get(i).getKuantitas()<1){
                items.remove(i);
            }
        }
    }
    public void setItem (int id, String itemName, int price, String info, int kuantitas){
        checkItem();
        boolean ada = false;
        for (int i=0;i<items.size();i++){
            if(itemName.equals(items.get(i).getName())){
                items.get(i).setKuantitas(items.get(i).getKuantitas()+kuantitas);
                ada = true;
                return;
            }
        }
        if(ada==false){
            items.add(new Item(id, itemName,price,kuantitas,info));
        }
    }

    public void sellItem(int i){
        items.remove(i);
    }
}
