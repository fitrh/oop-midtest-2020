package com.bank;

import java.io.IOException;
import java.util.Scanner;

public class Menu extends Login{
    private Bank bankM = new MandaraBank();
    private Bank bankC = new BACABank();
    private Bank bankR = new BROBank();
    Scanner inp = new Scanner(System.in);

    private int input;
    private boolean cek = true;

    public void bankMenu() throws IOException{
        System.out.println("\n\t----- Select Bank -----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print(">");
        input = inp.nextInt();
        switch (input){
            case 1 :
                /* user : ali
                 *  pin  : 212121
                 * */
                menuMandara();
                if(!super.accept){
                    return;
                }
                tobank(bankM);
                do {
                    System.out.println("\n\n\t----- Mandara Bank -----");
                    System.out.printf("1. Deposit\n2. Withdrawal\n3. Transfer\n4. Activity\n5. Info Nasabah\n0. Exit\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : Rp.");
                            bankM.menabung(inp.nextInt());
                            menuBack();
                            break;
                        case 2:
                            System.out.print("Withdrawal : Rp.");
                            bankM.mengambilUang(inp.nextInt());
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuMandara();
                            menuBack();
                            break;
                        case 4:
                            infoNasabah();
                            bankM.getTransaksi();
                            menuBack();
                            break;
                        case 5:
                            info(bankM);
                            menuBack();
                            break;
                        case 0:
                            cek = false;
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                } while (cek);
                break;
            case 2 :
                /* user  : agus
                 *  pin  : 222222
                 * */
                menuBacaBank();
                if(!super.accept){
                    return;
                }
                tobank(bankC);
                do {
                    System.out.println("\n\n\t----- BACA Bank -----");
                    System.out.printf("1. Deposit\n2. Withdrawal\n3. Transfer\n4. Activity\n5. Info Nasabah\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : Rp.");
                            bankC.menabung(inp.nextInt());
                            menuBack();
                            break;
                        case 2:
                            System.out.print("Withdrawal : Rp.");
                            bankC.mengambilUang(inp.nextInt());
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuBACA();
                            menuBack();
                            break;
                        case 4:
                            infoNasabah();
                            bankC.getTransaksi();
                            menuBack();
                            break;
                        case 5:
                            info(bankC);
                            menuBack();
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                } while (cek);
                break;
            case 3 :
                /* user : dodi
                 * pin  : 222223
                 * */
                menuBroBank();
                if(!super.accept){
                    return;
                }
                tobank(bankR);
                do {
                    System.out.println("\n\n\t----- BRO Bank -----");
                    System.out.printf("1. Deposit\n2. Withdrawal\n3. Transfer\n4. Activity\n5. Info Nasabah\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : Rp.");
                            bankR.menabung(inp.nextInt());
                            menuBack();
                            break;
                        case 2:
                            System.out.print("Withdrawal : Rp.");
                            bankR.mengambilUang(inp.nextInt());
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuBRO();
                            menuBack();
                            break;
                        case 4:
                            infoNasabah();
                            bankR.getTransaksi();
                            menuBack();
                            break;
                        case 5:
                            info(bankR);
                            menuBack();
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                } while (cek);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public void menuBack(){
        System.out.println("\n99. Menu\n0. Exit");
        System.out.print(">");
        input = inp.nextInt();
        switch (input) {
            case 99:
                cek = true;
                break;
            case 0:
                cek = false;
                System.out.println("----- Thank you for Transaction -----");
                break;
            default:
                cek = false;
                System.out.println("----- Inputan invalid -----");
                break;
        }
    }

    public void rekeningMenuMandara() throws IOException {
        System.out.println("\n\t----- Select Bank -----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankM.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankM.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankM.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }

    public void rekeningMenuBACA() throws IOException {
        System.out.println("\n\t----- Select Bank -----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankC.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankC.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankC.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }

    public void rekeningMenuBRO() throws IOException {
        System.out.println("\n\t----- Select Bank -----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankR.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankR.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: Rp.");
                n = inp.nextInt();
                bankR.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }

}
