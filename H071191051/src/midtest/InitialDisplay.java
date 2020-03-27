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
                // menampilkan semua jadwal kegiatan
                boolean condition = true;

                while (condition) {
                    System.out.println("+------------ To-Do-List Hari ini ------------+\n");
                    setTime();
                    TodoList toDo = new ShowList();
                    toDo.showList();
                    System.out.println("1. Hapus kegiatan");
                    System.out.println("2. Edit kegiatan");
                    System.out.println("3. Tambahkan kegiatan");
                    System.out.println("4. Lihat Deskripsi kegiatan");
                    System.out.println("0. Exit");
                    System.out.print("> ");
                    String choice_2 = sc.next();
                    switch (choice_2) {
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                        default:
                            clearScreen();
                            condition = false;
                            break;
                    }
                }
            } else if (choice == 2) {
                clearScreen();
                System.out.println("+------------------ Biodata ------------------+");
                System.out.print(registration.getBiodata());
                System.out.println("+---------------------------------------------+");
            } else if (choice == 0) {
                break;
            }
        }
    }

    // homeMenu-Method untuk menampilkan menu awal
    private void homeMenu() {
        System.out.println("\n+---------------- To-Do-List -----------------+");
        System.out.println("\n" + "Hello " + registration.getCallName() + " ^_^" + "\n");
        setTime();
        System.out.println("1. Lihat To-do-list Harian");
        System.out.println("2. Lihat Biodata");
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