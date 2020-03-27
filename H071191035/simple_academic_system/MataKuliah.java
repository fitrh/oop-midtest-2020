import java.util.ArrayList;
import java.util.List;
/**
 * MataKuliah
 */
public class MataKuliah {

    private String kodeMatkul;
    private String namaMatkul;
    private String dosenPengajar;
    private int sks;
    private int kuota;
    private List<User> mahasiswaTerdaftar = new ArrayList<>();

    // constructor
    MataKuliah(String kodeMatkul, String namaMatkul, String dosenPengajar, int sks, int kuota) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.dosenPengajar = dosenPengajar;
        this.sks = sks;
        this.kuota = kuota;
    }

    // getter
    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public String getDosenPengajar() {
        return dosenPengajar;
    }

    public int getSks() {
        return sks;
    }

    public int getKuota() {
        return kuota;
    }

}