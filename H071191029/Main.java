package Project.Bank.BankandUser;
import java.util.Scanner;

import Project.Bank.BankandUser.BankNegaraIndonesia;

public class Main {
    static Scanner ww = new Scanner(System.in);
    static boolean done = false;
    static BankNegaraIndonesia nasabah;

    public static void main(String[] args) throws Exception {
        nasabah = new BankNegaraIndonesia();
        int amount;
        loginMenu();
        System.out.print("Username : ");
        String userName = ww.nextLine();
        System.out.print("Password : ");
        String password = ww.nextLine();

        nasabah.login(userName, password);
        if (nasabah.isUser()) {
            while (!done) {
                mainMenu();
                System.out.print("\nInput : ");
                userName = ww.next();
                switch (userName) {
                    case "1":
                        System.out.println("Anda memilih menu transfer");
                        System.out.print("Silahkan input nomor rekening tujuan : ");
                        String mantap = ww.next();
                        password = ww.nextLine();
                        System.out.print("Jumlah transfer : ");
                        amount = ww.nextInt();
                        System.out.println("Transaksi anda berhasil");
                        nasabah.transfer(amount, mantap);
                        backToMainMenu();
                        break;
                    case "2":
                        System.out.println("Anda memilih menu Setor Tunai");
                        System.out.print("Jumlah uang : ");
                        amount = ww.nextInt();
                        nasabah.saving(amount);
                        backToMainMenu();
                        break;
                    case "3":
                        System.out.println("Anda memilih menu Tarik Uang");
                        System.out.print("Jumlah uang : ");
                        amount = ww.nextInt();
                        nasabah.takeMoney(amount);
                        backToMainMenu();
                        break;
                    case "4":
                        nasabah.getActivityLog();
                        backToMainMenu();
                        break;
                    case "5":
                        nasabah.printDetails();
                        backToMainMenu();
                        break;
                    case "0":
                        done = true;
                        nasabah.saveData();
                        return;
                    default:
                        System.out.println("Silahkan pilih menu kembali");
                        mainMenu();
                        System.out.print("Input : ");
                        userName = ww.nextLine();
                        break;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == 3) {
                    System.out.println("Salah dalam 3 kali percobaan\nSilahkan coba lagi nanti");
                    return;
                }
                System.out.print("Username : ");
                userName = ww.nextLine();
                System.out.print("Password : ");
                password = ww.nextLine();
                nasabah.login(userName, password);
                if (nasabah.isUser()) {
                    while (!done) {
                        mainMenu();
                        System.out.print("\nInput : ");
                        userName = ww.next();
                        switch (userName) {
                            case "1":
                                System.out.println("Anda memilih menu transfer");
                                System.out.print("Silahkan input nomor rekening tujuan : ");
                                password = ww.next();
                                String accountNumber = ww.nextLine();
                                System.out.print("Jumlah transfer : ");
                                amount = ww.nextInt();
                                nasabah.transfer(amount, accountNumber);
                                backToMainMenu();
                                break;
                            case "2":
                                System.out.println("Anda memilih menu setor tunai");
                                System.out.print("Jumlah uang : ");
                                amount = ww.nextInt();
                                nasabah.saving(amount);
                                backToMainMenu();
                                break;
                            case "3":
                                System.out.println("Anda memilih menu Tarik Uang");
                                System.out.print("Jumlah uang : ");
                                amount = ww.nextInt();
                                backToMainMenu();
                                break;
                            case "4":
                                nasabah.getActivityLog();
                                backToMainMenu();
                                break;
                            case "5":
                                nasabah.printDetails();
                                backToMainMenu();
                                break;
                            case "0":
                                done = true;
                                nasabah.saveData();
                                return;
                            default:
                                System.out.println("Silahkan pilih menu kembali");
                                mainMenu();
                                System.out.print("Input : ");
                                userName = ww.next();
                                break;
                        }
                    }
                }

            }
        }
    }

    public static void loginMenu() {
        System.out.println("   Selamat datang nasabah kami yang terhormat   ");
        System.out.println("-----------------------------------");
        System.out.println("Silahkan login");
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("Silahkan pilih menu");
        System.out.println("1.Transfer");
        System.out.println("2.Setor Tunai");
        System.out.println("3.Tarik Tunai");
        System.out.println("4.Log Aktivitas");
        System.out.println("5.Info Detail");
        System.out.println("0.Exit");
    }

    public static void backToMainMenu() {
        System.out.println("Lanjutkan Transaksi (y/n)");
        String stopOrContinue = ww.next();
        switch (stopOrContinue) {
            case "y":
                done = false;
                break;
            case "n":
                done = true;
                break;
            default:
                stopOrContinue = ww.next();
                break;
        }
    }
}