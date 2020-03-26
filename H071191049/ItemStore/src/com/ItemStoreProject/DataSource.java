package com.ItemStoreProject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataSource {
    private Map<String, Akun> akunMap = new HashMap<>();
    private User[] user;
    private Map<Integer, Store> storeMap = new HashMap<>();
    private Map<Integer, UserProperty> userPropertyMap = new HashMap<>();
    private Map<Integer, UserRequest> userRequest = new HashMap<>();
    private static DataSource instance;

    private DataSource(){
        try {
            putAkun();
            putUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private String baca (String namaFile) throws Exception{
        Path path  = Paths.get("src/com/ItemStoreProject/"+namaFile);
        String fileContent = new String(Files.readAllBytes(path), StandardCharsets.ISO_8859_1);
        return  fileContent;
    }

    private void putAkun() throws Exception {
        String inputAkun = baca("Akun.txt");
        String[] content = inputAkun.split("\\r?\\n");

        for (int i=0;i<content.length;i++) {
            String[] modifContent = content[i].split(";");
            int id = Integer.parseInt(modifContent[0]);
            akunMap.put(modifContent[1], (new Akun(id, modifContent[1], modifContent[2])));
        }
    }
    private void putUser() throws Exception {
        String inputUser = baca("User.txt");
        String[] content = inputUser.split("\\r?\\n");

        for (int i=0;i<content.length;i++) {
            Map <String, Integer> myItem = new HashMap<>();
            String[] modifContent = content[i].split(";");
            user = new User[content.length];
            String[] daftarItem = content[4].split(",");
            for(int j=0;j<daftarItem.length;j++){
                String[] item = daftarItem[i].split(":");
                myItem.put(item[0],Integer.parseInt(item[1]));
            }
            if(modifContent[0].equals("S")){
                user[i] = new StoreOwner(Integer.parseInt(modifContent[1]),modifContent[2],Integer.parseInt(modifContent[3]), myItem);
            }else if(modifContent[0].equals("P")){
                user[i] = new Player(Integer.parseInt(modifContent[1]),modifContent[2],Integer.parseInt(modifContent[3]), myItem);
            }
        }
    }
    public User getUser (int id){
        for(int i=0;i<user.length;i++){
            if(user[i].getId()==id){
                return user[i];
            }
        }
        return null;
    }
    public Akun getAkun (String name){
        return akunMap.get(name);
    }
}
