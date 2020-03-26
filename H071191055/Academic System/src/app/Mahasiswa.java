package app;

/**
 * Mahasiswa
 */
public class Mahasiswa extends User {

    private int sks = 24;

    public Mahasiswa(int id, String userName, String password) {
        super(id, userName, password);
    }

    public boolean verifyPassword(String password) {
        return super.verifyPassword(password);
    }
}