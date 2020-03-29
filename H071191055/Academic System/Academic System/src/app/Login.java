package app;

import java.io.*;
import java.util.*;

/**
 * Login
 */
public class Login {

    static Scanner sc = new Scanner(System.in);
    private Menu menu = new Menu();
    private DosenPA dosenPA;
    private DosenPAData dosenPAData;
    private Mahasiswa mahasiswa;
    private MahasiswaData MahasiswaData;
    private static Login login;

    private Login() throws IOException {
        MahasiswaData = new MahasiswaData();
        dosenPAData = new DosenPAData();
    }

    public static Login getInstance() throws IOException{
        if(login == null) {
            login = new Login();
        }
        return login;
    }

    public boolean authMahasiswa(String userName, String password) throws IOException {
        mahasiswa = MahasiswaData.getMahasiswa(userName);
        FileReader file = new FileReader("ListAkunMahasiswa.txt");
        BufferedReader br = new BufferedReader(file);
        String tempData[];
        while (br.ready()) {
            tempData = br.readLine().split(";");
            if (tempData[1].equals(userName) && tempData[2].equals(password)) {
                //DetailMahasiswa = mahasiswa.getDetailMahasiswa();
                br.close();
                return false;
            } else {
                //System.out.println("Username / Password salah");
            }
        }
        br.close();
        return true;
    }

    private boolean authDosen(String userName, String password) throws IOException {
        dosenPA = dosenPAData.getDosen(userName);
        FileReader file = new FileReader("ListAkunDosen.txt");
        BufferedReader br = new BufferedReader(file);
        String tempData[];
        while (br.ready()) {
            tempData = br.readLine().split(";");
            if (tempData[1].equals(userName) && tempData[2].equals(password)) {
                br.close();
                return false;
            } else {
                //System.out.println("Username / Password salah");
            }
        }
        br.close();
        return true;
    }
    
    public void LoginAction() throws IOException {
        int choose;
        String userName = null;
        String password;
        boolean checks = true;
        while (checks) {
            System.out.println("\nSelamat Datang di Sistem Akademik");
            System.out.println("Login :");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Dosen");
            System.out.print("> ");
            choose = sc.nextInt();
            sc.nextLine();
            switch(choose) {
                    case 1:
                        while (checks) {
                            System.out.println("\n-- Login Mahasiswa --");
                            System.out.print("Username \t:");
                            userName = sc.next();
                            System.out.print("Password \t:");
                            password = sc.next();
                            if (authMahasiswa(userName, password) == false) {
                                System.out.println("Success");
                                break;
                            }
                            System.out.println("Usename/Password salah");
                        }
                        menu.MenuMahasiswa(userName);
                        break;
    
                    case 2:
                        while (checks) {
                            System.out.println("\n-- Login Dosen --");
                            System.out.print("Username \t:");
                            userName = sc.next();
                            System.out.print("Password \t:");
                            password = sc.next();
                            if (authDosen(userName, password) == false) {
                                System.out.println("Success");
                                break;
                            }
                            System.out.println("Usename/Password salah");
                        }
                        menu.MenuDosen(userName);
                        break;
    
                    default:
                    
                        break;
            }
        }
    }
}