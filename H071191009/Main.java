package com.tugas;
import java.util.ArrayList;
import java.util.Scanner;
class Main extends Todolist {
    public static void main(String[] args) {
        todoLists = new ArrayList<>();
        input = new Scanner(System.in);

        String filePath = System.console() == null ? "/src/todolist.txt" : "/todolist.txt";
        fileName = System.getProperty("user.dir") + filePath;

        System.out.println("FILE: " + fileName);

        //run the program (main loop)
        while (true) {
            showMenu();
        }
    }

}