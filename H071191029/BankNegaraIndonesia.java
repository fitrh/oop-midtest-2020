package Project.Bank.BankandUser;

import java.io.IOException;

public class BankNegaraIndonesia extends Bank {

    private String directory = "Project/Bank/BankAndUser/BankNegaraIndonesia.txt";
    public BankNegaraIndonesia() throws Exception {
        getUserDetails();
    }

    public void getUserDetails() throws IOException {
        super.getUserDetails(directory);
    }

    @Override
    public void printDetails() {
        super.printDetails();
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
                System.out.println("------------------------------------------");
                System.out.println("|   Selamat datang  " + userDetail.get(i).getName() + "   |");
                System.out.println("------------------------------------------");
                System.out.println();
                isUser = true;
                return;
            }
        }
        System.out.println("Username atau password salah");
        isUser = false;
    }

    @Override
    public void transfer(int amount, String accountNumber) {
        for (int i = 0; i < userDetail.size(); i++) {
            if (userDetail.get(i).getAccountNumber().equals(accountNumber)) {
                userDetail.get(i).savingFromTransfer(amount);
                userDetail.get(index).transfer(amount, accountNumber, userDetail.get(i).getName());
                return;
            }
        }
        System.out.println("Nomor rekening tidak ditemukan");
    }

}