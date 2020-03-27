package midtest;

import java.io.*;
import java.util.*;

class AddList extends TodoList {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addList() throws IOException {

        FileWriter fileOutput = null;
        BufferedWriter bufferOutput = null;

        try {
            fileOutput = new FileWriter("kegiatan.txt", true);
            bufferOutput = new BufferedWriter(fileOutput);
        } catch (Exception e) {
            System.err.println("file tidak ditemukan");
        }

        System.out.print("Nama kegiatan : ");
        String name = sc.nextLine();

        System.out.print("Jadwal        : ");
        String schedule = sc.nextLine();

        System.out.println();
        System.out.println("1. sangat penting");
        System.out.println("2. penting");
        System.out.println("3. kurang penting");
        System.out.print("Prioritas     : ");
        int priority = sc.nextInt();
        String getPriority = getPriority(priority);

        System.out.println();
        System.out.println("1. selesai");
        System.out.println("2. sedang dikerjakan");
        System.out.println("3. belum dikerjakan");
        System.out.print("Status        : ");
        int status = sc.nextInt();
        String getStatus = getStatus(status);

        System.out.print("Deskripsi     : ");
        String desc = sc.next() + sc.nextLine();

        bufferOutput.write(name + ";" + schedule + ";" + getPriority + ";" + getStatus + ";" + desc);
        System.out.println("\nBerhasil menambahkan data");
        bufferOutput.newLine();
        bufferOutput.flush();

        bufferOutput.close();
        fileOutput.close();
    }

    private String getPriority(int priority) {
        if (priority == 1) {
            return "sangat penting";
        } else if (priority == 2) {
            return "penting";
        } else if (priority == 3) {
            return "kurang penting";
        } else {
            return "-";
        }
    }

    private String getStatus(int status) {
        if (status == 1) {
            return "selesai";
        } else if (status == 2) {
            return "sedang dikerjakan";
        } else if (status == 3) {
            return "belum dikerjakan";
        } else {
            return "-";
        }
    }
}