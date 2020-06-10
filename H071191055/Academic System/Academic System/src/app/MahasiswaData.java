package app;

import java.io.*;
import java.util.*;

/**
 * MahasiswaData
 */
public class MahasiswaData {

    
    private Map<String, Mahasiswa> mahasiswaMap = new HashMap<>();
    private Map<Integer, DetailMahasiswa> detailMahasiswaMap = new HashMap<>();
    
    public MahasiswaData() throws IOException {
        listDetailMahasiswa();
        listAkunMahasiswa();
    }

    public void listAkunMahasiswa() throws IOException {
        FileReader file = new FileReader("ListAkunMahasiswa.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            if (isInteger(tempData[0])) {
                mahasiswaMap.put(tempData[1],
                    new Mahasiswa(Integer.valueOf(tempData[0]), tempData[1], tempData[2], 
                    detailMahasiswaMap.get(Integer.valueOf(tempData[0]))));
            }
        }
        tempData = null;
        reader.close();

    }
    
    public void listDetailMahasiswa() throws IOException {
        FileReader file = new FileReader("DetailMahasiswa.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            if (isInteger(tempData[0])) {
                detailMahasiswaMap.put(Integer.valueOf(tempData[0]),
                new DetailMahasiswa(Integer.valueOf(tempData[0]), tempData[1], tempData[2], tempData[3], tempData[4], tempData[5]));
            }
        }
        tempData = null;
        reader.close();
    }

    public Mahasiswa getMahasiswa(String key) {
        return mahasiswaMap.get(key);
    }

    public DetailMahasiswa getDetailMahasiswa(Integer key) {
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