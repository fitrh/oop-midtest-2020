package com.bank;

import java.io.IOException;

public abstract class Bank {
    protected int money;

    public abstract void setMoney(Integer money);

    public abstract int getMoney();

    public abstract void menabung(int money);

    public abstract void mengambilUang(int money);

    public abstract void transferToMandara(String rekening,int money) throws IOException;

    public abstract void transferToBACA(String rekening,int money) throws IOException;

    public abstract void transferToBRO(String rekening,int money) throws IOException;

    public abstract void info(int money);
}
