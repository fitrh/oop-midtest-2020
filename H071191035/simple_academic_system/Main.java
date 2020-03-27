import java.util.Scanner;
/**
 * Main
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    static String s, userName, password;
    static int a;

    public static void main(String[] args) {
        
        Login login = Login.getInstance();

        // Mata Kuliah
        MataKuliah MatDas = new MataKuliah("619", "Matematika Dasar", "Dosen Matematika", 3, 10);
        MataKuliah Bindo = new MataKuliah("101", "Bahasa Indonesia", "Dosen Bahasa Indoensia", 2, 5);
        MataKuliah English = new MataKuliah("202", "Bahasa Inggris", "Dosen Bahasa Inggris", 2, 3);
        MataKuliah PendAgama = new MataKuliah("666", "Pendidikan Agama", "Dosen Agama", 3, 1);
        MataKuliah Wipteks = new MataKuliah("123", "Wawasan IPTEKS", "Dosen IPTEKS", 2, 3);
        MataKuliah Pkn = new MataKuliah("555", "Kewarganegaraan", "Dosen Kewarganegaraan", 3, 1);

        // perulangan menu utama
        while (true) {

            System.out.println("--MENU--");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Masukkan pilihan => ");
            a = scan.nextInt();

            // login
            if (a == 1) {

                System.out.println("--MENU--");
                System.out.println("1. Login mahasiswa");
                System.out.println("2. Login dosen");
                System.out.print("Masukkan pilihan => ");
                a = scan.nextInt();

                // login sebagai mahasiswa
                if (a == 1) {

                    System.out.println("--Input your username & password below--");
                    System.out.print("Username => ");
                    userName  = scan.next();
                    System.out.print("Password => ");
                    password = scan.next();

                    // perulangan menu mahasiswa
                    while(login.authMahasiswa(userName, password)) {
                        System.out.println("--WELCOME MAHASISWA--");
                        System.out.println("1. Lihat profil");
                        System.out.println("2. Tambah Mata Kuliah");
                        System.out.println("3. Hapus Mata Kuliah");
                        System.out.println("4. Logout");
                        System.out.print("Masukkan pilihan => ");
                        a = scan.nextInt();

                        // menampilkan profil mahasiswa
                        if (a == 1) {
                            login.statusMahasiswa();

                        // melakukan penambahan mata kuliah
                        } else if (a == 2) {
                            System.out.println("--DAFTAR MATA KULIAH--");
                            System.out.println("1. Matematika Dasar");
                            System.out.println("2. Bahasa Indonesia");
                            System.out.println("3. Bahasa Inggris");
                            System.out.println("4. Pendidikan Agama");
                            System.out.println("5. Wawasan IPTEKS");
                            System.out.println("6. Kewarganegaraan");
                            System.out.print("Masukkan pilihan  => ");
                            a = scan.nextInt();

                            if (a == 1) {
                                login.getUser().addMataKuliah(MatDas);
                            } else if (a == 2) {
                                login.getUser().addMataKuliah(Bindo);
                            } else if (a == 3) {
                                login.getUser().addMataKuliah(English);
                            } else if (a == 4) {
                                login.getUser().addMataKuliah(PendAgama);
                            } else if (a == 5) {
                                login.getUser().addMataKuliah(Wipteks);
                            } else if (a == 6) {
                                login.getUser().addMataKuliah(Pkn);
                            } else {
                                System.out.println("Opsi tidak terdapat dalam pilihan...");
                            }

                        // melakukan penghapusan mata kuliah
                        } else if (a == 3) {
                            login.getUser().showMatkul();
                            System.out.println("Silahkan memilih mata kuliah yang akan dihapus");
                            System.out.print("Masukkan kode matakuliah  => ");
                            s = scan.next();

                            if (s.equals(MatDas.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(MatDas);
                            } else if (s.equals(Bindo.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(Bindo);
                            } else if (s.equals(English.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(English);
                            } else if (s.equals(PendAgama.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(PendAgama);
                            } else if (s.equals(Wipteks.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(Wipteks);
                            } else if (s.equals(Pkn.getKodeMatkul())) {
                                login.getUser().removeMataKuliah(Pkn);
                            } else {
                                System.out.println("Mata kuliah tidak ditemukan...");
                            }

                        // logout akun mahasiswa
                        } else {
                            login.logout();
                            break;
                        }
                    }

                // login sebagai dosen
                } else {

                    System.out.println("--Input your username & password below--");
                    System.out.print("Username => ");
                    userName  = scan.next();
                    System.out.print("Password => ");
                    password = scan.next();

                    // perulangan menu dosen
                    while(login.authDosen(userName, password)) {
                        System.out.println("--WELCOME DOSEN--");
                        System.out.println("1. Lihat profil");
                        System.out.println("2. Lihat mahasiswa bimbingan");
                        System.out.println("3. Logout");
                        System.out.print("Masukkan pilihan  => ");
                        a = scan.nextInt();

                        // manimpilkan profil dosen
                        if (a == 1) {
                            System.out.println(login.getAuth());
                            login.statusDosen();

                        // menampilkan mahasiswa bimbingan dosen
                        } else if (a == 2) {
                           login.getDosenPa().showMahasiswaBimmbingan();

                        // logout akun dosen
                        } else {
                            login.logout();
                            break;
                        }
                    }
                }

            // exit
            } else {
                break;
            }
        }
        scan.close();
    }
}