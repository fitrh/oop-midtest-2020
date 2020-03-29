package app;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static DataSource dataSource = new DataSource();
    static Player[] players;
    static StoreOwner[] owners;
    static Store[] stores;
    static ArrayList<Item> items;
    static int indexUser;
    public static void main(String[] args) {
        players = dataSource.getPlayer();
        owners = dataSource.getOwners();
        stores = dataSource.getStore();
        mainMenu();
    }
    //main Menu
    public static void mainMenu(){

        System.out.println("        -Item Store-        ");
        System.out.println("1. Mulai\n2. Keluar");
        System.out.print("Input Nilai : ");
      
        int inp = sc.nextInt();
        sc.nextLine();
        switch (inp){
            case 1:
                startMenu();
                break;
            case 2:
                return;
            default:
                System.out.println("Input Salah");
                mainMenu();
        }
    }

    //start Menu
    public static void startMenu(){
        System.out.println("-----------------------------");
        System.out.println("  PILIH USER ");
        System.out.println("-----------------------------");
        //daftar player
        int indexO = 1;
        for (int i=0;i<players.length;i++){
            if(players[i]==null){
                continue;
            }
            System.out.printf("%d. %s\n",indexO,players[i].getName());
            indexO++;
        }
        //daftar owner
        int index = indexO;
        for (int i=0;i<owners.length;i++){
            if(owners[i]==null){
                continue;
            }
            System.out.printf("%d. %s\n",index,owners[i].getName());
            index++;
        }
        indexUser = indexO;
        //tidak user
        if(indexO==1&&index==1){
            System.out.println(" TIDAK ADA USER ");
        }

        System.out.println("-----------------------------");
        System.out.printf("%d. Simpan dan Keluar\n",index);
        System.out.println("-----------------------------");
        //respond
        System.out.print("> ");
        int inp = sc.nextInt();
        if(inp==index){
            saveData();
        }
        //jika store owner yang terpilih
        else if(inp>=indexO){
            storeAction(inp-indexO);
            //jika player yang terpilih
        }else {
            playerAction(inp-1);
        }

    }

    //playerAction
    public static void playerAction(int i){
        players[i].action();
        items = players[i].getItems();
        System.out.print("> ");
        String input = sc.next();
        switch (input){
            case "i":
                System.out.println("-----------------------------");
                System.out.println("Item Ditawarkan");
                if(players[i].getPenawaran().getItemDitawarkan()==null){
                }else{
                    System.out.printf("%s dgn harga Rp.%d\n", players[i].getPenawaran().getItemDitawarkan().getName(), players[i].getPenawaran().getHargaPenawaran());
                }
                System.out.println("-----------------------------");
                if(!items.isEmpty()){
                    System.out.println("   Pilih Item ");
                    players[i].showItems();
                }
                else {
                    System.out.println("TIdak ada Item");
                    System.out.println("-----------------------------");
                }
                System.out.println("  [k] kembali");
                System.out.println("-----------------------------");
                System.out.print("> ");
                String inp = sc.next();
                if(inp.equals("k")){
                    playerAction(i);
                }
                itemAction(i, (Integer.parseInt(inp)-1));
                break;
            case "t":
                marketPlace(i);
                break;
            case "p":
                penawaranPlayer(i, 1);
                playerAction(i);
                break;
            case "b":
                players[i].createStore();
                break;
            case "h":
                delete(i,"p");
                System.out.println("User Berhasil Di Hapus");
                startMenu();
                break;
            case "k":
                startMenu();
                break;
            default :
                playerAction(i);
        }
    }
    //item action
    private static void itemAction(int indexPlayer, int indexItem) {
        System.out.println("-----------------------------");
        System.out.println("  "+items.get(indexItem).getName());
        System.out.println("-----------------------------");
        System.out.println("[j]Jual | [i]Info | [k]Kembali");
        System.out.println("-----------------------------");
        System.out.print("> ");
        String inp = sc.next();
        switch (inp){
            case "j":
                playerSellItem(indexItem, indexPlayer);
                playerAction(indexPlayer);
                break;
            case "i":
                System.out.println("-----------------------------");
                System.out.println("  "+items.get(indexItem).getInfo());
                System.out.println("-----------------------------");
                itemAction(indexPlayer, indexItem);
                break;
            case "k":
                playerAction(indexPlayer);
                break;
            default:
                itemAction(indexPlayer, indexItem);
        }
    }

    //ownerAction
    public static void storeAction(int i){
        owners[i].action();
        System.out.print("> ");
        String input = sc.next();
        switch (input){
            case "m":
                stores[i].myStore();
                modifMyStore(i);
                storeAction(i);
                break;
            case "p":
                penawaranPlayer(i, 0);
                storeAction(i);
                break;
            case "h":
                delete(i,"s");
                System.out.println("User Berhasil Di Hapus");
                startMenu();
                break;
            case "k":
                startMenu();
                break;
            default :
                storeAction(i);
        }
    }
    //player market place
    public static void marketPlace(int nowPlayer){
        System.out.println("-----------------------------");
        System.out.println("   PUSAT PENJUALAN");
        System.out.println("-----------------------------");
        for (int i=0;i<owners.length;i++){
            if(stores[i]==null){
                continue;
            }

            System.out.printf("%d. %s Store\n",(i+1),stores[i].getName());
            System.out.printf(stores[i].getMotto().equals("")?"":"   "+stores[i].getMotto()+"\n");
            System.out.println("   Owner : "+stores[i].getOwner().getName());
            System.out.println("-----------------------------");
        }
        System.out.print("> ");
        int inp = sc.nextInt();
        buyFromStore(inp-1, nowPlayer);
    }
    //store market
    public static void marketPlaceStore(int my){
        System.out.println("-----------------------------");
        System.out.println("   PUSAT PENJUALAN");
        System.out.println("-----------------------------");
        int index = 0;
        for (int i=0;i<owners.length;i++){
            if(stores[i]==null||i==my){
                continue;
            }
            System.out.printf("%d. %s\n",(index+1),stores[i].getName());
            System.out.printf(stores[i].getMotto().equals("")?"":"   |"+stores[i].getMotto()+"\n");
            System.out.println("   Owner : "+stores[i].getOwner().getName());
            index++;
        }
        System.out.print("> ");
        int input = sc.nextInt()-1;
        input=input>=my?input+1:input;
        storeFromStore(my, input);
    }

    //modif store
    public static void modifMyStore(int i){
        System.out.print("> ");
        String inp = sc.next();sc.nextLine();
        switch (inp){
            case "o":
                System.out.println("-----------------------------");
                System.out.println("  BUAT MOTTO ");
                System.out.println("-----------------------------");
                System.out.print("> ");
                String inp1 = sc.nextLine();
                stores[i].myMotto(inp1);
                storeAction(i);
                break;
            case "m":
                marketPlaceStore(i);
                break;
            case "b":
                storeAction(i);
                break;
            default:
                modifMyStore(i);
        }
    }

    //delete akun
    public static void delete(int i, String tipe){
        if(tipe.equals("p")){
            for(int j=i;j<players.length-1;j++){
                players[j]=players[j+1];

            }
            players[players.length-1]=null;
        }
        if(tipe.equals("s")){
            for(int j=i;j<owners.length-1;j++){
                owners[j]=owners[j+1];
                stores[j]=stores[j+1];
            }
            owners[owners.length-1]=null;
            stores[stores.length-1]=null;
        }
    }

    //Store buy from store
    public static void storeFromStore(int nowPlayer, int from) {
        System.out.println("-----------------------------");
        System.out.println("  " + stores[from].getName().toUpperCase());
        System.out.print(stores[from].getMotto().equals("") ? "" : "  \"" + stores[from].getMotto() + "\"\n");
        System.out.println("-----------------------------");
        owners[from].showItems();
        System.out.println("k. Kembali");
        System.out.println("-----------------------------");
        sc.nextLine();
        System.out.println("Pilih Item yg Ingin Dibeli");
        System.out.print("> ");
        String input = sc.next();
        if(input.equals("k")){
            storeAction(nowPlayer);
        }
        int inp = Integer.parseInt(input);
        System.out.println("Jumlah Pembelian");
        System.out.print("> ");
        int sum = sc.nextInt();
        System.out.println("-----------------------------");
        Item sell = owners[from].getItem(inp - 1);
        int itemPrice = sum > 5 ? (sell.getPrice() * 80 / 100) * sum : (sell.getPrice() * sum);
        if (itemPrice <= owners[nowPlayer].getMoney() && sell.getKuantitas()>=sum) {
            owners[nowPlayer].setMoney((owners[nowPlayer].getMoney())- itemPrice);
            owners[from].setMoney(owners[from].getMoney() + itemPrice);
            owners[nowPlayer].setItem(sell.getId(), sell.getName(), sell.getPrice(), sell.getInfo(),sum);
            owners[from].getItem(inp - 1).setKuantitas(sell.getKuantitas() - sum);
            stores[from].setPenjualan(stores[from].getPenjualan()+1);
            storeFromStore(nowPlayer,from);
        } else if(sell.getKuantitas()<sum){
            System.out.println("-----------------------------");
            System.out.println(" (!) Maaf Stok Tidak Cukup\n (!) Pembelian Gagal");
            System.out.println("-----------------------------");
            storeAction(nowPlayer);
        }else if(owners[nowPlayer].getMoney()<itemPrice) {
            System.out.println("-----------------------------");
            System.out.println(" (!) Maaf Stok Tidak Cukup\n (!) Pembelian Gagal");
            System.out.println("-----------------------------");
            storeAction(nowPlayer);
        }
    }
    //player buy from store
    public static void buyFromStore(int from, int nowPlayer){
        System.out.println("-----------------------------");
        System.out.println("  "+stores[from].getName().toUpperCase());
        System.out.print(stores[from].getMotto().equals("")?"":"  \""+stores[from].getMotto()+"\"\n");
        System.out.println("-----------------------------");
        owners[from].showItems();
        System.out.println("b. back");
        System.out.println("-----------------------------");
        sc.nextLine();
        System.out.print("> ");
        String input = sc.next();
        if(input.equals("b")){
            playerAction(nowPlayer);
        }
        int inp = Integer.parseInt(input);
        Item sell = owners[from].getItem(inp-1);
        if(sell.getPrice()<=players[nowPlayer].getMoney()){
            players[nowPlayer].setMoney((players[nowPlayer].getMoney())-(sell.getPrice()));
            owners[from].setMoney(owners[from].getMoney()+sell.getPrice());
            players[nowPlayer].setItem(sell.getId(),sell.getName(),sell.getPrice(),sell.getInfo(),1);
            owners[from].getItem(inp-1).setKuantitas(sell.getKuantitas()-1);
            System.out.println("-----------------------------");
            System.out.printf("(!) %s\n\tMembeli %s\n\tDari %s Store\n",players[nowPlayer].getName(),sell.getName(),stores[from].getName());
            System.out.println("-----------------------------");
            playerAction(nowPlayer);
        }else{
            System.out.println("-----------------------------");
            System.out.println(" (!) Maaf Uang anda tidak cukup\n (!) Pembelian Gagal");
            System.out.println("-----------------------------");
            playerAction(nowPlayer);

        }
    }
    public static void penawaranPlayer(int ind, int tipe){
        System.out.println(" DAFTAR PENAWARAN");
        boolean kosong = true;
        int index = 0;
        int[] nowIndex = new int[players.length];
        for(int i=0;i<players.length;i++){
            if((ind==i&&tipe==1)||players[i]==null||players[i].getPenawaran()==null||players[i].getPenawaran().getHargaPenawaran()==0){
                continue;
            }else{
                System.out.printf("%d. %s Menawarkan\n   %s Harga %d\n",(index+1),players[i].getName(), players[i].getPenawaran().getItemDitawarkan().getName(), players[i].getPenawaran().getHargaPenawaran());
                nowIndex[index]=i;
                index++;
                kosong = false;
            }
        }
        if(kosong == true){
            System.out.println("Tidak ada Penawaran");
            if(tipe==0){
                storeAction(ind);
            }
            else{
                playerAction(ind);
            }
        }else{
            System.out.print("> ");
            int input = sc.nextInt()-1;
            if(input>index){
                penawaranPlayer(ind, tipe);
            }
            input = nowIndex[input];
            Item item = players[input].getPenawaran().getItemDitawarkan();
            penawaranDiterima(ind, tipe, players[input], item);
        }
    }
    public static void playerSellItem(int ind, int i) {
        if (players[i].getPenawaran().getItemDitawarkan() == null) {
            System.out.println("Harga Penawaran");
            System.out.print("> ");
            int harga = sc.nextInt();
            if (harga < 0 || harga >= 200000) {
                System.out.println("Harga Tidak Wajar");
                playerSellItem(ind, i);
            }
            players[i].takeItemToPenawaran(ind, harga);
        }
        else{
            System.out.println("(!)Player Hanya Boleh\nMemiliki 1 Penawaran");
        }
    }

    public static void penawaranDiterima(int indexPlayerAktif, int tipe, Player playerPenawar, Item item){
        if(tipe==1){
            if(players[indexPlayerAktif].getMoney()<playerPenawar.getPenawaran().getHargaPenawaran()){
                System.out.println("(!) Uang anda tidak cukup");
                return;
            }
            players[indexPlayerAktif].setItem(item.getId(), item.getName(), item.getPrice(), item.getInfo(), item.getKuantitas());
            players[indexPlayerAktif].setMoney(players[indexPlayerAktif].getMoney()-playerPenawar.getPenawaran().getHargaPenawaran());
        }else{
            if(owners[indexPlayerAktif].getMoney()<playerPenawar.getPenawaran().getHargaPenawaran()){
                System.out.println("(!) Uang anda tidak cukup");
                return;
            }
            owners[indexPlayerAktif].setItem(item.getId(), item.getName(), item.getPrice(), item.getInfo(), item.getKuantitas());
            owners[indexPlayerAktif].setMoney(owners[indexPlayerAktif].getMoney()-playerPenawar.getPenawaran().getHargaPenawaran());
        }

        playerPenawar.setMoney(playerPenawar.getMoney()+playerPenawar.getPenawaran().getHargaPenawaran());
        playerPenawar.kosongkanPenawaran();
        System.out.println("Pembelian item berhasil");
    }
    //BuatAkun
    public static void createStore(int i){
    }
    //savedata
    public static void saveData(){
        dataSource.saveData(stores,owners,players);
        System.out.println("Data Berhasil Di save");

    }
}