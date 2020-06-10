import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<User> listUser = new ArrayList<User>();

        User user = new User2("", "");
        User user2 = new User3("", "");

        while (true) {
            System.out.println("=== WELCOME TO TO-DO-LIST APP ===");
            System.out.println("=== 1. Log In                 ===");
            System.out.println("=== 0. Close APP              ===");
            System.out.println("=================================");
            System.out.print("=> ");
            int select = sc.nextInt();
                
                switch (select) {
                    case 1:
                        System.out.println("LOGIN!");
                        System.out.print("Masukkan Username: ");
                        String inUsername = sc.next();
                        System.out.print("Masukkan Password: ");
                        String inPass = sc.next();
                        System.out.println();
                
                        //cek username dan password
                        if (inUsername.equals(user.getUsername()) && inPass.equals(user.getPassword()) ) {
                            System.out.println("***LOGIN AKUN1 SUKSES***");
                            System.out.println();
                            while (true) {
                                showMenu1();
                            }
                        } else if (inUsername.equals(user2.getUsername()) && inPass.equals(user2.getPassword())) {
                            System.out.println("***LOGIN AKUN2 SUKSES***");
                            System.out.println();
                            while (true) {
                                showMenu2();
                            }   
                        } else {
                            System.out.println("***LOGIN GAGAL***");
                            System.out.println();
                        }
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Kamu Salah Memilih Menu!");
                        break;
                    }
        }
        
    }
    
    public static void showMenu1(){
        Scanner sc = new Scanner(System.in);
        User user = new User2("admin","1234");

        System.out.println("+-------------------------------+");
        System.out.println("| 1. Lihat To Do List           |");
        System.out.println("| 2. Tambah To Do List          |");
        System.out.println("| 3. Hapus To Do List           |");
        System.out.println("| 0. Keluar Akun                |");
        System.out.println("+-------------------------------+");
        System.out.print("** Pilih Menu> ");
        int menu = sc.nextInt();
        System.out.println();

            switch (menu) {
                case 1:
                    user.showTodoList();
                    break;
                case 2:
                    user.addTodoList();
                    break;
                case 3:
                    user.deleteTodoList();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Kamu Salah Pilih Menu!");
            }
        }

    public static void showMenu2(){
        Scanner sc = new Scanner(System.in);
        User user2 = new User3("admin2","abcd");

        System.out.println("+-------------------------------+");
        System.out.println("| 1. Lihat To Do List           |");
        System.out.println("| 2. Tambah To Do List          |");
        System.out.println("| 3. Hapus To Do List           |");
        System.out.println("| 0. Keluar Akun                |");
        System.out.println("+-------------------------------+");
        System.out.print("** Pilih Menu> ");
        String menu = sc.next();
        System.out.println();

        switch (menu) {
            case "1" :
                user2.showTodoList();
                break;
            case "2" :
                user2.addTodoList();
                break;
            case "3" :
                user2.deleteTodoList();
                break;
            case "0" :
                System.exit(1);
                break;
            default:
                System.out.println("Kamu Salah Pilih Menu!");
        }
    }



}
