package com.bank;

public class NasabahDetail {
    private Integer id,money;
    private String bankName,name,rekening,userName,pin;

    public NasabahDetail(Integer id,Integer money,String bankName, String name, String rekening, String userName, String pin) {
        this.id = id;
        this.money = money;
        this.bankName = bankName;
        this.name = name;
        this.rekening = rekening;
        this.userName = userName;
        this.pin = pin;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPin() {
        return pin;
    }

    public String getRekening() {
        return rekening;
    }

    public void info(){
        System.out.println("Name           : "+ getName());
        System.out.println("Money          : "+ getMoney());
        System.out.println("Bank Name      : "+ getBankName());
        System.out.println("Rekening Number: "+ getRekening());
        System.out.println("User           : "+ getUserName());
        System.out.println("Pin            : "+ getPin());
    }
}
