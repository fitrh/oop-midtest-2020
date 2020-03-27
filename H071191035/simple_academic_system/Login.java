/**
 * Login
 */
public class Login {

    private static Login login;
    private User user;
    private Mahasiswa mahasiswa;
    private DosenPa dosenPa;
    private DataSource dataSource;
    private boolean authenticated = false;

    // getter
    public User getUser() {
        return user;
    }

    public DosenPa getDosenPa() {
        return dosenPa;
    }
    
    public boolean getAuth() {
        return authenticated;
    }

}