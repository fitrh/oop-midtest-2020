package app;

/**
 * MataKuliah
 */
public class MataKuliah {

    private int id;
    private String name;
    private int sks;
    private String namaDosen;
    // private Map<Integer, DataSource> matKulMap = new HashMap<>();

    public MataKuliah(int id, String name, int sks, String namaDosen) {
        this.id = id;
        this.name = name;
        this.sks = sks;
        this.namaDosen = namaDosen;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSks() {
        return sks;
    }
}