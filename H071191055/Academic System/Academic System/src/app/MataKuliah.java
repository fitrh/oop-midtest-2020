package app;

/**
 * MataKuliah
 */
public class MataKuliah {

    private int id;
    private String name;
    private int sks;
    private String namaDosen;

    public MataKuliah(int id, String name, int sks, String namaDosen) {
        this.id = id;
        this.name = name;
        this.sks = sks;
        this.namaDosen = namaDosen;
    }

    public int getIdCourse() {
        return id;
    }

    public String getNameCourse() {
        return name;
    }

    public int getSksCourse() {
        return sks;
    }

    public String getNamaDosenCourse() {
        return namaDosen;
    }


}