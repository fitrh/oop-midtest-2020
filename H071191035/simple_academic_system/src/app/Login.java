package app;

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

    // constructor
    private Login() {
        dataSource = DataSource.getInstance();
    }

    // instansiasi
    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

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

    // menampilkan detail user mahasiswa
    public void statusMahasiswa() {
        if (authenticated) {
            System.out.println("-------------------------");
            System.out.printf("Berikut adalah profil dari %s\n", user.getUserName());
            System.out.printf("Nama\t\t: %s\n", mahasiswa.getNama());
            System.out.printf("Email\t\t: %s\n", mahasiswa.getEmail());
            System.out.printf("Dosen Pembimbing: %s\n", mahasiswa.getNamaDosenPa());
            System.out.printf("Username\t: %s\n", user.getUserName());
            System.out.printf("Password\t: %s\n\n", user.getPassword());
            getUser().showMatkul();
            System.out.printf("JUMLAH TOTAL SKS : %d\n", user.getSksTerdaftar());
            System.out.println("-------------------------");
        } else {
            System.out.println("Not authenticated...");
        }
    }

    // menampilkan detail user dosen
    public void statusDosen() {
        if (authenticated) {
            System.out.printf("Berikut adalah profil dari dosen %s\n", user.getUserName());
            System.out.printf("Nama\t\t: %s\n", dosenPa.getNamaDosen());
            System.out.printf("Nomor Telepon\t: %s\n", dosenPa.getNoTelp());
            System.out.printf("Email\t\t: %s\n", dosenPa.getEmail());
            System.out.println("-------------------------");
        } else {
            System.out.println("Not authenticated...");
        }
    }

    // keluar dari akun
    public void logout() {
        user = null;
    }

}