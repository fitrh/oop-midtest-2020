package Project.SimpleBank;

import java.io.IOException;
import java.util.Scanner;

import Project.SimpleBank.BankAndUser.Bank;
import Project.SimpleBank.BankAndUser.BankIndonesia;
import Project.SimpleBank.BankAndUser.BankSultra;

public class Main {
    static Scanner fa = new Scanner(System.in);
    static boolean done = false;

    public static void main(String[] args) throws Exception {
        Bank nasabah = new Bank();
        int amount;
        chooseBankMenu();

        System.out.print("Input :");
        amount = fa.nextInt();
        if (amount == 1) {
            nasabah = new BankIndonesia();
        } else if (amount == 2) {
            nasabah = new BankSultra();
        }

        loginMenu();
        System.out.print("Username : ");
        String userName = fa.nextLine();
        userName = fa.nextLine();
        System.out.print("Password : ");
        String password = fa.nextLine();

        nasabah.login(userName, password);
        if (nasabah.isUser()) {
            while (!done) {
                mainMenu();
                System.out.print("\nInput : ");
                userName = fa.next();
                switch (userName) {
                    case "1":
                        System.out.println("Anda memilih menu transfer");
                        System.out.print("Silahkan input nomor rekening tujuan : ");
                        String mantap = fa.next();
                        password = fa.nextLine();
                        System.out.print("Jumlah transfer : ");
                        amount = fa.nextInt();
                        nasabah.transfer(amount, mantap);
                        backToMainMenu(nasabah);
                        break;
                    case "2":
                        System.out.println("Anda memilih menu Setor Tunai");
                        System.out.print("Jumlah uang : ");
                        amount = fa.nextInt();
                        nasabah.saving(amount);
                        backToMainMenu(nasabah);
                        break;
                    case "3":
                        System.out.println("Anda memilih menu Tarik Uang");
                        System.out.print("Jumlah uang : ");
                        amount = fa.nextInt();
                        nasabah.takeMoney(amount);
                        backToMainMenu(nasabah);
                        break;
                    case "4":
                        nasabah.getActivityLog();
                        backToMainMenu(nasabah);
                        break;
                    case "5":
                        nasabah.printDetails();
                        backToMainMenu(nasabah);
                        break;
                    case "6":
                        System.out.print("Nama\t\t:");
                        userName = fa.nextLine();
                        String nameInput = fa.nextLine();
                        System.out.print("\nPassword\t:");
                        String passwordInput = fa.nextLine();
                        System.out.print("\nUmur\t\t:");
                        int ageInput = fa.nextInt();
                        System.out.print("\nSetoran Awal($) :");
                        int firstMoneyInput = fa.nextInt();
                        System.out.print("\nEmail\t\t:");
                        userName = fa.nextLine();
                        String emailInput = fa.nextLine();
                        System.out.print("\nAlamat\t\t:");
                        String addressInput = fa.nextLine();
                        nasabah.addUser(nameInput, passwordInput, ageInput, firstMoneyInput, emailInput, addressInput);
                        backToMainMenu(nasabah);
                        break;
                    case "0":
                        done = true;
                        nasabah.saveData();
                        return;
                    default:
                        System.out.println();
                        System.out.print("Tolong perbaiki input anda (0 - 5)");
                        userName = fa.nextLine();
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
                userName = fa.nextLine();
                System.out.print("Password : ");
                password = fa.nextLine();
                nasabah.login(userName, password);
                if (nasabah.isUser()) {
                    while (!done) {
                        mainMenu();
                        System.out.print("\nInput : ");
                        userName = fa.next();
                        switch (userName) {
                            case "1":
                                System.out.println("Anda memilih menu transfer");
                                System.out.print("Silahkan input nomor rekening tujuan : ");
                                password = fa.next();
                                String accountNumber = fa.nextLine();
                                System.out.print("Jumlah transfer : ");
                                amount = fa.nextInt();
                                nasabah.transfer(amount, accountNumber);
                                backToMainMenu(nasabah);
                                break;
                            case "2":
                                System.out.println("Anda memilih menu menabung");
                                System.out.print("Jumlah uang : ");
                                amount = fa.nextInt();
                                nasabah.saving(amount);
                                backToMainMenu(nasabah);
                                break;
                            case "3":
                                System.out.println("Anda memilih menu Tarik Uang");
                                System.out.print("Jumlah uang : ");
                                amount = fa.nextInt();
                                backToMainMenu(nasabah);
                                break;
                            case "4":
                                nasabah.getActivityLog();
                                backToMainMenu(nasabah);
                                break;
                            case "5":
                                nasabah.printDetails();
                                backToMainMenu(nasabah);
                                break;
                            case "6":
                                System.out.print("Nama\t\t:");
                                userName = fa.nextLine();
                                String nameInput = fa.nextLine();
                                System.out.print("Password\t:");
                                String passwordInput = fa.nextLine();
                                System.out.print("Umur\t\t:");
                                int ageInput = fa.nextInt();
                                System.out.print("Setoran Awal($) :");
                                int firstMoneyInput = fa.nextInt();
                                System.out.print("Email\t\t:");
                                userName = fa.nextLine();
                                String emailInput = fa.nextLine();
                                System.out.print("Alamat\t\t:");
                                String addressInput = fa.nextLine();
                                nasabah.addUser(nameInput, passwordInput, ageInput, firstMoneyInput, emailInput,
                                        addressInput);
                                backToMainMenu(nasabah);
                                break;
                            case "0":
                                done = true;
                                nasabah.saveData();
                                return;
                            default:
                                System.out.println("Silahkan pilih menu kembali");
                                mainMenu();
                                System.out.print("Input : ");
                                userName = fa.next();
                                break;
                        }
                    }
                }

            }
        }
    }

    public static void chooseBankMenu() {
        System.out.println("Silahkan pilih Bank");
        System.out.println("1.Bank Indonesia");
        System.out.println("2.Bank Sultra");
    }

    public static void loginMenu() {
        System.out.println("   Selamat datang di Welcome!!!    ");
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
        System.out.println("6.Tambah Nasabah");
        System.out.println("0.Exit");
    }

    public static void backToMainMenu(Bank nasabah) throws IOException {
        System.out.print("Lanjutkan ? (y/n) : ");
        String stopOrContinue = fa.next();
        switch (stopOrContinue) {
            case "y":
                done = false;
                break;
            case "n":
                done = true;
                nasabah.saveData();
                break;
            default:
                System.out.println();
                System.out.println("Input salah");
                System.out.print("Lanjutkan ? (y/n) : ");
                stopOrContinue = fa.next();
                if (stopOrContinue.equals("y")) {
                    done = false;
                    return;
                } else if (stopOrContinue.equals("n")) {
                    done = true;
                    nasabah.saveData();
                    return;
                }
                while (!stopOrContinue.equals("y") || !stopOrContinue.equals("n")) {
                    System.out.println();
                    System.out.println("Input salah");
                    System.out.print("Lanjutkan ? (y/n) : ");
                    stopOrContinue = fa.next();
                    if (stopOrContinue.equals("y")) {
                        done = false;
                        return;
                    } else if (stopOrContinue.equals("n")) {
                        done = true;
                        nasabah.saveData();
                        return;
                    }
                }
                break;
        }
    }
}
