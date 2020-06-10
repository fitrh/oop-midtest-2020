import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean done = false;
    static BankPark nasabah;

    public static void main(String[] args) throws Exception {
        Bank nasabah = new BankPark();
        int amount;
        loginMenu();
        System.out.print("Username : ");
        String userName = sc.nextLine();
        System.out.print("Password : ");
        String password = sc.nextLine();

        nasabah.login(userName, password);
        if (nasabah.isUser()) {
            while (!done) {
                mainMenu();
                System.out.print("\nInput : ");
                userName = sc.next();
                switch (userName) {
                    case "1":
                        System.out.println("    MENU TRANSFER   ");
                        System.out.print("Masukkan no rekening tujuan anda : ");
                        String ok = sc.next();
                        password = sc.nextLine();
                        System.out.print("Masukkan jumlah nominal yang akan ditransfer : ");
                        amount = sc.nextInt();
                        nasabah.transfer(amount, ok);
                        backToMainMenu();
                        break;
                    case "2":
                        System.out.println("     MENU SETOR TUNAI  ");
                        System.out.print("Masukkan jumlah nominal yang akan disetor tunai : ");
                        amount = sc.nextInt();
                        nasabah.saving(amount);
                        backToMainMenu();
                        break;
                    case "3":
                        System.out.println("    MENU PENARIKAN TUNAI    ");
                        System.out.print("Masukkan jumlah nominal yang akan ditarik tunai : ");
                        amount = sc.nextInt();
                        nasabah.takeMoney(amount);
                        backToMainMenu();
                        break;
                    case "4":
                        nasabah.getActivityLog();
                        backToMainMenu();
                        break;
                    case "5":
                        nasabah.printDetails();
                        backToMainMenu();
                        break;
                    case "0":
                        done = true;
                        nasabah.saveData();
                        return;
                    default:
                        System.out.println("Silahkan pilih menu kembali");
                        mainMenu();
                        System.out.print("Input : ");
                        userName = sc.nextLine();
                        break;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == 3) {
                    System.out.println("Anda sudah melewati batas dari percobaan\nSilahkan coba lagi nanti");
                    return;
                }
                System.out.print("Username : ");
                userName = sc.nextLine();
                System.out.print("Password : ");
                password = sc.nextLine();
                nasabah.login(userName, password);
                if (nasabah.isUser()) {
                    while (!done) {
                        mainMenu();
                        System.out.print("\nInput : ");
                        userName = sc.next();
                        switch (userName) {
                            case "1":
                                System.out.println("    MENU TRANSFER   ");
                                System.out.print("Masukkan no rekening tujuan anda : ");
                                password = sc.next();
                                String accountNumber = sc.nextLine();
                                System.out.print("Masukkan jumlah nominal yang akan ditransfer : ");
                                amount = sc.nextInt();
                                nasabah.transfer(amount, accountNumber);
                                backToMainMenu();
                                break;
                            case "2":
                                System.out.println("     MENU SETOR TUNAI  ");
                                System.out.print("Masukkan jumlah nominal yang akan disetor tunai : ");
                                amount = sc.nextInt();
                                nasabah.saving(amount);
                                backToMainMenu();
                                break;
                            case "3":
                                System.out.println("    MENU PENARIKAN TUNAI    ");
                                System.out.print("Masukkan jumlah nominal yang akan ditarik tunai : ");
                                amount = sc.nextInt();
                                backToMainMenu();
                                break;
                            case "4":
                                nasabah.getActivityLog();
                                backToMainMenu();
                                break;
                            case "5":
                                nasabah.printDetails();
                                backToMainMenu();
                                break;
                            case "0":
                                done = true;
                                nasabah.saveData();
                                return;
                            default:
                                System.out.println("Silahkan pilih menu kembali");
                                mainMenu();
                                System.out.print("Input : ");
                                userName = sc.next();
                                break;
                        }
                    }
                }

            }
        }
    }

    public static void loginMenu() {
        System.out.println("    SEALAMAT DATANG DI BANK PARK SEO JOON   ");
        System.out.println("---------------------------------------------");
        System.out.println("   -Masukkan Username dan Password anda-  ");
    }

    public static void mainMenu() {
        System.out.println("     PILIH TRANSAKSI YANG ANDA INGINKAN    ");
        System.out.println("        TEKAN EXIT UNTUK PEMBATALAN  ");
        System.out.println("1.Transfer");
        System.out.println("2.Setor Tunai");
        System.out.println("3.Penarikan Tunai");
        System.out.println("4.Log Aktivitas");
        System.out.println("5.Informasi Detail");
        System.out.println("0.Exit");
    }

    public static void backToMainMenu() {
        System.out.println("Lanjutkan ? (y/t)");
        String stopOrContinue = sc.next();
        switch (stopOrContinue) {
            case "y":
                done = false;
                break;
            case "t":
                done = true;
                break;
            default:
                stopOrContinue = sc.next();
                break;
        }
    }
}
