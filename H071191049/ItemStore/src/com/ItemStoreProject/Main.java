package com.ItemStoreProject;

import java.util.Scanner;
public class Main {
    static Scanner san = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("(Tugas MID PBO A MUH.IKHSAN)");
        System.out.println("---------------------------");
        mainMenu();
    }
    public static void mainMenu(){
        System.out.println(">> TOKO ITEM <<");
        System.out.println("[1] Login\n[2] Buat Akun\n[3] Exit");
        System.out.print("> ");
        int inp = san.nextInt();san.nextLine();
        switch (inp){
            case 1:
                loginMenu();
                break;
            case 2:
                buatAkun();
                break;
            case 3:
                return;
            default:
                System.out.println("Input Salah");
                mainMenu();

        }
    }
    //login Menu
    public static void loginMenu(){
        Login login = Login.getInstance();
        System.out.println(">> LOGIN <<");
        System.out.print("Username\t: ");
        String userName = san.nextLine();
        System.out.print("Password\t: ");
        String password = san.nextLine();
        if(login.check(userName,password)==true){
            Dashboard();
        }else{
            System.out.println("Username dan Kata Sandi tidak ditemukan");
            System.out.println("Login Gagal");
            System.out.println("[1]CobaLagi [2]Kembali [3]Keluar");
            System.out.print("> ");
            int inp = san.nextInt();san.nextLine();
            switch (inp){
                case 1:
                    loginMenu();
                    break;
                case 2:
                    mainMenu();
                    break;
                case 3:
                    return;
            }
        }
    }
    //BuatAkun
    public static void buatAkun(){}


    public static void Dashboard(){
        System.out.println(">> DASHBOARD <<");

    }
}
