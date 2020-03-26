package com.ItemStoreProject;

public class Akun {
    private int id;
    private String userName;
    private String password;

    public Akun(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public boolean authPassword (String password){
        if(this.password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}

