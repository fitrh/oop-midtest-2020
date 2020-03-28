package app;

/**
 * DetailMahasiswa
 */
public class DetailMahasiswa {

    private int id;
    private String name;
    private String nim;
    private String programStudi;
    private String semesterInfo;
    private String dosenPembimbing;

    public DetailMahasiswa(int id, String name, String nim, String programStudi, String semesterInfo, String dosenPembimbing) {
        this.id = id;
        this.name = name;
        this.nim = nim;
        this.programStudi = programStudi;
        this.semesterInfo = semesterInfo;
        this.dosenPembimbing = dosenPembimbing;
    }

    public DetailMahasiswa() {
        
    }

	public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getNIM() {
        return nim;
    }
    
    public String getProdi() {
        return programStudi;
    }
    
    public String getSemester() {
        return semesterInfo;
    }

    public String getDosenPembimbing() {
        return dosenPembimbing;
    }

}