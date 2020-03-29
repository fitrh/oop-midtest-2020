package app;

import java.io.IOException;
import java.util.*;

/**
 * Menu
 */
public class Menu {

    static Scanner sc = new Scanner(System.in);
    private MahasiswaData MahasiswaData;
    private Mahasiswa mahasiswa;
    private MatKulData matKulData;
    private DosenPAData dosenPAData;
    private DosenPA dosenPA;
    private int choose;
    private String pilih;
    private boolean loop = true;
    
    public Menu() throws IOException {
        matKulData = new MatKulData();
        MahasiswaData = new MahasiswaData();
        mahasiswa = new Mahasiswa();
        dosenPA = new DosenPA();
        dosenPAData = new DosenPAData();
    }
    
    public void MenuMahasiswa(String userName) {
        try {
            while (loop) {
                System.out.println("\n-- Menu --");
                System.out.println("1. Profil");
                System.out.println("2. Kartu Rencana Studi");
                System.out.println("3. Daftar Mata Kuliah");
                System.out.println("4. Lihat IPS");
                System.out.println("5. Logout");
                System.out.print("> ");
                choose = sc.nextInt();
                sc.nextLine();
        
                switch (choose) {
                    case 1:
                        mahasiswa = MahasiswaData.getMahasiswa(userName);
                        mahasiswa.show();
                        Checkout();
                        break;
                    case 2:
                        menuKRS();
                        Checkout();
                        break;
                    case 3:
                        matKulData.showMatKul();
                        Checkout();
                        break;
                    case 4:
                        Checkout();
                        break;
                    case 5:
                        System.out.println("Anda Yakin ? (Y/N)");
                        System.out.print("> ");
                        pilih = sc.nextLine();
                        if (pilih.equalsIgnoreCase("Y")) {
                            Login.getInstance(); 
                            loop = false;
                        }
                        break;
                    default:
                        System.out.println("Mohon memasukkan inputan yang benar");
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println("Mohon memasukkan inputan yang valid");
        }
    }

	public void MenuDosen(String userName) {
        try {
            while (true) {
                System.out.println("\n-- Menu --");
                System.out.println("1. Profil");
                System.out.println("2. Mahasiswa yang Dibimbing");
                System.out.println("3. Logout");
                System.out.print("> ");
                choose = sc.nextInt();
                sc.nextLine();
        
                switch (choose) {
                    case 1:
                        dosenPA = dosenPAData.getDosen(userName);
                        dosenPA.show();
                        Checkout();
                        break;
                    case 2:
                        dosenPA.showMahasiswaBimbingan();
                        Checkout();
                        break;
                    case 3:
                        System.out.println("Anda Yakin ? (Y/N)");
                        System.out.print("> ");
                        pilih = sc.nextLine();
                        if (pilih.equalsIgnoreCase("Y")) {
                            Login.getInstance();
                            loop = false;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Mohon memasukkan inputan yang valid");
        }
    }
    
    public void menuKRS() {
        while (true) {
            System.out.println("\n--Menu KRS--");
            System.out.println("1. Lihat KRS");
            System.out.println("2. Isi KRS");
            System.out.println("3. Hapus Mata Kuliah");
            System.out.print("> ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    mahasiswa.showKRS();
                    break;
                case 2:
                    mahasiswa.isiKRS();
                    break;
                case 3:
                    mahasiswa.hapusKRS();
                default:
                    break;
            }
            sc.nextLine();
            System.out.println("\nAnda ingin keluar dari Menu KRS ? (Y/N)");
            System.out.print("> ");
            pilih = sc.nextLine();
            if (pilih.equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    public boolean Checkout() {
        System.out.println("\nAnda ingin keluar dari Menu ? (Y/N)");
        System.out.print("> ");
        pilih = sc.nextLine();
        if (pilih.equalsIgnoreCase("Y")) {
            return loop = false;
        }
        return true;
    }
}