import java.util.HashMap;
/**
 * DataSource
 */
public class DataSource {

    private static DataSource dataSource;
    private HashMap<String, User> userMapMahasiswa = new HashMap<>();
    private HashMap<String, User> userMapDosen = new HashMap<>();
    private HashMap<Integer, Mahasiswa> mahasiswaMap = new HashMap<>();
    private HashMap<Integer, DosenPa> dosenPaMap = new HashMap<>();

    // getter
    public User getUser(String key) {
        return userMapMahasiswa.get(key);
    }
    
    public Mahasiswa getMahasiswa(int key) {
        return mahasiswaMap.get(key);
    }

    public User getUserDosen(String key) {
        return userMapDosen.get(key);
    }

    public DosenPa getDosenPa(int key) {
        return dosenPaMap.get(key);
    }
}