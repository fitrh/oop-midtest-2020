package com.bank;

import java.io.IOException;
import java.util.Scanner;

public class Menu extends Login{
    Bank bankM = new MandaraBank();
    Bank bankC = new BACABank();
    Bank bankR = new BROBank();
    private Nasabah nasabah;
    private NasabahDetail nd;
    DataSource dataSource = new DataSource();
    Scanner inp = new Scanner(System.in);
    private int input;
    private boolean cek = true,next = true;

    public void bankMenu() throws IOException{
        System.out.println("\n\t---- Select Bank ----");
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
                    System.out.println("\n\n---- Mandara Bank ----");
                    System.out.printf("1. Deposit\n2. Take Money\n3. Transfer\n4. Activity\n5. Info Nasabah\n0. Exit\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : ");
                            bankM.menabung(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 2:
                            System.out.print("How much money to take : ");
                            bankM.mengambilUang(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuMandara();
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 4:
                            System.out.println("---- Activity ----");
                            menuBack();
                            break;
                        case 5:
                            System.out.println("---- Info Nasabah ----");
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
                    System.out.println("\n\n---- BACA Bank ----");
                    System.out.printf("1. Deposit\n2. Take Money\n3. Transfer\n4. Activity\n5. Info Nasabah\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : ");
                            bankC.menabung(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 2:
                            System.out.print("How much money to take : ");
                            bankC.mengambilUang(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuBACA();
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 4:
                            System.out.println("---- Activity ----");
                            menuBack();
                            break;
                        case 5:
                            System.out.println("---- Info Nasabah ----");
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
                    System.out.println("\n\n---- BRO Bank ----");
                    System.out.printf("1. Deposit\n2. Take Money\n3. Transfer\n4. Activity\n5. Info Nasabah\n");
                    System.out.print(">");
                    input = inp.nextInt();
                    switch (input) {
                        case 1:
                            System.out.print("Deposit : ");
                            bankR.menabung(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 2:
                            System.out.print("How much money to take : ");
                            bankR.mengambilUang(inp.nextInt());
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 3:
                            rekeningMenuBRO();
                            System.out.println("Thank you for Transaction");
                            menuBack();
                            break;
                        case 4:
                            System.out.println("---- Activity ----");
                            menuBack();
                            break;
                        case 5:
                            System.out.println("---- Info Nasabah ----");
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
        System.out.println("\n99. MENU\n0. KELUAR");
        System.out.print(">");
        input = inp.nextInt();
        switch (input) {
            case 99:
                cek = true;
                break;
            case 0:
                cek = false;
                break;
            default:
                System.out.println("---- Inputan invalid ----");
                break;
        }
    }

    public void rekeningMenuMandara() throws IOException {
        System.out.println("\n---- Select Bank ----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankM.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankM.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankM.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }

    public void rekeningMenuBACA() throws IOException {
        System.out.println("\n---- Select Bank ----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankC.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankC.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankC.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }

    public void rekeningMenuBRO() throws IOException {
        System.out.println("\n---- Select Bank ----");
        System.out.printf("1. Mandara Bank\n2. BACA Bank\n3. BRO Bank\n");
        System.out.print("Transfer to : ");
        String rn;
        Integer n;
        input = inp.nextInt();
        switch (input){
            case 1 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankR.transferToMandara(rn, n);
                break;
            case 2 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankR.transferToBACA(rn, n);
                break;
            case 3 :
                System.out.print("Rekening Number\t: ");
                rn = inp.next();
                System.out.print("Nominal\t: ");
                n = inp.nextInt();
                bankR.transferToBRO(rn, n);
                break;
            default :
                System.out.println("Invalid Input");
                break;
        }
    }
}
