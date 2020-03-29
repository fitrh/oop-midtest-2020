import java.util.ArrayList;
import java.util.List;

class Store {
    private User owner;
    private List<Item> items;
    private String name;
    private int sell;
    private int star;

    public Store(User owner, List<Item> items, String name, int sell) {
        this.owner = owner;
        items = new ArrayList<>();
        this.name = name;
        this.sell = sell;
    }
    public User getOwner() {
        return owner;
    }
    public String getName() {
        return name;
    }
    public List<Item> getItems() {
        return items;
    }
    public int getSell() {
        return sell;
    }
    public int getStar() {
        return star;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setSell(int sell) {
        this.sell = sell;
    }
    public void theStar() {
        if (sell <= 1) {
            star = 1;
        } else if (sell <= 2) {
            star = 2;
        } else if (sell <= 3) {
            star = 3;
        }

    public void myStore(){
        ArrayList <Item> items = owner.getItemList();
        System.out.println("-----------------------------");
        System.out.println("\tMY STORE ");
        System.out.println("-----------------------------");
        System.out.println("Name : "+name);
        System.out.println("Star : "+star);
        System.out.println("-----------------------------");
        for(int j=0;j<items.size();j++){
        System.out.println( (j+1)+". "+items.get(j).getName()+"\n\tStok : "+items.get(j).getQuantity());
        }
    }
    
}