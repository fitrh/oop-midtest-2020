package com.tugas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Todolist {

    //deklarasi variabel
    static String fileName;
    static ArrayList<String> todoLists;
    static boolean isEditing = false;
    static Scanner input;

    static void clearScreen(){

    }

    static void showMenu(){
        System.out.println("=== TODO LIST APP ===");
        System.out.println("[1] Lihat Todo List");
        System.out.println("[2] Tambah Todo List");
        System.out.println("[3] Edit Todo List");
        System.out.println("[4] Hapus Todo List");
        System.out.println("[0] Keluar");
        System.out.println("--------------------");
        System.out.print("Pilih menu > ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            showTodoList();
        } else if (selectedMenu.equals("2")) {
            addTodoList();
        } else if (selectedMenu.equals("3")) {
            editTodoList();
        } else if (selectedMenu.equals("4")) {
            deleteTodoList();
        } else if (selectedMenu.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("Kamu Salah Pilih Menu!");
            backToMenu();
        }
    }

    static void backToMenu(){
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali.. ");
        input.nextLine();
        System.out.println();
        clearScreen();
    }

    static void readTodoList(){
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            
            // load isi file ke dalam array todoLists
            todoLists.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                todoLists.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    static void showTodoList(){
        clearScreen();
        readTodoList();
        if (todoLists.size()>0) {
            System.out.println("TODO LIST:");
            int index = 0;
            for (String data : todoLists) {
                System.out.println(String.format("[%d] %s", index, data));
                index++;
            }
        } else {
            System.out.println("Tidak ada data!");
        }

        if (!isEditing) {
            backToMenu();
        }
    }

    static void addTodoList(){
        clearScreen();

        System.out.println("Apa yang ingin kamu kerjakan?");
        System.out.println("Beri tanda jika ini adalah Prioritas kamu");
        System.out.print("Jawab: ");
        String newTodoList = input.nextLine();

        try {
        // tulis file
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(String.format("%s%n", newTodoList));
            fileWriter.close();
            System.out.println("Berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }

        backToMenu();
        
    }

    static void editTodoList(){
        isEditing = true;
        showTodoList();

        try {
            System.out.println("--------------------");
            System.out.print("Pilih Indeks> ");
            int index = Integer.parseInt(input.nextLine());

            if (index > todoLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukkan data yang salah!");
            } else {
                System.out.println("Data Baru: ");
                String newData = input.nextLine();

                // update data
                todoLists.set(index, newData);

                System.out.println(todoLists.toString());

                try {
                    FileWriter fileWriter = new FileWriter(fileName, false);

                    // write new data
                    for (String data : todoLists) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();

                    System.out.println("Berhasil diubah!");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        isEditing = false;
        backToMenu();
    }

    static void deleteTodoList(){
        isEditing = true;
        showTodoList();

        System.out.println("---------------------");
        System.out.print("Pilih Indeks> ");
        int index = Integer.parseInt(input.nextLine());

        try {
            if (index > todoLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukkan data yang salah!");
            } else {

                System.out.println("Kamu akan menghapus:");
                System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                System.out.println("Apa kamu yakin?");
                System.out.println("Jawab (y/t): ");
                String jawab = input.nextLine();

                if (jawab.equalsIgnoreCase("y")) {
                    // hapus data
                    todoLists.remove(index);

                    // tulis ulang file

                    try {
                        FileWriter fileWriter = new FileWriter(fileName, false);
    
                        // write new data
                        for (String data : todoLists) {
                            fileWriter.append(String.format("%s%n", data));
                        }
                        fileWriter.close();
    
                        System.out.println("Berhasil dihapus!");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                    }
                } 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        isEditing = false;
        backToMenu();
    }
}