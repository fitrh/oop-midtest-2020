import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("  ITEM STORE    ");
        System.out.println(" ");

        System.out.println("Masukkan Player Name (no space)");
        String playerName = sc.next();
        System.out.println("Masukkan Player Money");
        double PlayerMoney = sc.nextDouble();
        User player = new User(playerName, PlayerMoney);
        player.setProduct(player.readProductList(
                "D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\PlayerItem.txt"));

        System.out.println("Masukkan StoreOwner Name (no space)");
        String storeOwnerName = sc.next();
        System.out.println("Masukkan StoreOwner Money");
        double storeOwnerMoney = sc.nextDouble();
        User storeOwner = new User();
        System.out.println("adding store owner item...");
        storeOwner.setProduct(storeOwner.readProductList(
                "D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\StoreOwnerItem.txt"));
        System.out.println("generating store...");
        Store store = new Store(myStore);
        System.out.println("adding store item...");
        store.setProduct(store);
                ("D:\\VisualStudioCode\\Java\\Semester_2\\OOP_Class\\Lecture\\MidTest\\StoreItem.txt"));
        System.out.println("all generate");

        Integer count = 1;

        Map<Integer, Item> playerItem = new HashMap<>();
        for (Item pItem : player.getItemList()) {
            playerItem.put(count, pItem);
            count++;
        }
        Map<Integer, Item> storeOwnerItem = new HashMap<>();
        for (Item soItem : storeOwner.getItemList()) {
            storeOwnerItem.put(count, soItem);
            count++;
        }
        Map<Integer, Item> storeItem = new HashMap<>();
        for (Item sItem : store.getItems()) {
            storeItem.put(count, sItem);
            count++;
        }

        while (true) {
            System.out.println("which role you want to use :");
            System.out.println("0. stop\n1.player\n2. store owner\n");
            switch (sc.nextInt()) {
                case 0:
                    System.out.println("Exit..");
                    return;
                case 1:
                    player.showStatus();
                    System.out.println("which action you want to use :");
                    System.out.println(
                            "1. buy from player\n2. buy from store\n3. sell from player\n4. sell from store\n");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Item list");
                            storeOwner.showItem();
                            System.out.println("which item you want to buy");
                            int itemChoose1 = sc.nextInt();
                            System.out.println("how much you want to buy");
                            int amount1 = sc.nextInt();
                            player.buyFromUser(storeOwnerItem.get(itemChoose1),amount1 , storeOwner);

                            break;
                        
                        case 2:
                            System.out.println("Item list");
                            store.myStore();
                            System.out.println("which item you want to buy");
                            int itemChoose2 = sc.nextInt();
                            System.out.println("how much you want to buy");
                            int amount2 = sc.nextInt();
                            player.buyFromUser(storeItem.get(itemChoose2),amount2 , storeOwner);

                            break;

                        case 3:
                            System.out.println("Item list");
                            player.showItem();
                            System.out.println("which item you want to sell");
                            int itemChoose3 = sc.nextInt();
                            System.out.println("how much you want to sell");
                            int amount3 = sc.nextInt();
                            player.sellToOwner(playerItem.get(itemChoose3),amount3, storeOwner);

                            break;

                        case 4:
                            System.out.println("Item list");
                            player.showItem();
                            System.out.println("which item you want to buy");
                            int itemChoose4 = sc.nextInt();
                            System.out.println("how much you want to buy");
                            int amount4 = sc.nextInt();
                            player.sellToStore(playerItem.get(itemChoose4),amount4, store);

                            break;

                        default:
                            break;
                    }
                        break;
                case 2:
                player.showStatus();
                System.out.println("which action you want to use :");
                System.out.println(
                        "1. buy from player\n2. buy from store\n3. sell from player\n4. sell from store\n");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Item list");
                        storeOwner.showItem();
                        System.out.println("which item you want to buy");
                        int itemChoose1 = sc.nextInt();
                        System.out.println("how much you want to buy");
                        int amount1 = sc.nextInt();
                        storeOwner.buyFromUser(playerItem.get(itemChoose1),amount1 , player);

                        break;
                    
                    case 2:
                        System.out.println("Item list");
                        store.myStore();
                        System.out.println("which item you want to buy");
                        int itemChoose2 = sc.nextInt();
                        System.out.println("how much you want to buy");
                        int amount2 = sc.nextInt();
                        storeOwner.buyFromStore(storeItem.get(itemChoose2),amount2 , store);

                        break;

                    case 3:
                        System.out.println("Item list");
                        player.showItem();
                        System.out.println("which item you want to sell");
                        int itemChoose3 = sc.nextInt();
                        System.out.println("how much you want to sell");
                        int amount3 = sc.nextInt();
                        storeOwner.sellToOwner(storeOwnerItem.get(itemChoose3),amount3, player);

                        break;

                    case 4:
                        System.out.println("Item list");
                        player.showItem();
                        System.out.println("which item you want to buy");
                        int itemChoose4 = sc.nextInt();
                        System.out.println("how much you want to buy");
                        int amount4 = sc.nextInt();
                        storeOwner.sellToStore(storeItem.get(itemChoose4),amount4, store);

                        break;

                    default:
                        break;
                }
                    break;
                default:
                    break;
            }
        }

    }
}