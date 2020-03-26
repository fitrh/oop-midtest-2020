package midtest;

import java.time.*;
import java.time.format.*;
import java.util.*;

class InitialDisplay {
    private Scanner sc = new Scanner(System.in);
    private Registration registration = new Registration();

    public void mainMenu() {
        // registrasi terlebih dahulu
        registration.registration();

        // setelah registrasi maka akan muncul tampilan menu
        while (true) {
            homeMenu();
            System.out.print("> ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("+------------ To-Do-List Hari ini ------------+\n");
                setTime();
                System.out.println("1. Hapus kegiatan");
                System.out.println("2. Edit kegiatan");
                System.out.println("3. Tambahkan kegiatan");
                System.out.println("4. Lihat Deskripsi kegiatan");
                System.out.print("> ");
                String choice_2 = sc.next();

                switch (choice_2) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    default:
                        break;
                }

            } else if (choice == 2) {
                System.out.println("+------------------ Biodata ------------------+");
                System.out.print(registration.getBiodata());
                System.out.println("+---------------------------------------------+");

            } else if (choice == 3) {
                break;
            }
        }
    }

    public void homeMenu() {
        System.out.println("\n+---------------- To-Do-List -----------------+");
        System.out.println("\n" + "Hello " + registration.getCallName() + " ^_^" + "\n");
        setTime();
        System.out.println("1. Lihat To-do-list Harian");
        System.out.println("2. Lihat Biodata");
        System.out.println("3. Exit");
    }

    public void setTime() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String s = LocalDate.now().getDayOfWeek().name();

        System.out.println("Today is : " + s.toLowerCase() + ", " + date.format(now) + ".");
        System.out.println("it's     : " + time.format(now) + "\n");
    }
}