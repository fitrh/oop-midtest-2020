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
    DosenPa() {
        mahasiswaBimbingan = null;
    }

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
        // TODO Auto-generated method stub
    }

    @Override
    public void showMahasiswaBimmbingan() {
        // TODO Auto-generated method stub
    }

}