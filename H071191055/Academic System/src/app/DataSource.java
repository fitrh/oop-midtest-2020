package app;

import java.io.*;
import java.util.*;

/**
 * DataSource
 */
public class DataSource {

    private Map<Integer, MataKuliah> matKulMap = new HashMap<>();
    private Map<String, Mahasiswa> mahasiswaMap = new HashMap<>();
    private Map<Integer, UserDetail> detailMahasiswaMap = new HashMap<>();
    //private Map<Integer, DosenPA> dosenMap = new HashMap<>();
    
    
    public void listMatKul() throws IOException {
        FileReader file = new FileReader("ListMatKul.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            while (isInteger(tempData[0])) {
                matKulMap.put(Integer.valueOf(tempData[0]),
                new MataKuliah(Integer.valueOf(tempData[0]), tempData[1], Integer.valueOf(tempData[2]), tempData[3]));
            }
        }
        tempData = null;
        reader.close();

    }

    public void listAkunMahasiswa() throws IOException {
        FileReader file = new FileReader("ListAkunMahasiswa.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            while (isInteger(tempData[0])) {
                mahasiswaMap.put(tempData[0],
                    new Mahasiswa(Integer.valueOf(tempData[0]), tempData[1], tempData[2], 
                    detailMahasiswaMap.get(Integer.valueOf(tempData[0]))));
            }
        }
        tempData = null;
        reader.close();

    }

    public void listDetailMahasiswa() throws IOException {
        FileReader file = new FileReader("ListDetailMahasiswa.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            while (isInteger(tempData[0])) {
                detailMahasiswaMap.put(Integer.valueOf(tempData[0]),
                new UserDetail(Integer.valueOf(tempData[0]), tempData[1], tempData[2], tempData[3], tempData[4]));
            }
        }
        tempData = null;
        reader.close();
    }

    public Mahasiswa getUser(String key) {
        return mahasiswaMap.get(key);
    }

    public UserDetail getDetailMahasiswa(Integer key) {
        return detailMahasiswaMap.get(key);
    }

    public boolean isInteger(String s) {
        boolean isAnInteger = false;
        try {
            Integer.parseInt(s);

            isAnInteger = true;
        } catch (Exception e) {

        }
        return isAnInteger;
    }
}