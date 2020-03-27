import java.util.NoSuchElementException;
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

    // login mahasiswa
    public boolean authMahasiswa(String userName, String password) throws NoSuchElementException {
        
        user = dataSource.getUser(userName);

        try {
            if (user.checkPass(password)) {
                mahasiswa = user.getMahasiswa();
                authenticated = true;
                return true;
            } else {
                System.out.println("Wrong Password...");
                return false;
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Username " + userName + " not found");
        }

    }

    // login dosen
    public boolean authDosen(String userName, String password) throws NoSuchElementException {
        
        user = dataSource.getUserDosen(userName);

        try {
            if (user.checkPass(password)) {
                dosenPa = user.getDosenPa();
                authenticated = true;
                return true;
            } else {
                System.out.println("Wrong Password...");
                return false;
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Username " + userName + " not found");
        }

    }

}