import java.io.*;
import java.util.*;

class AddList extends TodoList {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addList() throws IOException {
        super.addList();
        
        FileWriter fileOutput = null;
        BufferedWriter bufferOutput = null;

        // cek file apakah ada atau tidak
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
        priorityChoice();
        System.out.print("Prioritas     : ");
        int priority = sc.nextInt();
        String getPriority = getPriority(priority);

        System.out.println();
        statusChoice();
        System.out.print("Status        : ");
        int status = sc.nextInt();
        String getStatus = getStatus(status);

        System.out.print("Deskripsi     : ");
        String desc = sc.next() + sc.nextLine();

        System.out.println("\nBerhasil menambahkan kegiatan");
        // menambahkan data ke file
        bufferOutput.write(name.replaceAll("\\s+", "") + ";" + name + ";" + schedule + ";" + getPriority + ";"
                + getStatus + ";" + desc);
        // menambahkan line pada 
        bufferOutput.newLine();
        // gunakan .flush() untuk menulis data ke file
        bufferOutput.flush();
        closeIO(fileOutput, bufferOutput);
    }

    public String getPriority(int priority) {
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

    public String getStatus(int status) {
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

    public void priorityChoice() {
        System.out.println("1. sangat penting");
        System.out.println("2. penting");
        System.out.println("3. kurang penting");
    }

    public void statusChoice() {
        System.out.println("1. selesai");
        System.out.println("2. sedang dikerjakan");
        System.out.println("3. belum dikerjakan");
    }
}