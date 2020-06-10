import java.io.*;
import java.util.*;

class EditList extends TodoList {
    private Scanner sc;

    @Override
    public void editList() throws IOException {
        super.editList();
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
            System.out.println("Daftar kegiatan masih kosong");
            closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
            return;
        }

        // ambil inputan user untuk edit data
        System.out.print("Masukkan nomor kegiatan yang ingin diedit : ");
        sc = new Scanner(System.in);
        int edit = sc.nextInt();

        // check apakah nomor yang dipilih ada pada baris yang ada di database
        boolean dataIsExist = checkLineisExist(edit, bufferInput, bufferOutput, data);
        if (!dataIsExist) {
            System.out.println("\nKegiatan tidak ada");
            closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
            return;
        }

        // buat looping untuk membaca baris pada file dan mengedit data yang diinput
        int currentEntry = 0;

        while (data != null) {
            currentEntry++;
            // String token untuk membaca data perbaris
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

                // update data dimana String[] newField merupakan data hasil update
                String[] field = { "nama", "jadwal", "prioritas", "status", "deskripsi" };
                String[] newField = new String[5];
                // String token untuk membaca baris yang diinput User
                stringTokens = new StringTokenizer(data, ";");
                // skip primarykey dari data yang diinput User
                String dataField = stringTokens.nextToken();

                for (int i = 0; i < field.length; i++) {
                    boolean isEdit = getYerOrNo("ubah " + field[i] + " kegiatan ? (y/n)");
                    dataField = stringTokens.nextToken();

                    if (isEdit) {
                        System.out.print("masukkan " + field[i] + " kegiatan baru : ");
                        // memanggil object addList
                        AddList add = new AddList();
                        sc = new Scanner(System.in);

                        if (i == 2) {
                            System.out.print("\n");
                            add.priorityChoice();
                            String choice = sc.next();
                            newField[i] = add.getPriority(Integer.parseInt(choice));
                        } else if (i == 3) {
                            System.out.print("\n");
                            add.statusChoice();
                            String choice = sc.next();
                            newField[i] = add.getStatus(Integer.parseInt(choice));
                        } else {
                            newField[i] = sc.nextLine();
                        }

                    } else {
                        newField[i] = dataField;
                    }

                }

                // menampilkan data yang di edit ke layar
                stringTokens = new StringTokenizer(data, ";");
                System.out.println("\n+------------ kegiatan baru anda -------------+");
                System.out.println("+---------------------------------------------+");
                stringTokens.nextToken();
                System.out.println("Nama kegiatan   : " + stringTokens.nextToken() + " --> " + newField[0]);
                System.out.println("Jadwal          : " + stringTokens.nextToken() + " --> " + newField[1]);
                System.out.println("Prioritas       : " + stringTokens.nextToken() + " --> " + newField[2]);
                System.out.println("Status          : " + stringTokens.nextToken() + " --> " + newField[3]);
                System.out.println("Deskripsi       : " + stringTokens.nextToken() + " --> " + newField[4]);

                boolean isEdit = getYerOrNo("tekan 'y' untuk lanjut dan tekan 'n' untuk membatalkan");

                if (isEdit) {
                    // jika pilihan y, maka data pada newField akan dimasukkan ke database sementara
                    System.out.println("\nBerhasil mengedit kegiatan");
                    bufferOutput.write(newField[0].replaceAll("\\s+", "") + ";" + newField[0] + ";" + newField[1] + ";"
                            + newField[2] + ";" + newField[3] + ";" + newField[4]);
                } else {
                    // jika pilihan bukan y, maka yang di masukkan adalah data sebelumnya
                    System.out.println("\nEdit kegiatan dibatalkan");
                    bufferOutput.write(data);
                }
            } else {
                // mengcopy data dari database asli ke database sementara
                bufferOutput.write(data);
            }
            // membuat baris baru pada database sementara
            bufferOutput.newLine();
            // membaca kembali baris selanjutnya
            data = bufferInput.readLine();
        }
        // gunakan .flush() untuk menulis data ke file
        bufferOutput.flush();
        closeIO(fileInput, bufferInput, fileOutput, bufferOutput);
    }
}