package app;

import java.util.*;
import java.io.*;

/**
 * MatKulData
 */
public class MatKulData {

    private ArrayList<MataKuliah> matKulList = new ArrayList<>();

    public MatKulData() throws IOException {
        listMatKul();
    }

    public void listMatKul() throws IOException {
        FileReader file = new FileReader(
                "Academic System\\ListMatKul.txt");
        BufferedReader reader = new BufferedReader(file);
        String tempData[];
        while (reader.ready()) {
            tempData = reader.readLine().split(";");

            if (isInteger(tempData[0])) {
                matKulList.add(new MataKuliah(Integer.valueOf(tempData[0]), tempData[1], Integer.valueOf(tempData[2]),
                        tempData[3]));

            }
        }
        tempData = null;
        reader.close();

    }

    public void showMatKul() {
        System.out.println("-- Daftar Mata Kuliah --");
        for (int i = 0; i < matKulList.size(); i++) {
            System.out.println((i + 1) + ". " + matKulList.get(i).getNameCourse());
            System.out.println("\tKode Mata Kuliah  : " + matKulList.get(i).getIdCourse());
            System.out.println("\tJumlah SKS        : " + matKulList.get(i).getSksCourse());
            System.out.println("\tDosen             : " + matKulList.get(i).getNamaDosenCourse());
        }
    }

    public ArrayList<MataKuliah> getMataKuliah() {
        return matKulList;
    }

    public static boolean isInteger(String s) {
        // This method checks if a string is an integer
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            // s is a valid integer

            isValidInteger = true;
        } catch (NumberFormatException ex) {
            // s is not an integer
        }

        return isValidInteger;
    }
}