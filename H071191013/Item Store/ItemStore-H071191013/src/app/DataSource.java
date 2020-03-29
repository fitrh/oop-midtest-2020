package app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataSource {

    StoreOwner[] owners = getOwners();
    private String baca (String namaFile) {
        Path path  = Paths.get("src/app/"+namaFile);
        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  fileContent;
    }
    //getPlayer
    public Player[] getPlayer() {
        String inputPlayer = baca("Player.txt");
        String inputItem = baca("Item.txt");
        String[] playerContent = inputPlayer.split("\\r?\\n");
        String[] itemContent = inputItem.split("\\r?\\n");
        Player[] player = new Player[playerContent.length];
        for (int i = 0; i < playerContent.length; i++) {
            ArrayList <Item> item = new ArrayList<>();
            Item itemPenawaran = null;
            String[] modifContent = playerContent[i].split(";");
            if(modifContent[2].equals("")||modifContent[2].equals("null")){}
            else {
                String[] daftarItem = modifContent[2].split("-");
                for (int j = 0; j < daftarItem.length; j++) {
                    String[] items = daftarItem[j].split(":");
                    String[] spekItem = itemContent[Integer.parseInt(items[0])].split(";");
                    item.add(new Item(Integer.parseInt(spekItem[0]), spekItem[1], Integer.parseInt(spekItem[2]), Integer.parseInt(items[1]), spekItem[3]));
                }
            }
            String[] itemP = new String[2];
            itemP[1]=String.valueOf(-1);
            if(modifContent.length!=4){}
            else{
                itemP = modifContent[3].split(":");
                String[] spekItem2 = itemContent[Integer.parseInt(itemP[0])].split(";");
                itemPenawaran = new Item(Integer.parseInt(spekItem2[0]),spekItem2[1], Integer.parseInt(spekItem2[2]),1, spekItem2[3]);
            }
            player[i] = new Player(modifContent[0], Integer.parseInt(modifContent[1]), item, itemPenawaran, Integer.parseInt(itemP[1]));
        }
        return player;
    }
    //getStore
    public StoreOwner[] getOwners() {
        String inputStore = baca("Owner.txt");
        String inputItem = baca("Item.txt");
        String[] storeContent = inputStore.split("\\r?\\n");
        String[] itemContent = inputItem.split("\\r?\\n");
        owners = new StoreOwner[storeContent.length];
        for (int i = 0; i < storeContent.length; i++) {
            ArrayList <Item> item = new ArrayList<>();
            String[] modifContent = storeContent[i].split(";");
            String[] daftarItem = modifContent[2].split("-");
            for (int j = 0; j < daftarItem.length; j++) {
                String[] items = daftarItem[j].split(":");
                String[] spekItem = itemContent[Integer.parseInt(items[0])].split(";");
                item.add(new Item(Integer.parseInt(spekItem[0]),spekItem[1], Integer.parseInt(spekItem[2]), Integer.parseInt(items[1]), spekItem[3]));
            }
            owners[i] = new StoreOwner(modifContent[0], Integer.parseInt(modifContent[1]), item);
        }
        return owners;
    }
    public Store[] getStore(){
        String inputStore = baca("Store.txt");
        String[] storeContent = inputStore.split("\\r?\\n");
        Store[] store = new Store[storeContent.length];
        for (int i = 0; i < storeContent.length; i++) {
            String[] modifContent = storeContent[i].split(";");
            store[i] = new Store(owners[Integer.parseInt(modifContent[0])], modifContent[1], Integer.parseInt(modifContent[2]), modifContent[3]);
        }
        return store;
    }
    public void saveData(Store[] updateStores, StoreOwner[] updateOwner, Player[] updatePlayer){
        Path playerPath = Paths.get("src/app/Player.txt");
        Path storePath = Paths.get("src/app/Store.txt");
        Path ownerPath = Paths.get("src/app/Owner.txt");
        String[] store = new String[updateStores.length];
        String[] player = new String [updatePlayer.length];
        String[] owner = new String [updateOwner.length];
        for(int i=0;i<updateStores.length;i++){
            if(updateStores[i]==null){
                store[i]="";
            }else {
                store[i] = i + ";" + updateStores[i].getName() + ";" + updateStores[i].getPenjualan() + ";" + updateStores[i].getMotto();
            }
        }
        for(int i=0;i<updatePlayer.length;i++){
            if(updatePlayer[i]==null){
                player[i]="";
            }else{
                player[i] = updatePlayer[i].getName()+";"+updatePlayer[i].getMoney()+";";
                for(int j=0;j<updatePlayer[i].getItems().size();j++){
                    player[i]+=updatePlayer[i].getItems().get(j).getId()+":"+updatePlayer[i].getItems().get(j).getKuantitas()+"-";
                }
                if(updatePlayer[i].getPenawaran().getItemDitawarkan()==null){
                    player[i]+=";";
                }else{
                    player[i] += ";"+updatePlayer[i].getPenawaran().getItemDitawarkan().getId()+":"+updatePlayer[i].getPenawaran().getHargaPenawaran();
                }
            }
        }
        for(int i=0;i<updateOwner.length;i++){
            if(updateOwner[i]==null){
                owner[i]="";
            }
            else{
                owner[i] = updateOwner[i].getName()+";"+updateOwner[i].getMoney()+";";
                for(int j=0;j<updateOwner[i].getItems().size();j++){
                    owner[i]+=updateOwner[i].getItems().get(j).getId()+":"+updateOwner[i].getItems().get(j).getKuantitas()+"-";
                }
            }
        }
        try {
            write(store, storePath);
            write(player, playerPath);
            write(owner, ownerPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void write(String[] input, Path pathIn) throws IOException {
        String in = "";
        for(int i=0;i<input.length;i++){
            in+=input[i]+"\n";
        }
        Files.write(pathIn,in.getBytes(StandardCharsets.ISO_8859_1));
        assert(Files.exists(pathIn));
    }
}