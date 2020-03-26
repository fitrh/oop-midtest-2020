package midtest;

import java.util.Scanner;

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

            } else if (choice == 2) {
                System.out.print(registration.getBiodata());
            } else if (choice == 3) {
                break;
            }
        }
    }

    public void homeMenu() {
        System.out.println("\n+---------------- To Do List ----------------+");
        System.out.println("\nHello " + registration.getCallName() + " ^_^");
        System.out.println("\n1. Lihat To-do-list Harian");
        System.out.println("2. Lihat Biodata");
        System.out.println("3. Exit");
    }
}