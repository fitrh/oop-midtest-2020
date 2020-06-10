import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Login {
    public static void main(String[] args) throws IOException {
        String file = "D:/St.2/oop-midtest-2020/H071191059/Akun.txt";

        try {
            FileWriter fileWriter = new FileWriter(file);
            Scanner sc = new Scanner(System.in);

            System.out.println("Bikin akun terlebih dahulu!");
            System.out.print("Username = ");
            String userName = sc.nextLine() + "; ";
            System.out.print("Password = ");
            String password = sc.nextLine() + "#";

            fileWriter.write(userName);
            fileWriter.write(password);
            fileWriter.close();

            System.out.println("Berhasil membuat akun!");
            System.out.println();

            System.out.println("Silahkan login kembali");
            System.out.print("Username = ");
            String inputU = sc.nextLine() + "; ";
            System.out.print("Password = ");
            String inputP = sc.nextLine() + "#";

            if (inputU.equals(userName) && inputP.equals(password)) {
                System.out.println("Berhasil Login");
                Menu.ser();
            } else {
                System.out.println("User name atau password anda salah!");
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println("ada kesalahan " + e.getMessage());
        }
    }
}