package com.bank;

import java.io.IOException;
import java.util.Scanner;

public class Login  {
    public boolean accept ;
    private  Nasabah nasabah;
    Scanner inp = new Scanner(System.in);

    public void menuMandara() throws IOException {
        System.out.println("\n----Login----");
        System.out.print("User : ");
        String userName = inp.next();
        System.out.print("pin : ");
        String pin = inp.next();
        auth("Nasabah_MandaraBank.txt",userName,pin);
    }

    public void menuBacaBank() throws IOException {
        System.out.println("\n----Login----");
        System.out.print("User : ");
        String userName = inp.next();
        System.out.print("pin : ");
        String pin = inp.next();
        auth("Nasabah_BACA-Bank.txt",userName,pin);
    }

    public void menuBroBank() throws IOException {
        System.out.println("\n----Login----");
        System.out.print("User : ");
        String userName = inp.next();
        System.out.print("pin : ");
        String pin = inp.next();
        auth("Nasabah_BRO-Bank.txt",userName,pin);
    }

    void auth(String filename,String userName, String pin) throws IOException {
        DataSource dataSource = new DataSource();
        nasabah = dataSource.getNasabahData(filename,userName);
        if (pin.equals(nasabah.getPin())){
            accept = true;
            System.out.print("Login Berhasil");

        } else {
            System.out.print("Login Gagal");
            return;
        }
    }


}
