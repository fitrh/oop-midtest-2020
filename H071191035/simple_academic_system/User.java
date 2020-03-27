import java.util.ArrayList;
import java.util.List;
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
    
    // constructor
    public User() {
        sksTerdaftar = 0;
    }
    
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
                        this.matkul.add(matkul);
                        matkul.setMahasiswaTerdaftar(this);
                        System.out.printf("Mata kuliah %s berhasil ditambahkan\n", matkul.getNamaMatkul());
                        System.out.printf("Kuota tersisa untuk mata kuliah %s sebanyak %d\n", matkul.getNamaMatkul(), matkul.getKuota());
                        System.out.println("-------------------------"); 
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
                    this.matkul.remove(matkul);
                    matkul.mahasiswaBatalMendaftar(this);
                    sksTerdaftar -= matkul.getSks();
                    System.out.printf("Mata kuliah %s telah dihapus dari program...\n", matkul.getNamaMatkul());
                    System.out.printf("Kuota tersisa untuk mata kuliah %s sebanyak %d\n", matkul.getNamaMatkul(), matkul.getKuota());
                    System.out.println("-------------------------");
             }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}