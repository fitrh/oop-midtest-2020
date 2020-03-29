import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class TDL extends ListTDL {
    @Override
    public void showList() throws IOException {
        String namaFile = "JadwalQ.txt";
        String jkqtxt = read(namaFile);

        if (!jkqtxt.equals("")) {
            System.out.println("\nDaftar Kegiatan: ");

            String[] list = jkqtxt.split("#");

            for (int i = 0; i < list.length; i++) {
                String[] usr = list[i].split(";");
                System.out.println((i + 1) + ". " + usr[0]);
            }
        } else {
            System.out.println("Tidak ada Data");
        }
    }

    @Override
    public void add() throws IOException {
        String namaFile = "JadwalQ.txt";
        String[] tdl = new String[] { "Nama kegiatan\t", "Deskripsi\t", "Jadwal\t\t", "Status\t\t",
                "Skala prioritas\t" };
        Scanner scan = new Scanner(System.in);
        String usr = "";

        // Menampilkan format input output
        for (int i = 0; i < tdl.length; i++) {
            System.out.print(tdl[i] + ": ");

            // Setiap input nilai attribut diakhiri dengan tanda ';'
            usr += scan.nextLine() + "; ";
        }
        // isi file JadwalQ.txt
        write(namaFile, usr);
    }

    @Override
    public void update(int i) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        ArrayList<String> list = new ArrayList<String>();
        String[] tdl = new String[] { "Nama kegiatan\t", "Deskripsi\t", "Jadwal\t\t", "Status\t\t",
                "Skala prioritas\t" };
        String namaFile = "JadwalQ.txt";
        Scanner scan = new Scanner(System.in);

        String usr = "";
        String isi = "";
        try {
            fileReader = new FileReader(namaFile);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                isi += str;
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }
        String[] orList = isi.split(" # ");
        for (String text : orList) {
            list.add(text);
        }
        scan.nextLine();

        for (int j = 0; j < tdl.length; j++) {
            System.out.print(tdl[j] + ": ");
            usr += scan.nextLine() + "; ";
        }
        list.set(i, usr);
        isi = "";
        for (int j = 0; j < list.size(); j++) {
            isi += list.get(j) + " # ";
        }
        try {
            fileWriter = new FileWriter(namaFile);
            fileWriter.write(isi);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    @Override
    public void detail(int i) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        ArrayList<String> list = new ArrayList<String>();
        String[] tdl = new String[] { "Nama kegiatan\t", "Deskripsi\t", "Jadwal\t\t", "Status\t\t",
                "Skala prioritas\t" };
        String namaFile = "JadwalQ.txt";
        String res = "";
        try {
            fileReader = new FileReader(namaFile);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                res += str;
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        String[] orList = res.split(" # ");
        for (String text : orList) {
            list.add(text);
        }
        String[] det = list.get(i).split("; ");
        for (int j = 0; j < det.length; j++) {
            System.out.printf("%s: %s\n", tdl[j], det[j]);
        }
    }

    @Override
    public void delete(int i) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        ArrayList<String> list = new ArrayList<String>();
        FileWriter fileWriter = null;
        String namaFile = "JadwalQ.txt";
        String isi = "";
        try {
            fileReader = new FileReader(namaFile);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                isi += str;
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }
        String[] orList = isi.split(" # ");
        for (String text : orList) {
            list.add(text);
        }
        list.remove(i);
        isi = "";
        for (int j = 0; j < list.size(); j++) {
            isi += list.get(j) + " # ";
        }
        try {
            fileWriter = new FileWriter(namaFile);
            fileWriter.write(isi);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    @Override
    public String read(String name) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File file = new File(name);
        String isi = "";

        // Cek apakah file ada
        // jika tidak ada, bikin file baru
        if (!file.isFile()) {
            file.createNewFile();
        } else {
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    isi += str;
                }
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            }
        }
        return isi;
    }

    @Override
    public boolean write(String name, String text) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(name, true);
            fileWriter.append(text);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
                return true;
            }
        }
        return false;
    }
}