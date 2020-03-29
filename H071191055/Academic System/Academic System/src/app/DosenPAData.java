package app;

import java.util.*;
import java.io.*;

/**
 * DosenPAData
 */
public class DosenPAData {

    private Map<String, DosenPA> dosenMap = new HashMap<>();
    private Map<Integer, DetailDosenPA> detailDosenMap = new HashMap<>();
    private Map<Integer, ArrayList<String>> mahasiswaBimbingamMap = new HashMap<>();
    private ArrayList<String> userNameMahasiswaBimbinganList = new ArrayList<>();
    private MahasiswaData mahasiswaData;

    public DosenPAData() throws IOException {
        listDetailDosen();
        listDosen();
        mahasiswaData = new MahasiswaData();
        listMahasiswaBimbingan();
    }

    public void listDosen() throws IOException{
        FileReader file = new FileReader("ListAkunDosen.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");
            if (isInteger(tempData[0])) {
                dosenMap.put(tempData[1], new DosenPA(Integer.valueOf(tempData[0]), tempData[1], tempData[2],
                            detailDosenMap.get(Integer.valueOf(tempData[0]))));
            }
        }
        tempData = null;
        reader.close();
    }
    
    public void listDetailDosen() throws IOException{
        FileReader file = new FileReader("DetailDosen.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");
            if (isInteger(tempData[0])) {
                detailDosenMap.put(Integer.valueOf(tempData[0]), 
                new DetailDosenPA(Integer.valueOf(tempData[0]), tempData[1], tempData[2], tempData[3]));
            }
        }
        tempData = null;
        reader.close();
    }

    public void listMahasiswaBimbingan() throws IOException {
        FileReader file = new FileReader("MahasiswaBimbingan.txt");
        BufferedReader reader = new BufferedReader(file);
        String[] tempData;
        String temp[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");
            if (isInteger(tempData[0])) {
                temp = tempData[1].split(",");
                for (int i = 0; i < temp.length; i++) {
                    userNameMahasiswaBimbinganList.add(temp[i]);
                }
                mahasiswaBimbingamMap.put(Integer.valueOf(tempData[0]), userNameMahasiswaBimbinganList);
            }
        }
        tempData = null;
        temp = null;
        reader.close();
    }

    public DosenPA getDosen(String key) {
        return dosenMap.get(key);
    }

    public DetailDosenPA gDetailDosen(Integer key) {
        return detailDosenMap.get(key);
    }

    public ArrayList<String> getUsernameMB(Integer key) {
        return mahasiswaBimbingamMap.get(key);
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