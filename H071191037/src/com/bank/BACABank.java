package com.bank;

import java.io.IOException;

public class BACABank extends Bank {
    private int money ;

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void menabung(int money) {
        this.money += money;
    }

    @Override
    public void mengambilUang(int money) {
        this.money -= money;
    }

    @Override
    public void transfer(int money) {
        this.money -= money;
    }

    @Override
    public Nasabah getNasabahData(String fileName, String key) throws IOException {
        return super.getNasabahData(fileName, key);
    }
}
