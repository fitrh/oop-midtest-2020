package com.company;

import java.util.HashMap;

public class Pustakawan extends Person{
    public void addAnggota(String username, String nama, String password){
        HashMap hashmap = new HashMap();
        hashmap.put("username","'"+username+"'");
        hashmap.put("password","'"+password+"'");
        hashmap.put("nama","'"+nama+"'");
        hashmap.put("role","3");

        boolean isSuccess= DBHelper.insert("Person",hashmap);
        if (isSuccess){
            System.out.println("Data Anggota Berhasil Ditambahkan");
        }else {
            System.out.println("Data Anggota Gagal Ditambahkan");
        }
    }


}
