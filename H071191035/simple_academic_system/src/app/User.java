package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/**
 * User
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private Mahasiswa mahasiswa;
    private DosenPa dosenPa;
    private int sksTerdaftar;
    private List<MataKuliah> matkul = new ArrayList<>();
    private HashMap<String, Integer> ipsMap = new HashMap<>();
    private Random rand = new Random();
    
    // constructor
    public User(int id, String userName, String password, Mahasiswa mahasiswa) {
       this.id = id;
       this.userName = userName;
       this.password = password;
       this.mahasiswa = mahasiswa;
   }

    public User(int id, String userName, String password, DosenPa dosenPa) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.dosenPa = dosenPa;
    }

    // getter
    public int getId() {
        return id;
     }
 
    public String getUserName() {
        return userName;
     }
 
    public String getPassword() {
        return password;
     }
 
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
     }
 
    public DosenPa getDosenPa() {
        return dosenPa;
     }
 
    public int getSksTerdaftar() {
        return sksTerdaftar;
     }

     // check password
    public boolean checkPass(String password) {
        return password.equals(this.password); 
    }

    // add mata kuliah
    public void addMataKuliah(MataKuliah matkul) {
        try {
            if (!this.matkul.contains(matkul)) {
                if (matkul.getKuota() > 0) {
                    sksTerdaftar += matkul.getSks();
                    if (sksTerdaftar < 11) {
                        this.matkul.add(matkul);
                        matkul.setMahasiswaTerdaftar(this);
                        System.out.printf("Mata kuliah %s berhasil ditambahkan\n", matkul.getNamaMatkul());
                        System.out.printf("Kuota tersisa untuk mata kuliah %s sebanyak %d\n", matkul.getNamaMatkul(), matkul.getKuota());
                        System.out.println("-------------------------"); 
                    } else {
                        System.out.println("Melewati batas total SKS yang diberikan...");
                        System.out.println("-------------------------");
                        sksTerdaftar -= matkul.getSks();
                    }
                } else {
                    System.out.println("Kuota tak mencukupi...");
                    System.out.println("-------------------------");
                    }
            } else {
                System.out.println("Telah terdaftar dalam mata kuliah ini...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // remove mata kuliah
    public void removeMataKuliah(MataKuliah matkul) {
        try {
            if (sksTerdaftar == 0) {
                System.out.println("Tidak ada mata kuliah yang diprogramkan...");
                System.out.println("-------------------------");
            } else {
                if (this.matkul.contains(matkul)) {
                    this.matkul.remove(matkul);
                    matkul.mahasiswaBatalMendaftar(this);
                    sksTerdaftar -= matkul.getSks();
                    System.out.printf("Mata kuliah %s telah dihapus dari program...\n", matkul.getNamaMatkul());
                    System.out.printf("Kuota tersisa untuk mata kuliah %s sebanyak %d\n", matkul.getNamaMatkul(), matkul.getKuota());
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Tidak dapat menghapus mata kuliah ini...");
                    System.out.println("Anda belum terdaftar dalam mata kuliah ini...");
                    System.out.println("-------------------------");
                }
             }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // show matkul yang diprogramkan
    public void showMatkul() {

        if (sksTerdaftar == 0) {
            System.out.println("Tidak ada mata kuliah yang diprogramkan...");
        } else {
            System.out.printf("Berikut adalah daftar mata kuliah yang diprogramkan oleh %s\n", userName);
            for (MataKuliah mataKuliah : matkul) {
                System.out.printf("Nama mata kuliah\t: %s\n", mataKuliah.getNamaMatkul());
                System.out.printf("Kode mata kuliah\t: %s\n", mataKuliah.getKodeMatkul());
                System.out.printf("Dosen pengajar\t\t: %s\n", mataKuliah.getDosenPengajar());
                System.out.printf("Jumlah satuan kredit\t: %d\n", mataKuliah.getSks());
                System.out.println("-------------------------");
            }
        }  
    }

    // show IPS
    public void showIps() {
        ipsMap.put("Matematika Dasar", 3);
        ipsMap.put("Pengantar Pemrograman", 3);
        ipsMap.put("WSBM", 2);
        ipsMap.put("Fisika Dasar", 2);
        ipsMap.put("Kimia Dasar", 2);
        ipsMap.put("Biologi Dasar", 2);
        ipsMap.put("Pancasila", 2);

        String[] matkul = {"Matematika Dasar", "Pengantar Pemrograman", "WSBM", "Fisika Dasar", "Kimia Dasar", "Biologi Dasar", "Pancasila"};
        List<String> listMatkul = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            listMatkul.add(matkul[rand.nextInt(matkul.length - 1)]);
        }

        System.out.printf("Berikut adalah IPS semester lalu dari user %s\n", getUserName());
        for (int i = 0; i < listMatkul.size(); i++) {
            System.out.printf("Nama mata kuliah : %s\n", listMatkul.get(i));
            System.out.printf("Jumlah kredit    : %d\n", ipsMap.get(listMatkul.get(i)));
            System.out.println();
        }
        System.out.printf("IPK\t\t : %.2f\n", (rand.nextFloat() * (4.01 - 2.75)) + 2.75);
        System.out.println("-------------------------");
    }

}