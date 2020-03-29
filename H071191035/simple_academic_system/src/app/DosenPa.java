package app;

import java.util.ArrayList;
import java.util.List;
/**
 * DosenPa
 */
public class DosenPa implements Dosen {

    private int id;
    private String namaDosen;
    private String noTelp;
    private String email;
    private List<Mahasiswa> mahasiswaBimbingan = new ArrayList<>();

    // constructor
    DosenPa(int id, String namaDosen, String noTelp, String email) {
        this.id = id;
        this.namaDosen = namaDosen;
        this.noTelp = noTelp;
        this.email = email;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    // Overriding method untuk kelas Dosen
    @Override
    public void setMahasiswaBimbingan(Mahasiswa mahasiswa) {
        mahasiswaBimbingan.add(mahasiswa);
    }

    @Override
    public void showMahasiswaBimmbingan() {
        System.out.printf("Berikut adalah mahasiswa bimbingan dari %s\n", namaDosen);
        if (mahasiswaBimbingan.isEmpty()) {
            System.out.println("Tidak memiliki mahasiswa bimbingan...");
        } else {
        for (Mahasiswa mahasiswa : mahasiswaBimbingan) {
            System.out.printf("Name\t\t: %s\n", mahasiswa.getNama());
            System.out.printf("Email\t\t: %s\n", mahasiswa.getEmail());
            System.out.println("-------------------------");
            }
        }
    }

}