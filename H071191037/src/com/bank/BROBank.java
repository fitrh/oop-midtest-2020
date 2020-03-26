package com.bank;

import java.io.IOException;

public class BROBank extends Bank {
    @Override
    public void setMoney(int money) {

    }

    @Override
    public int getMoney() {
        return 0;
    }

    @Override
    public void menabung(int money) {

    }

    @Override
    public void mengambilUang(int money) {

    }

    @Override
    public void transfer(int money) {

    }

    @Override
    public Nasabah getNasabahData(String fileName, String key) throws IOException {
        return super.getNasabahData(fileName, key);
    }
}
