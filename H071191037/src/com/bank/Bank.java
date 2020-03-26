package com.bank;

public abstract class Bank extends DataSource{

    public abstract void setMoney(int money);

    public abstract int getMoney();

    public abstract void menabung(int money);

    public abstract void mengambilUang(int money);

    public abstract void transfer(int money);
}
