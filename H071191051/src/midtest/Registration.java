package midtest;

import java.text.*;
import java.util.*;

class Registration extends TodoList {
    private String biodata;
    private String calledName;
    private Scanner sc = new Scanner(System.in);

    public void registration() {
        Map<Character, String> facultyMap = new HashMap<Character, String>();

        facultyMap.put('A', "Kedokteran");
        facultyMap.put('B', "Farmasi");
        facultyMap.put('C', "Teknik");
        facultyMap.put('D', "Kehutanan");
        facultyMap.put('E', "Pertanian");
        facultyMap.put('F', "Keperawatan");
        facultyMap.put('G', "Kesehatan Masyarakat");
        facultyMap.put('H', "MIPA");

        while (true) {
            registShow();
            int c = sc.nextInt();
            if (c == 1) {
                System.out.print("\n");
                System.out.print("Nama           : ");
                String name = sc.next() + sc.nextLine();
                System.out.print("Nama panggilan : ");
                String callName = sc.next();
                System.out.print("Tanggal lahir  : ");
                String date = sc.next() + sc.nextLine();
                System.out.print("NIM            : ");
                String nim = sc.next();

                Biodata bio = new Biodata(name, date, nim, callName);
                bio.setFaculty(facultyMap);
                bio.setRegisterYear(nim);
                bio.setEmail(bio.getName());

                try {
                    bio.setAge(bio.getDateOfBirth());
                } catch (ParseException pe) {
                    System.out.print("");
                }

                if (bio.getFaculty() == null) {
                    System.out.println("\nNIM tidak ada dalam daftar\n");
                } else if (bio.getAge() == null) {
                    System.out.println("\nFormat tanggal lahir tidak sesuai (gunakan format dd-MM-yyyy)\n");
                } else {
                    System.out.println("\nPendaftaran Berhasil");
                    this.calledName = callName;
                    this.biodata = bio.getDescription();
                    break;
                }
            }
        }
    }

    private void registShow() {
        System.out.println("+---------------- To Do List ----------------+");
        System.out.println("\nTekan 1 untuk melakukan pendaftaran terlebih dahulu");
        System.out.println("NB : Dikhususkan untuk Mahasiswa Unhas\n");
        System.out.print("> ");
    }

    public String getBiodata() {
        return biodata;
    }

    @Override
    public String getCallName() {
        return calledName;
    }
}