package com.bank;

public class Nasabah {
    private String user,pin;
    private Integer id;

    public Nasabah (Integer id, String user, String pin){
        this.id = id;
        this.user = user;
        this.pin = pin;
    }

    public Integer getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

}
