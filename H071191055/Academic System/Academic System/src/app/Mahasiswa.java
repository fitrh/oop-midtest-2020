package app;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mahasiswa
 */
public class Mahasiswa {
    
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String userName;
    private String password;
    private int sks;
    private DetailMahasiswa DetailMahasiswa;
    private ArrayList<MataKuliah> krs = new ArrayList<>();
    private MatKulData matKulData;
    private int index;
    private String pilih;
    private double ips;
    
    public Mahasiswa(int id, String userName, String password, DetailMahasiswa DetailMahasiswa) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.DetailMahasiswa = DetailMahasiswa;
        sks = 0;
        ips = ThreadLocalRandom.current().nextDouble(2, 4.0001);
    }

    public Mahasiswa() throws IOException {
        DetailMahasiswa = new DetailMahasiswa();
        matKulData = new MatKulData();
    }

    public int getSKS() {
        return sks;
    }

    public double getIPS() {
        return ips;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUserName() {
        return userName;
    }

	public DetailMahasiswa getDetailMahasiswa() {
		return DetailMahasiswa;
    }

    public void showIPS() {
        System.out.printf("\nIPS dari %s", DetailMahasiswa.getName());
        System.out.printf("\nIPS : %.2f\n", getIPS());
    }

    public void show() {
        try {
            System.out.println("\n-- Profil --");
            System.out.printf("Nama             : %s", DetailMahasiswa.getName());
            System.out.printf("\nNIM              : %s", DetailMahasiswa.getNIM());
            System.out.printf("\nProgram Studi    : %s", DetailMahasiswa.getProdi());
            System.out.printf("\nSemester         : %s", DetailMahasiswa.getSemester());
            System.out.printf("\nDosen Pembimbing : %s\n", DetailMahasiswa.getDosenPembimbing());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // public boolean checkCourse(Integer index) {
    //     for (int j = 0; j < matKulData.getMataKuliah().size(); j++) {
    //         if (this.krs.get(index) == matKulData.getMataKuliah().get(j)) {
    //             System.out.println("berhasil");
    //             return false;
    //         }
    //     }
    //     return true;
    //}

    public void isiKRS() {
        try {
            while (true) {
                System.out.println("\n-- Daftar Mata Kuliah --");
                for (int i = 0; i < matKulData.getMataKuliah().size(); i++) {
                    System.out.printf("%d. %s (%d)\n", (i + 1), matKulData.getMataKuliah().get(i).getNameCourse(), 
                                        matKulData.getMataKuliah().get(i).getSksCourse());
                }
                System.out.print("> ");
                index = sc.nextInt() - 1;
                if (!(krs.contains(matKulData.getMataKuliah().get(index)))) {
                    sks += matKulData.getMataKuliah().get(index).getSksCourse();
                    if (sks < 11) {
                        krs.add(matKulData.getMataKuliah().get(index));
                        System.out.printf("Mata Kuliah %s berhasil ditambahkan\n", matKulData.getMataKuliah().get(index).getNameCourse());
                        System.out.printf("Sisa SKS yang dapat dibelanjakan adalah %d\n", (10 - sks));
                    } else {
                        System.out.println("SKS tidak mencukupi");
                    }
                } else {
                    System.out.println("Anda sudah terdaftar pada matakuliah ini");
                }
                sc.nextLine();
                System.out.println("\nDone ? (Y/N)");
                System.out.print("> ");
                pilih = sc.nextLine();
                if (pilih.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Mohon menginput sesuai dengan kode Mata Kuliah");
        }
    }

    public void hapusKRS() {
        try {
            if (sks == 0) {
                System.out.println("Tidak ada mata kuliah yang diprogramkan");
            } else {
                while (true) {
                    System.out.println("\n--Kartu Rencana Studi--");
                    for (int i = 0; i < krs.size(); i++) {
                        System.out.printf("%d. %s\n", (i + 1), krs.get(i).getNameCourse());
                    }
                    
                    System.out.print("> ");
                    index = sc.nextInt() - 1;
                    if (krs.contains(matKulData.getMataKuliah().get(index))) {
                        sks -= krs.get(index).getSksCourse();
                        System.out.printf("Mata Kuliah %s berhasil dihapus\n", krs.get(index).getNameCourse());
                        krs.remove(index);
                        System.out.printf("Sisa SKS yang dapat dibelanjakan adalah %d\n", (10 - sks));
                    }
                    sc.nextLine();
                    System.out.println("\nDone ? (Y/N)");
                    System.out.print("> ");
                    pilih = sc.nextLine();
                    if (pilih.equalsIgnoreCase("Y")) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Mohon menginput sesuai dengan kode Mata Kuliah");
        }
    }

    public void showKRS() {
        if (getSKS() <= 0) {
            System.out.println("Anda Belum Mengisi KRS");
        } else {
            System.out.println("\n--Kartu Rencana Studi--");
            for (int i = 0; i < krs.size(); i++) {
                System.out.printf("%d. %s\n",(i + 1), krs.get(i).getNameCourse());
            }
        }
    }
}