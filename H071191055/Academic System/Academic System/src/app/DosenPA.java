package app;

import java.io.IOException;
import java.util.*;

/**
 * DosenPA
 */
public class DosenPA implements Dosen {

    static Scanner sc = new Scanner(System.in);
    private int id;
    private String userName;
    private String password;
    private DetailDosenPA detailDosenPA;
    private DosenPAData dosenPAData;
    private ArrayList<String> tempUsernameMB = new ArrayList<>();
    private ArrayList<Mahasiswa> mahasiswaBimbingan = new ArrayList<>();
    private DetailMahasiswa detailMahasiswa;
    private Mahasiswa mahasiswa;
    private MahasiswaData mahasiswaData;

    public DosenPA(int id, String userName, String password, DetailDosenPA detailDosenPA) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.detailDosenPA = detailDosenPA;
    }

    public DosenPA() throws IOException {
        dosenPAData = new DosenPAData();
        detailMahasiswa = new DetailMahasiswa();
        mahasiswa = new Mahasiswa();
        mahasiswaData = new MahasiswaData();
	}

	public int getIdDosen() {
        return id;
    }

    public String getUsernameDosen() {
        return userName;
    }

    public String getPasswordDosen() {
        return password;
    }

    public void show() {
        try {
            System.out.println("\n-- Profil --");
            System.out.printf("Nama              : %s", detailDosenPA.getNamaDosen());
            System.out.printf("\nNo Telepon        : %s", detailDosenPA.getTelpDosen());
            System.out.printf("\nEmail             : %s\n", detailDosenPA.getEmailDosen());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void set(Integer key) {
        System.out.println("aa");
        System.out.println(key);
        for (int i = 0; i < dosenPAData.getUsernameMB(key).size(); i++) {
            tempUsernameMB.add(dosenPAData.getUsernameMB(key).get(i));
        }

        for (int i = 0; i < tempUsernameMB.size(); i++) {
            mahasiswaBimbingan.add(mahasiswaData.getMahasiswa(tempUsernameMB.get(i)));
        }
    }

    @Override
    public void showMahasiswaBimbingan() {
        if (dosenPAData.getUsernameMB(id) == null) {
            System.out.println("Anda belum memiliki mahasiswa bimbingan");
        } else {
            System.out.println("\n-- Daftar Mahasiswa Bimbingan --");
            for (int i = 0; i < mahasiswaBimbingan.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), mahasiswaBimbingan.get(i).getDetailMahasiswa().getName());
            }
            int choose;
            System.out.println("\n--Menu--");
            System.out.println("1. Lihat profil mahasiswa");
            System.out.print("> ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("\n>> Pilih mahasiswa :");
                    System.out.print("> ");
                    choose = sc.nextInt();
                    showDetailMahasiswaBimbingan(choose);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void showDetailMahasiswaBimbingan(Integer key) {
        System.out.printf("\n>>Profil %s", mahasiswaBimbingan.get(key - 1).getDetailMahasiswa().getName());
        mahasiswaBimbingan.get(key - 1).show();
    }
}