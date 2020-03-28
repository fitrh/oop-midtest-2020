package midtest;

import java.io.*;
import java.util.*;

class DescriptionList extends TodoList {
    private Scanner sc;

    @Override
    public void descList() throws IOException {

        boolean condition = true;

        // buat looping
        while (condition) {
            // baca file dulu
            FileReader fileInput = null;
            BufferedReader bufferInput = null;

            try {
                fileInput = new FileReader("kegiatan.txt");
                bufferInput = new BufferedReader(fileInput);
            } catch (Exception e) {
                System.err.println("file tidak ditemukan");
            }

            String data = bufferInput.readLine();

            // cek file apakah kosong atau tidak
            if (data == null) {
                System.out.println("\nDaftar kegiatan masih kosong");
                bufferInput.close();
                condition = false;
            }

            // cek kegiatan no berapa yang ingin dilihat deskripsinya
            System.out.print("Masukkan nomor kegiatan yang ingin dilihat deskripsinya : ");
            sc = new Scanner(System.in);
            int desc = sc.nextInt();
            if (desc == 0) {
                bufferInput.close();
                condition = false;
            }
            System.out.print("\n");

            // cek apakah nomor yang dipilih ada pada baris yang ada di database
            if (checkTotalLineatFile() < desc || 1 > desc) {
                System.out.println("Kegiatan tidak ada\n");
            } else {
                int currentEntry = 0;
                while (data != null) {
                    currentEntry++;
                    StringTokenizer stringTokens = new StringTokenizer(data, ";");

                    if (desc == currentEntry) {
                        super.descList();
                        stringTokens.nextToken();
                        System.out.println("Nama kegiatan   : " + stringTokens.nextToken());
                        for (int i = 0; i < 3; i++) {
                            stringTokens.nextToken();
                        }
                        System.out.println("Deskripsi       : " + stringTokens.nextToken() + "\n");
                    }
                    data = bufferInput.readLine();
                }
            }
            System.out.println("Tekan '0' untuk kembali ke menu utama");
            bufferInput.close();
        }
    }
}