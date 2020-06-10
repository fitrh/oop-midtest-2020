import java.io.*;
import java.util.*;

class DeleteList extends TodoList {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void deleteList() throws IOException {
        super.deleteList();
        // baca database yang asli
        File file = new File("kegiatan.txt");
        FileReader fileInput = new FileReader(file);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        // buat database sementara
        File tempFile = new File("temp.txt");
        FileWriter fileOutput = new FileWriter(tempFile);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // data perbaris akan di tampung di sini
        String data = bufferInput.readLine();

        // cek file apakah kosong atau tidak
        if (data == null) {
            System.out.println("Daftar kegiatan masih kosong");
            closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
            return;
        }

        // ambil inputan user untuk delete data
        System.out.print("Masukkan nomor kegiatan yang ingin dihapus : ");
        int delete = sc.nextInt();

        // cek apakah nomor yang dipilih ada pada baris yang ada di database
        boolean dataIsExist = checkLineisExist(delete, bufferInput, bufferOutput, data);
        if (!dataIsExist) {
            System.out.println("\nKegiatan tidak ada");
            closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
            return;
        }

        // kalau ada, buat looping untuk membaca baris pada file dan menghapus data
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

                isDelete = getYerOrNo("Apakah anda yakin ingin menghapus kegiatan? (y/n)");

                if (!isDelete) {
                    System.out.println("\nHapus kegiatan dibatalkan");
                }

            }

            if (isDelete) {
                // skip memasukkan file ke database sementara(di abaikan)
                System.out.println("\nBerhasil menghapus kegiatan");
            } else {
                // memasukkan data dari database asli ke database sementara
                bufferOutput.write(data);
                bufferOutput.newLine();
            }
            // membaca kembali baris selanjutnya
            data = bufferInput.readLine();
        }
        // gunakan .flush() untuk menulis data ke file
        bufferOutput.flush();
        closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
    }
}