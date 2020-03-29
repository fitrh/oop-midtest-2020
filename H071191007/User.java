import java.util.ArrayList;

class User {
    private int money;
    private ArrayList<Item> itemList;
    private String name;

    public User(int money, ArrayList<Item> itemList, String name) {
        this.money = money;
        this.name = name;
        this.itemList = itemList;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public String getName() {
        return name;
    }

    public Item getItem(int j) {
        return itemList.get(j);
    }

    public void checkItem() {
        for (int j = 0; j < itemList.size(); j++) {
            if (itemList.get(j).getQuantity() < 1) {
                itemList.remove(j);
            }
        }
    }

    public void showItem() {
        checkItem();
        int count = 1;
        for (Item item : itemList) {
            System.out.println(count + ". " + " (" + item.getQuantity() + ") \t" + item.getPrice() + " $" + "\t"
                    + item.getDetail());
            count++;
        }
        System.out.println();
    }

    public void setItem(int price, int quantity, String detail, String name) {
        checkItem();
        boolean cek = false;
        for (int j=0;j<itemList.size();j++) {
            if(name.equals(itemList.get(j).getName())){
                itemList.get(j).setQuantity(itemList.get(j).getQuantity()+quantity);
                cek = true;
                return;
            }
        }
        if (cek == false){
            itemList.add(new Item(price, quantity, name, detail));
        }
    }
    public void showStatus(){
        System.out.println("Name\t: " + name);
        System.out.println("Money\t: " + money);
    }
    public void sellToOwner(Item sellItems, int stock, User costumer){
        if (costumer.getMoney() >= sellItems.getPrice() * stock) {
            money += sellItems.getPrice() *stock;
            costumer.setMoney(costumer.getMoney() - sellItems.getPrice() *stock);
            costumer.setItem(sellItems, stock);
        } else {
            System.out.println(costumer.getName() + " money is not enough");
        }
        public void sellToStore(Item sellItems, int stock, Store costumer){
            if (costumer.getOwner().getMoney() >= sellItems.getPrice() * stock) {
                money += sellItems.getPrice() *stock;
                costumer.getOwner().setMoney(costumer.getOwner().getMoney() - sellItems.getPrice() *stock);
                costumer.setItem(sellItems, stock);
                
            } else {
                System.out.println(costumer.getOwner().getName() + " money is not enough");
            }
        }
        public void buyFromStore(Item items, int quantity, Store owner) {
            if (money >= items.getPrice() * quantity && items.getQuantity() >= quantity) {
                money -= items.getPrice() * quantity;
                owner.getOwner().setMoney(owner.getOwner().getMoney() + items.getPrice() * quantity);
            } else {
                System.out.println(items.getQuantity() >= quantity ? "" : "stock doesnt enough");
                System.out.println(money >= items.getPrice() * quantity ? "" : "money doesnt enough");
            }
        }
    }

