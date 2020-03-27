/**
 * User
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private Mahasiswa mahasiswa;
    private DosenPa dosenPa;
    private int sksTerdaftar;
    
    // constructor
    public User() {
        sksTerdaftar = 0;
    }
    
    public User(int id, String userName, String password, Mahasiswa mahasiswa) {
       this.id = id;
       this.userName = userName;
       this.password = password;
       this.mahasiswa = mahasiswa;
   }

    public User(int id, String userName, String password, DosenPa dosenPa) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.dosenPa = dosenPa;
    }

    // getter
    public int getId() {
        return id;
     }
 
    public String getUserName() {
        return userName;
     }
 
    public String getPassword() {
        return password;
     }
 
    public Mahasiswa getMahasiswa() {
        return mahasiswa;
     }
 
    public DosenPa getDosenPa() {
        return dosenPa;
     }
 
    public int getSksTerdaftar() {
        return sksTerdaftar;
     }

     // check password
    public boolean checkPass(String password) {
        return password.equals(this.password); 
    }

}