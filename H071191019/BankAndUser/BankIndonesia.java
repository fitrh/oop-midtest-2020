package Project.SimpleBank.BankAndUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BankIndonesia extends Bank {

    private String directory = "D:/KAMPUS/Pemrograman/JavaPractice/Santuy/fatwa-app/bin/app/Project/SimpleBank/BankAndUser/BankIndonesia.txt";

    public BankIndonesia() throws Exception {
        super.getUserDetails(directory);
    }

    @Override
    public void printDetails() {
        System.out.println("Nama\t\t: " + userDetail.get(index).getName());
        System.out.println("Umur \t\t: " + userDetail.get(index).getAge());
        System.out.println("Alamat \t\t: " + userDetail.get(index).getAddress());
        System.out.println("Email \t\t: " + userDetail.get(index).getEmail());
        System.out.println("Nomor Rekening\t: " + userDetail.get(index).getAccountNumber());
        System.out.printf("Jumlah Uang\t: %,d$\n", userDetail.get(index).getMoneyAmount());
    }

    @Override
    public void saveData() throws IOException {
        super.saveData();
    }

    @Override
    public void saving(int amount) {
        super.saving(amount);
    }

    @Override
    public void login(String name, String password) {
        for (int i = 0; i < userDetail.size(); i++) {
            if (userDetail.get(i).getName().equals(name) && userDetail.get(i).getPassword().equals(password)) {
                index = i;
                for (int j = 0; j < userDetail.get(i).getName().length() + 49; j++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.println(
                        "|   Selamat datang kembali di Bank Indonesia " + userDetail.get(i).getName() + "   |");
                for (int j = 0; j < userDetail.get(i).getName().length() + 49; j++) {
                    System.out.print("-");
                }
                System.out.println();
                isUser = true;
                return;
            }
        }
        System.out.println("Username atau password salah");
        isUser = false;
    }

    @Override
    public void transfer(int amount, String accountNumber) throws IOException {
        String userData = "";
        Scanner fa = new Scanner(System.in);
        for (int i = 0; i < userDetail.size(); i++) {
            if (userDetail.get(i).getAccountNumber().equals(accountNumber)) {
                System.out.print("Transfer ke nomor rekening " + userDetail.get(i).getAccountNumber() + " atas nama "
                        + userDetail.get(i).getName() + " sebanyak " + amount + " $ (y/n) : ");
                String supayaNdakError = fa.next();
                userData = fa.nextLine();
                if (userData.equalsIgnoreCase("y")) {
                    userData = "";
                } else if (userData.equalsIgnoreCase("n")) {
                    fa.close();
                    return;
                }
                userDetail.get(i).savingFromTransfer(amount);
                userDetail.get(index).transfer(amount, accountNumber, userDetail.get(i).getName());
                fa.close();
                return;
            }

        }
        ArrayList<UserDetail> otherBankUser = new ArrayList<>();
        Path file = Paths.get("Project/SimpleBank/BankAndUser/BankSultra.txt");
        String data = new String(Files.readAllBytes(file));
        String otherUser = "";
        int a = 1;
        String line[] = data.split("\n");
        for (int i = 0; i < line.length; i++) {
            String user[] = line[i].split(";");
            otherBankUser.add(i, new UserDetail(user[0], user[1], Integer.parseInt(user[2]), Integer.parseInt(user[3]),
                    user[4], user[5], user[6]));
        }
        for (int i = 0; i < line.length; i++) {
            if (otherBankUser.get(i).getAccountNumber().equals(accountNumber)) {
                otherBankUser.get(i).savingFromTransfer(amount);
                userDetail.get(index).transfer(amount, accountNumber, otherBankUser.get(i).getName());
                a = 2;
                System.out.print("Transfer ke nomor rekening " + otherBankUser.get(i).getAccountNumber() + " atas nama "
                        + otherBankUser.get(i).getName() + " sebanyak " + amount + " $ (y/n) : ");
                userData = fa.nextLine();
                if (userData.equalsIgnoreCase("y")) {
                } else if (userData.equalsIgnoreCase("n")) {
                    fa.close();
                    return;
                } else {
                    while (!userData.equalsIgnoreCase("y") || !userData.equalsIgnoreCase("y")) {
                        System.out.println("Mohon hanya input \"y/n\"");
                        userData = fa.next();
                        if (userData.equalsIgnoreCase("y")) {
                        } else if (userData.equalsIgnoreCase("n")) {
                            fa.close();
                            return;
                        }
                    }
                }
            }
            otherUser += otherBankUser.get(i).getName() + ";" + otherBankUser.get(i).getPassword() + ";"
                    + otherBankUser.get(i).getAge() + ";" + otherBankUser.get(i).getMoneyAmount() + ";"
                    + otherBankUser.get(i).getEmail() + ";" + otherBankUser.get(i).getAccountNumber() + ";"
                    + otherBankUser.get(i).getAddress() + "\n";
            saveData("Project/SimpleBank/BankAndUser/BankSultra.txt", otherUser);
        }
        if (a == 2) {
            return;
        } else {
            System.out.println("Nomor rekening tidak ditemukan");
        }
    }

    @Override
    public void addUser(String name, String password, int age, int moneyAmount, String email, String address) {
        userDetail.add(userAmount,
                new UserDetail(name, password, age, moneyAmount, email, generateAccountNumber(), address));
    }
}