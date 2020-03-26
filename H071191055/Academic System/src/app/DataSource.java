package app;

import java.io.*;
import java.util.*;

/**
 * DataSource
 */
public class DataSource {

    private Map<Integer, MataKuliah> matKulMap = new HashMap<>();
    private Map<Integer, Mahasiswa> mahasiswaMap = new HashMap<>();
    //private Map<Integer, DosenPA> dosenMap = new HashMap<>();
    
    
    public void listMatKul() throws IOException {
    FileReader file = new FileReader("ListMatKul.txt");
    BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            while (isInteger(tempData[0])) {
                matKulMap.put(Integer.valueOf(tempData[0]),
                new MataKuliah(Integer.valueOf(tempData[0]), tempData[1], Integer.valueOf(tempData[2])));
            }
        }
        tempData = null;
        reader.close();

    }

    public void listMahasiswa() throws IOException {
        FileReader file = new FileReader("ListMahasiswa.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            while (isInteger(tempData[0])) {
                mahasiswaMap.put(Integer.valueOf(tempData[0]),
                        new Mahasiswa(Integer.valueOf(tempData[0]), tempData[1], tempData[2]));
            }
        }
        tempData = null;
        reader.close();

    }

    // public void listDosen() throws IOException {
    //     FileReader file = new FileReader("ListDosen.txt");
    //     BufferedReader reader = new BufferedReader(file);
    //     String tempData[];
    //     while (reader.ready()) {
    //         tempData = reader.readLine().split(";");

    //         while (isInteger(tempData[0])) {
    //             dosenMap.put(Integer.valueOf(tempData[0]),
    //                     new dosen(Integer.valueOf(tempData[0]), tempData[1], Integer.valueOf(tempData[2])));
    //         }
    //     }
    //     tempData = null;
    //     reader.close();
    // }
        

    public MataKuliah getMataKuliah(Integer key) {
        return matKulMap.get(key);
    }

    public Mahasiswa getMahasiswa(Integer key) {
        return mahasiswaMap.get(key);
    }
    
    // public MataKuliah getMataKuliah(Integer key) {
    //     return matKulMap.get(key);
    // }

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