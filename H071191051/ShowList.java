import java.io.*;
import java.util.*;

class ShowList extends TodoList {

    @Override
    public void showList() throws IOException {

        // baca file terlebih dahulu
        FileReader fileInput = null;
        BufferedReader bufferInput = null;

        // cek file apakah ada atau tidak
        try {
            fileInput = new FileReader("kegiatan.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("file tidak ditemukan");
        }

        // data perbaris akan dibaca disini
        String data = bufferInput.readLine();

        // format tatanan tabel
        System.out.println(
                "+--------------------------------------------------------------------------------------------------------+");
        System.out.println("| No. | Nama kegiatan              \t\t| Jadwal\t | Prioritas\t    | Status\t         |");
        System.out.println(
                "+--------------------------------------------------------------------------------------------------------+");

        // jika daftar kegiatan pada file kosong, maka :
        if (data == null) {
            System.out.println("|\t\t\t\t     Daftar kegiatan masih kosong!     \t\t\t\t\t |");
        }

        // apabila ada, maka :
        int number = 0;
        while (data != null) {
            number++;
            StringTokenizer stringTokens = new StringTokenizer(data, ";");
            stringTokens.nextToken();
            System.out.printf("|  %d  ", number);
            System.out.printf("| %-40s", stringTokens.nextToken());
            System.out.printf("| %-15s", stringTokens.nextToken());
            System.out.printf("| %-17s", stringTokens.nextToken());
            System.out.printf("| %-19s|", stringTokens.nextToken());
            System.out.print("\n");
            data = bufferInput.readLine();
        }

        System.out.println(
                "+--------------------------------------------------------------------------------------------------------+");
        bufferInput.close();
    }
}