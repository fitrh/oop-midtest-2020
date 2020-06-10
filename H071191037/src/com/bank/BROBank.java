package com.bank;

import java.io.IOException;

public class BROBank extends Bank {
    private RekeningDetail rekeningDetail;

    @Override
    public void setMoney(Integer money) {
        super.money = money;
    }

    @Override
    public int getMoney() {
        return super.money;
    }

    @Override
    public void menabung(int money) {
        super.money += money;
        super.activitylog.add("==================================="+"\n" +
                "  Transaction type  : Deposit" + "\n"+
                "  Amount            : " + money + "\n" +
                "===================================");
        System.out.println("Transaction Succes!");
    }

    @Override
    public void mengambilUang(int money) {
        if(super.money >= money){
            super.money -= money;
            super.activitylog.add("==================================="+"\n" +
                    "  Transaction type  : Witdrawal" + "\n"+
                    "  Amount            : " + money + "\n" +
                    "===================================");;
            System.out.println("Transaction Succes!");
        }
        else {
            System.out.println("Transaction Failed!");
        }
    }

    @Override
    public void transferToMandara(String rekening, int money) throws IOException {
        if(super.money < money){
            System.out.println("Transaction Failed!");
            return;
        }
        DataSource dataSource = new DataSource();
        rekeningDetail = dataSource.getRekening("Nasabah_MandaraBank.txt",rekening);
        info(money);
        super.activitylog.add("===================================" + "\n" +
                "  Transaction type  : Transfer  " + "\n" +
                "  To :" + "\n" +
                "  Bank Name         : " + rekeningDetail.getBankName() + "\n" +
                "  Name              : " + rekeningDetail.getName() + "\n" +
                "  Rekening          : " + rekeningDetail.getRekening() + "\n" +
                "  Amount            : " + money + "\n" +
                "===================================");
    }

    @Override
    public void transferToBACA(String rekening, int money) throws IOException {
        if(super.money < money){
            System.out.println("Transaction Failed!");
            return;
        }
        DataSource dataSource = new DataSource();
        rekeningDetail = dataSource.getRekening("Nasabah_BACA-Bank.txt",rekening);
        info(money);
        super.activitylog.add("===================================" + "\n" +
                "  Transaction type  : Transfer  " + "\n" +
                "  To :" + "\n" +
                "  Bank Name         : " + rekeningDetail.getBankName() + "\n" +
                "  Name              : " + rekeningDetail.getName() + "\n" +
                "  Rekening          : " + rekeningDetail.getRekening() + "\n" +
                "  Amount            : " + money + "\n" +
                "===================================");
    }

    @Override
    public void transferToBRO(String rekening, int money) throws IOException {
        if(super.money < money){
            System.out.println("Transaction Failed!");
            return;
        }
        DataSource dataSource = new DataSource();
        rekeningDetail = dataSource.getRekening("Nasabah_BRO-Bank.txt",rekening);
        info(money);
        super.activitylog.add("===================================" + "\n" +
                "  Transaction type  : Transfer  " + "\n" +
                "  To :" + "\n" +
                "  Bank Name         : " + rekeningDetail.getBankName() + "\n" +
                "  Name              : " + rekeningDetail.getName() + "\n" +
                "  Rekening          : " + rekeningDetail.getRekening() + "\n" +
                "  Amount            : " + money + "\n" +
                "===================================");
    }

    public void info(int money){
        if(rekeningDetail == null){
            System.out.println("Account not found!!");
        } else {
            super.money -= money;
            System.out.println("\n===========================================");
            System.out.println("Name             : " + rekeningDetail.getName());
            System.out.println("Bank Name        : " + rekeningDetail.getBankName());
            System.out.println("Nominal Transfer : " + money);
            System.out.println("===========================================");
        }
    }

    @Override
    public void getTransaksi() {
        for (String info: activitylog) {
            System.out.println(info);
        }
    }

}