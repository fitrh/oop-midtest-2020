package com.ItemStoreProject;
import java.util.ArrayList;
import java.util.Scanner;
class AllProcess extends Thread{
    private Scanner san = new Scanner(System.in);
    private DataSource dataSource = new DataSource();
    private Player[] players;
    private StoreOwner[] owners;
    private Store[] stores;
    private ArrayList<Item> items;

    void startApplication(){
        players = dataSource.getPlayer();
        owners = dataSource.getOwners();
        stores = dataSource.getStore();
        System.out.println("-----------------------------");
        System.out.println("  SIMULASI JUAL-BELI ITEM");
        System.out.println("-----------------------------");
        System.out.println("[1] Mulai\n[2] Keluar");
        System.out.println("-----------------------------");
        System.out.print("> ");
        int inp = san.nextInt();san.nextLine();
        switch (inp){
            case 1:
                startMenu();
                break;
            case 2:
                return;
            default:
                System.out.println("Input Salah");
                startApplication();
        }
    }
    //start Menu
    private void startMenu(){
        System.out.println("-----------------------------");
        System.out.println("  PILIH USER ");
        System.out.println("-----------------------------");
        //daftar player
        int indexO = 1;
        for (Player player : players) {
            if (player == null) {
                continue;
            }
            System.out.printf("[%d] %s\n",indexO,player.getName());
            indexO++;
        }
        //daftar owner
        int index = indexO;
        for (StoreOwner owner : owners) {
            if (owner == null) {
                continue;
            }
            System.out.printf("[%d] %s\n", index, owner.getName());
            index++;
        }
        int indexUser = indexO;
        //tidak user
        if(indexO==1&&index==1){
            System.out.println(" TIDAK ADA USER ");
        }
        System.out.println("-----------------------------");
        System.out.printf("[%d] Simpan dan Keluar\n",index);
        System.out.println("-----------------------------");
        //respond
        System.out.print("> ");
        int inp = san.nextInt();
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
    private void playerAction(int i){
        players[i].action();
        items = players[i].getItems();
        System.out.print("> ");
        String input = san.next();
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
                    System.out.println("Tidak ada Item");
                    System.out.println("-----------------------------");
                }
                System.out.println("  [0] kembali");
                System.out.println("-----------------------------");
                System.out.print("> ");
                int inp = san.nextInt();
                if(inp==0){
                    playerAction(i);
                }
                itemAction(i, inp-1);
                break;
            case "t":
                marketPlace(i, 1);
                break;
            case "p":
                penawaranPlayer(i, 1);
                playerAction(i);
                break;
            case "b":
                createStore(i);
                startMenu();
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
    //ownerAction
    private void storeAction(int i){
        owners[i].action();
        System.out.print("> ");
        String input = san.next();
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
            case "t":
                closeStore(i);
                startMenu();
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
    //item action
    private void itemAction(int indexPlayer, int indexItem) {
        System.out.println("-----------------------------");
        System.out.println("  "+items.get(indexItem).getName());
        System.out.println("-----------------------------");
        System.out.println("[j]Jual | [i]Info | [k]Kembali");
        System.out.println("-----------------------------");
        System.out.print("> ");
        String inp = san.next();
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
    //modif store
    private void modifMyStore(int i){
        System.out.print("> ");
        String inp = san.next();san.nextLine();
        switch (inp){
            case "o":
                System.out.println("-----------------------------");
                System.out.println("  BUAT MOTTO ");
                System.out.println("-----------------------------");
                System.out.print("> ");
                String inp1 = san.nextLine();
                stores[i].setMotto(inp1);
                storeAction(i);
                break;
            case "m":
                String code = players.getClass().toString().substring(0,1);
                marketPlace(i,0);
                break;
            case "b":
                storeAction(i);
                break;
            default:
                modifMyStore(i);
        }
    }
    //player market place
    private void marketPlace(int nowPlayer, int code){
        System.out.println("-----------------------------");
        System.out.println("   PUSAT PENJUALAN");
        System.out.println("-----------------------------");
        int index = 0;
        for (int i=0;i<owners.length;i++){
            if(stores[i]==null){
                continue;
            }
            if(code == 0 && i==nowPlayer){
                continue;
            }
            System.out.printf("[%d] %s\n",(index+1),stores[i].getName());
            System.out.print(stores[i].getMotto().equals("") ? "" : "   |" + stores[i].getMotto() + "\n");
            System.out.println("   |Star : "+stores[i].getStar());
            System.out.println("   |Owner : "+stores[i].getOwner().getName());
            index++;
        }
        System.out.print("> ");
        int inp = san.nextInt();
        inp=code==0&&inp>=nowPlayer?inp+1:inp;
        if(code==1){
            buyFromStore(inp-1, nowPlayer);
        }else{
            storeFromStore(nowPlayer, inp);
        }

    }
    //delete akun
    private void delete(int i, String tipe){
        saveData();
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
    //Store Membeli Di StoreLain
    private void storeFromStore(int nowPlayer, int from) {
        System.out.println("-----------------------------");
        System.out.println("  " + stores[from].getName().toUpperCase());
        System.out.print(stores[from].getMotto().equals("") ? "" : "  \"" + stores[from].getMotto() + "\"\n");
        System.out.println("-----------------------------");
        owners[from].showItems();
        System.out.println("[k] Kembali");
        System.out.println("-----------------------------");
        san.nextLine();
        System.out.println("Pilih Item yg Ingin Dibeli");
        System.out.print("> ");
        String input = san.next();
        if(input.equals("k")){
            storeAction(nowPlayer);
        }
        int inp = Integer.parseInt(input);
        System.out.println("Jumlah Pembelian");
        System.out.print("> ");
        int sum = san.nextInt();
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
    //player Buy from store
    private void buyFromStore(int from, int nowPlayer){
        System.out.println("-----------------------------");
        System.out.println("  "+stores[from].getName().toUpperCase());
        System.out.print(stores[from].getMotto().equals("")?"":"  \""+stores[from].getMotto()+"\"\n");
        System.out.println("-----------------------------");
        owners[from].showItems();
        System.out.println("[b] back");
        System.out.println("-----------------------------");
        san.nextLine();
        System.out.print("> ");
        String input = san.next();
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
    //Penawaram Player
    private void penawaranPlayer(int ind, int tipe){
        System.out.println(" DAFTAR PENAWARAN");
        boolean kosong = true;
        int index = 0;
        int[] nowIndex = new int[players.length];
        for(int i=0;i<players.length;i++){
            if((ind==i&&tipe==1)||players[i]==null||players[i].getPenawaran()==null||players[i].getPenawaran().getHargaPenawaran()==0){
                continue;
            }else{
                System.out.printf("[%d] %s Menawarkan\n   %s Harga %d\n",(index+1),players[i].getName(), players[i].getPenawaran().getItemDitawarkan().getName(), players[i].getPenawaran().getHargaPenawaran());
                nowIndex[index]=i;
                index++;
                kosong = false;
            }
        }
        if(kosong){
            System.out.println("Tidak ada Penawaran");
            if(tipe==0){
                storeAction(ind);
            }
            else{
                playerAction(ind);
            }
        }else{
            System.out.print("> ");
            int input = san.nextInt()-1;
            if(input>index){
                penawaranPlayer(ind, tipe);
            }
            input = nowIndex[input];
            Item item = players[input].getPenawaran().getItemDitawarkan();
            penawaranDiterima(ind, tipe, players[input], item);
        }
    }
    //Sell Item
    private void playerSellItem(int ind, int i) {
        if (players[i].getPenawaran().getItemDitawarkan() == null) {
            System.out.println("Harga Penawaran");
            System.out.print("> ");
            int harga = san.nextInt();
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
    //Penawaran Diterima
    private void penawaranDiterima(int indexPlayerAktif, int tipe, Player playerPenawar, Item item){
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
    //BuatStore
    private void createStore(int i){
        saveData();
        System.out.println("CREATE STORE");
        System.out.print("StoreName  : ");san.nextLine();
        String name = san.nextLine();
        System.out.print("StoreMotto : ");
        String motto = san.nextLine();
        ArrayList<Item> itemSum = players[i].getItems();
        if(players[i].getPenawaran().getItemDitawarkan()==null){}
        else{
            itemSum.add(players[i].getPenawaran().getItemDitawarkan());
        }
        StoreOwner tambahOwner = new StoreOwner(players[i].getName(), players[i].getMoney(), itemSum);
        Store tambahStore = new Store(tambahOwner,name, 0, motto);
        StoreOwner[] ownersNew = new StoreOwner[owners.length+1];
        Store storeNew[] = new Store[stores.length+1];
        Player[] playersNew = new Player[players.length-1];
        int index = 0;
        for(int j=0;j<playersNew.length;j++){
            if(players[j]==null){
                continue;
            }
            playersNew[index]=players[j];
            index++;
        }
        players=playersNew;
        System.out.println(players[0]);
        for (int j=0;j<owners.length;j++){
            ownersNew[j] = owners[j];
            storeNew[j] = stores[j];
        }
        ownersNew[owners.length] = tambahOwner;
        storeNew[stores.length] = tambahStore;
        stores = storeNew;
        owners = ownersNew;
        System.out.println("TOKO BERHASIL DIBUAT");
    }
    //Tutup Toko
    private void closeStore(int i){
        saveData();
        Player tambahPlayer = new Player(owners[i].getName(), owners[i].getMoney(), owners[i].getItems(),null, -1);
        Player[] playersNew = new Player[players.length+1];
        for (int j=0;j<players.length;j++){
            playersNew[j] = players[j];
        }
        playersNew[players.length-1] = tambahPlayer;
        players = playersNew;
        Store[] storesSementara = new Store[stores.length-1];
        StoreOwner[]ownersSementara = new StoreOwner[owners.length-1];
        int index = 0;
        owners[i]=null;
        stores[i]=null;
        for(int j=0;j<owners.length;j++){
            if(owners[j]==null){
                continue;
            }
            ownersSementara[index] = owners[j];
            storesSementara[index] = stores[j];
            index++;
        }
        stores = storesSementara;
        owners = ownersSementara;
        System.out.println("TOKO BERHASIL DITUTUP");
    }
    //savedata
    private void saveData(){
        SaveData saveData = new SaveData();
        dataSource.saveData(stores,owners,players);
        players = dataSource.getPlayer();
        owners = dataSource.getOwners();
        stores = dataSource.getStore();
        saveData.run();
    }
}
