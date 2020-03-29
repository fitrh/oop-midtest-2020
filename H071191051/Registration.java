import java.text.*;
import java.util.*;

class Registration {
    private String biodata;
    private String callName;
    private Scanner sc = new Scanner(System.in);

    public void registration() {
        Map<Character, String> facultyMap = new HashMap<Character, String>();
        // meletakkan daftar kode setiap fakultas
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
                String callName = sc.nextLine();
                System.out.print("Tanggal lahir  : ");
                String date = sc.next() + sc.nextLine();
                System.out.print("NIM            : ");
                String nim = sc.next();
                // memanggil object Biodata
                Biodata bio = new Biodata(name, date, nim, callName);
                bio.setFaculty(facultyMap);
                bio.setRegisterYear(nim);
                bio.setEmail(bio.getName());
                // try-catch untuk mengecek apakah format tanggal lahir sudah benar
                try {
                    bio.setAge(bio.getDateOfBirth());
                } catch (ParseException pe) {
                    System.out.print("");
                }

                // jika NIM yang diinput tidak ada dalam daftar hashMap di atas, maka:
                if (bio.getFaculty() == null) {
                    System.out.println("\nNIM tidak ada dalam daftar\n");
                    // jika format tanggal lahir salah, maka:
                } else if (bio.getAge() == null) {
                    System.out.println("\nFormat tanggal lahir tidak sesuai (gunakan format dd-MM-yyyy)\n");
                } else {
                    this.biodata = bio.getDescription();
                    this.callName = bio.getCallName();
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

    public String getCallName() {
        return callName;
    }
}