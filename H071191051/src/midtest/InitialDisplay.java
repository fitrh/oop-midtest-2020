package midtest;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class InitialDisplay {
    private Scanner sc = new Scanner(System.in);
    private Registration registration = new Registration();

    public void mainMenu() throws IOException {
        // registrasi terlebih dahulu
        registration.registration();
        clearScreen();

        // setelah registrasi maka akan muncul tampilan menu
        while (true) {
            homeMenu();
            System.out.print("> ");
            int choice = sc.nextInt();

            if (choice == 1) {
                clearScreen();
                System.out.println("+------------ To-Do-List Hari ini ------------+\n");
                setTime();
                ShowList show = new ShowList();
                show.showList();

            } else if (choice == 2) {
                clearScreen();
                System.out.println("+-------------- Hapus kegiatan ---------------+");
                DeleteList delete = new DeleteList();
                delete.deleteList();
                TodoList rename = new TodoList();
                rename.deleteList();
            } else if (choice == 3) {
                System.out.println("+-------------- Edit kegiatan ----------------+");
                // edit kegiatan
                clearScreen();

            } else if (choice == 4) {
                System.out.println("+------------- Tambah kegiatan ---------------+");
                AddList add = new AddList();
                add.addList();
            } else if (choice == 5) {
                System.out.println("+------------ Deskripsi kegiatan -------------+");
                // deskripsi kegiatan
                clearScreen();

            } else if (choice == 6) {
                clearScreen();
                System.out.println("+------------------ Biodata ------------------+");
                System.out.print(registration.getBiodata());
                System.out.println("+---------------------------------------------+");

            } else if (choice == 0) {
                break;
            } else {
                clearScreen();
            }
        }
    }

    // homeMenu-Method untuk menampilkan menu awal
    private void homeMenu() {
        System.out.println("\n+---------------- To-Do-List -----------------+");
        System.out.println("\n" + "Hello " + registration.getCallName() + " ^_^" + "\n");
        setTime();
        System.out.println("1. Lihat To-do-list Harian");
        System.out.println("2. Hapus kegiatan");
        System.out.println("3. Edit kegiatan");
        System.out.println("4. Tambahkan kegiatan");
        System.out.println("5. Lihat Deskripsi kegiatan");
        System.out.println("6. Lihat Biodata anda");
        System.out.println("0. Exit");
    }

    // setTime-Method untuk menampilkan tahun,bulan,tanggal,hari,jam saat ini.
    private void setTime() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String s = LocalDate.now().getDayOfWeek().name();
        System.out.println("Today is : " + s.toLowerCase() + ", " + date.format(now) + ".");
        System.out.println("it's     : " + time.format(now) + "\n");
    }

    // clearScreen-Method untuk menghapus entry sebelumnya pada terminal
    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) { // untuk os windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // untuk bukan windows
                System.out.println("\033\143");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}