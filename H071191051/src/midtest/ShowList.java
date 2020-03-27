package midtest;

import java.io.*;
import java.util.StringTokenizer;

class ShowList extends TodoList {

    @Override
    public void showList() throws IOException {

        FileReader fileInput = null;
        BufferedReader bufferInput = null;

        try {
            fileInput = new FileReader("kegiatan.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("file tidak ditemukan");
        }

        String data = bufferInput.readLine();

        System.out.println(
                "+--------------------------------------------------------------------------------------------------------+");
        System.out.println("| No. | Nama kegiatan              \t\t| Jadwal\t | Prioritas\t    | Status\t         |");
        System.out.println(
                "+--------------------------------------------------------------------------------------------------------+");

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
        fileInput.close();
    }
}