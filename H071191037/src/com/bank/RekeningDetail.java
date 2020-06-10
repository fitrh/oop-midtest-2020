package com.bank;

public class RekeningDetail {
    private String name,rekening,bankName;

    public RekeningDetail(String name, String rekening, String bankName){
        this.name = name;
        this.bankName = bankName;
        this.rekening = rekening;
    }

    public String getRekening() {
        return rekening;
    }

    public String getBankName() {
        return bankName;
    }

    public String getName() {
        return name;
    }
}
