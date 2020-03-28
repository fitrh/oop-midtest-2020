package app;

import java.util.*;
import java.io.*;

/**
 * DosenPAData
 */
public class DosenPAData {

    private Map<String, DosenPA> dosenMap = new HashMap<>();
    private Map<Integer, DetailDosenPA> detailDosenMap = new HashMap<>();
    private ArrayList<Mahasiswa> mahasiswaBimbinganList = new ArrayList<>();
    private MahasiswaData mahasiswaData;

    public DosenPAData() throws IOException {
        listDetailDosen();
        listDosen();
        mahasiswaData = new MahasiswaData();
        listMahasiswaBimbingan();
    }

    public void listDosen() throws IOException{
        FileReader file = new FileReader("D:\\richard\\College\\Semester 2\\Object Oriented Program\\oop-midtest-2020\\H071191055\\Academic System\\ListAkunDosen.txt");
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
        FileReader file = new FileReader("D:\\richard\\College\\Semester 2\\Object Oriented Program\\oop-midtest-2020\\H071191055\\Academic System\\DetailDosen.txt");
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

    public void listMahasiswaBimbingan() throws IOException{
        FileReader file = new FileReader("D:\\richard\\College\\Semester 2\\Object Oriented Program\\oop-midtest-2020\\H071191055\\Academic System\\MahasiswaBimbingan.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        String temp[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");
            if (isInteger(tempData[0])) {
                temp = tempData[1].split(",");
                for (int i = 0; i < temp.length; i++) {
                    mahasiswaBimbinganList.add(mahasiswaData.getMahasiswa(temp[i]));
                }
            }
        }
        tempData = null;
        reader.close();
    }

    public DosenPA getDosen(String key) {
        return dosenMap.get(key);
    }

    public DetailDosenPA gDetailDosen(Integer key) {
        return detailDosenMap.get(key);
    }

    public ArrayList<Mahasiswa> getMahasiswaBimbingan() {
        return mahasiswaBimbinganList;
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