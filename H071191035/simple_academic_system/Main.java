import java.util.Scanner;
/**
 * Main
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    static String s, userName, password;
    static int a;

    public static void main(String[] args) {
        
        Login login = Login.getInstance();

        // Mata Kuliah
        MataKuliah MatDas = new MataKuliah("619", "Matematika Dasar", "Dosen Matematika", 3, 10);
        MataKuliah Bindo = new MataKuliah("101", "Bahasa Indonesia", "Dosen Bahasa Indoensia", 2, 5);
        MataKuliah English = new MataKuliah("202", "Bahasa Inggris", "Dosen Bahasa Inggris", 2, 3);
        MataKuliah PendAgama = new MataKuliah("666", "Pendidikan Agama", "Dosen Agama", 3, 1);
        MataKuliah Wipteks = new MataKuliah("123", "Wawasan IPTEKS", "Dosen IPTEKS", 2, 3);
        MataKuliah Pkn = new MataKuliah("555", "Kewarganegaraan", "Dosen Kewarganegaraan", 3, 1);

        while (true) {

            System.out.println("--MENU--");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Masukkan pilihan => ");
            a = scan.nextInt();

            // login
            if (a == 1) {

                System.out.println("--MENU--");
                System.out.println("1. Login mahasiswa");
                System.out.println("2. Login dosen");
                System.out.print("Masukkan pilihan => ");
                a = scan.nextInt();

                // login sebagai mahasiswa
                if (a == 1) {

                    System.out.println("--Input your username & password below--");
                    System.out.print("Username => ");
                    userName  = scan.next();
                    System.out.print("Password => ");
                    password = scan.next();

                // login sebagai dosen
                } else {

                    System.out.println("--Input your username & password below--");
                    System.out.print("Username => ");
                    userName  = scan.next();
                    System.out.print("Password => ");
                    password = scan.next();

                }

            // exit
            } else {
                break;
            }

        }

    }

}