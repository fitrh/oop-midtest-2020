package app;

import java.io.*;
import java.util.*;

/**
 * DataSource
 */
public class DataSource {

    private Map<Integer, MataKuliah> matKulMap = new HashMap<>();
    //private Map<Integer, Mahasiswa> mahasiswaMap = new HashMap<>();
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