package com.bank;

public class Nasabah {
    private String user,pin;
    private int id;

    public Nasabah (Integer id, String user, String pin){
        this.id = id;
        this.user = user;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public String getUser() {
        return user;
    }
}
