package Project.Bank.BankandUser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    protected ArrayList<UserDetail> userDetail = new ArrayList<>();
    protected int index;
    protected boolean isUser;

    public void getUserDetails(String directory) throws IOException {
        Path file = Paths.get(directory);
        String data = new String(Files.readAllBytes(file));
        String[] line = data.split("\n");
        for (int i = 0; i < line.length; i++) {
            String[] user = line[i].split(";");
            this.userDetail.add(i, new UserDetail(user[0], user[1], Integer.parseInt(user[2]),
                    Integer.parseInt(user[3]), user[4], user[5], user[6]));
        }
    }

    private String generateAccountNumber() {
        Random random = new Random();
        String str = "2020" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + "00" + random.nextInt(10)
                + random.nextInt(10);
        return str;
    }

    public void printDetails() {
        System.out.println("Nama\t\t: " + userDetail.get(index).getName());
        // System.out.println("Password\t: " + userDetail.get(index).getPassword());
        System.out.println("Umur \t\t: " + userDetail.get(index).getAge());
        System.out.println("Alamat \t\t: " + userDetail.get(index).getAddress());
        System.out.println("Email \t\t: " + userDetail.get(index).getEmail());
        System.out.println("Nomor Rekening\t: " + userDetail.get(index).getAccountNumber());
        System.out.println("Jumlah Uang\t: " + userDetail.get(index).getMoneyAmount() + "$");
    }

    public void login(String name, String password) {

    }

    public void saving(int amount) {
        userDetail.get(index).saving(amount);
    }

    public void transfer(int amount, String accountNumber) {

    }

    public void takeMoney(int amount) {
        userDetail.get(index).takeMoney(amount);
    }

    public void getActivityLog() {
        String activityLog = ("" + userDetail.get(index).getActivityLog()).replace("[", "").replace("]", "")
                .replace(", ", "");
        System.out.println("\nLog Aktivitas");
        System.out.println(activityLog);
    }

    public boolean isUser() {
        return isUser;
    }

    protected void saveData() throws IOException {
        Path file = Paths.get(
                "Project/Bank/BankAndUser/BankNegaraIndonesia.txt");
        String saveData = "";
        for (int i = 0; i < userDetail.size(); i++) {
            saveData += userDetail.get(i).getName() + ";" + userDetail.get(i).getPassword() + ";"
                    + userDetail.get(i).getAge() + ";" + userDetail.get(i).getMoneyAmount() + ";"
                    + userDetail.get(i).getEmail() + ";" + userDetail.get(i).getAccountNumber() + ";"
                    + userDetail.get(i).getAddress() + "\n";
        }
        Files.write(file, saveData.getBytes(StandardCharsets.ISO_8859_1));
    }
}