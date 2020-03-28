package midtest;

import java.io.*;
import java.util.*;

class EditList extends TodoList {
    private Scanner sc;

    @Override
    public void editList() throws IOException {
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

        // ambil inputan user untuk edit data
        System.out.print("Masukkan nomor kegiatan yang ingin diedit : ");
        sc = new Scanner(System.in);
        int edit = sc.nextInt();

        // buat looping untuk membaca baris pada file dan mengedit data yang diinput
        int currentEntry = 0;

        while (data != null) {
            currentEntry++;
            StringTokenizer stringTokens = new StringTokenizer(data, ";");

            if (edit == currentEntry) {
                System.out.println("\n+----- kegiatan yang akan diedit adalah ------+");
                System.out.println("+---------------------------------------------+");
                stringTokens.nextToken();
                System.out.println("Nama kegiatan   : " + stringTokens.nextToken());
                System.out.println("Jadwal          : " + stringTokens.nextToken());
                System.out.println("Prioritas       : " + stringTokens.nextToken());
                System.out.println("Status          : " + stringTokens.nextToken());
                System.out.println("Deskripsi       : " + stringTokens.nextToken() + "\n");

                // update data
                String[] field = { "nama", "jadwal", "prioritas", "status", "deskripsi" };
                String[] newField = new String[5];

                stringTokens = new StringTokenizer(data, ";");
                String dataField = stringTokens.nextToken();

                for (int i = 0; i < field.length; i++) {
                    boolean isEdit = getYerOrNo("ubah " + field[i] + " kegiatan ? (y/n)");
                    dataField = stringTokens.nextToken();

                    if (isEdit) {
                        System.out.print("masukkan " + field[i] + " kegiatan baru : ");
                        sc = new Scanner(System.in);
                        newField[i] = sc.nextLine();
                    } else {
                        newField[i] = dataField;
                    }
                }

                // menampilkan data yang di edit ke layar
                stringTokens = new StringTokenizer(data, ";");
                System.out.println("+------------ kegiatan baru anda -------------+");
                System.out.println("+---------------------------------------------+");
                stringTokens.nextToken();
                System.out.println("Nama kegiatan   : " + stringTokens.nextToken() + " -> " + newField[0]);
                System.out.println("Jadwal          : " + stringTokens.nextToken() + " -> " + newField[1]);
                System.out.println("Prioritas       : " + stringTokens.nextToken() + " -> " + newField[2]);
                System.out.println("Status          : " + stringTokens.nextToken() + " -> " + newField[3]);
                System.out.println("Deskripsi       : " + stringTokens.nextToken() + " -> " + newField[4]);

                boolean isEdit = getYerOrNo("tekan 'y' untuk lanjut dan tekan 'n' untuk membatalkan");

                if (isEdit == true) {
                    System.out.println("\nBerhasil menambahkan kegiatan");
                    bufferOutput.write(newField[0].replaceAll("\\s+", "") + ";" + newField[0] + ";" + newField[1] + ";"
                            + newField[2] + ";" + newField[3] + ";" + newField[4]);
                } else {
                    System.out.println("\nEdit kegiatan dibatalkan");
                    bufferOutput.write(data);
                }
            } else {
                System.out.println("\nKegiatan tidak ada");
                bufferOutput.write(data);
            }
            bufferOutput.newLine();
            data = bufferInput.readLine();
        }
        bufferOutput.flush();
        closeIO(fileInput, fileOutput, bufferInput, bufferOutput);
    }
}