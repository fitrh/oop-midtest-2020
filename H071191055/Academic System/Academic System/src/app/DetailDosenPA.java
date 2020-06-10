package app;

/**
 * DetailDosenPA
 */
public class DetailDosenPA {

    private int id;
    private String nama;
    private String telp;
    private String email;

    public DetailDosenPA(int id, String nama, String telp, String email) {
        this.id = id;
        this.nama = nama;
        this.telp = telp;
        this.email = email;
    }

    public int getIdDosen() {
        return id;
    }

    public String getNamaDosen() {
        return nama;
    }

    public String getTelpDosen() {
        return telp;
    }

    public String getEmailDosen() {
        return email;
    }
}