package app;

/**
 * Mahasiswa
 */
public class Mahasiswa extends User {

    private int sks = 24;
    private UserDetail detailMahasiswa;

    public Mahasiswa(int id, String userName, String password, UserDetail detailMahasiswa) {
        super(id, userName, password);
        this.detailMahasiswa = detailMahasiswa;
    }

    public boolean verifyPassword(String password) {
        return super.verifyPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public boolean verifyUsername(String userName) {
        return super.verifyUsername(userName);
    }

	public UserDetail getDetailMahasiswa(DataSource dataSource) {
		return detailMahasiswa;
	}
}