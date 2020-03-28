package midtest;

import java.io.*;
import java.util.*;

class DeleteList extends TodoList {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void deleteList() throws IOException {
        // baca database yang asli
        File file = new File("kegiatan.txt");
        FileReader fileInput = new FileReader(file);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        // buat database sementara
        File tempFile = new File("temp.txt");
        FileWriter fileOutput = new FileWriter(tempFile);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        String data = bufferInput.readLine();

        // cek file apakah kosong atau tidak
        if (data == null) {
            System.out.println("\nDaftar kegiatan masih kosong");
            bufferInput.close();
            bufferOutput.close();
            return;
        }

        // ambil inputan user untuk delete data
        System.out.print("Masukkan nomor kegiatan yang ingin dihapus : ");
        int delete = sc.nextInt();

        // buat looping untuk membaca baris pada file dan menghapus data yang diinput
        int currentEntry = 0;

        while (data != null) {
            currentEntry++;
            boolean isDelete = false;
            StringTokenizer stringTokens = new StringTokenizer(data, ";");

            if (delete == currentEntry) {
                System.out.println("\n+----- kegiatan yang akan dihapus adalah -----+");
                System.out.println("+---------------------------------------------+");
                stringTokens.nextToken();
                System.out.println("Nama kegiatan   : " + stringTokens.nextToken());
                System.out.println("Jadwal          : " + stringTokens.nextToken());
                System.out.println("Prioritas       : " + stringTokens.nextToken());
                System.out.println("Status          : " + stringTokens.nextToken());
                System.out.println("Deskripsi       : " + stringTokens.nextToken());

                isDelete = getYerOrNo("Apakah anda yakin ingin menghapus data? (y/n)");

                if (isDelete == true) {
                    System.out.println("\nBerhasil menghapus kegiatan");
                } else {
                    // memindahkan data dari original ke sementara
                    System.out.println("\nKegiatan tidak dihapus");
                    bufferOutput.write(data);
                    bufferOutput.newLine();
                }
            } else {
                System.out.println("\nKegiatan tidak ada");
                bufferOutput.write(data);
                bufferOutput.newLine();
            }
            data = bufferInput.readLine();
        }
        // menulis data ke file
        bufferOutput.flush();
        closeIO(fileInput, fileOutput, bufferInput, bufferOutput);
    }
}