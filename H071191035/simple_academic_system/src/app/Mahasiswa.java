package app;

/**
 * Mahasiswa
 */
public class Mahasiswa {

    private int id;
    private String nama;
    private String email;
    private String namaDosenPa;

    // constructor
    public Mahasiswa(int id, String nama, String email, String namaDosenPa) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.namaDosenPa = namaDosenPa;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNamaDosenPa() {
        return namaDosenPa;
    }

}