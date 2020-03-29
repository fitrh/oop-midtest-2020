import java.io.*;
import java.util.*;

public class User {
    
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    
    public void addTodoList(){}
    public void deleteTodoList(){};
    public void showTodoList(){};
    
}

class User2 extends User {

    private Scanner sc;
    private List<Todolist> todoList;

    public User2(){}

    public User2(String username, String password){
        super("admin", "1234");
        todoList = new ArrayList<>();
    }

    @Override
    public void addTodoList() {
        sc = new Scanner(System.in);
        System.out.print("Tambah Kegiatan: ");
        String addTodo = sc.nextLine();
        System.out.print("Deskripsi Kegiatan: ");
        String desc = sc.nextLine();
        System.out.print("Jadwal Mulai: ");
        String start = sc.nextLine();
        System.out.print("Jadwal Selesai: ");
        String finish = sc.nextLine();
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Skala Prioritas(1-5): ");
        String prio = sc.nextLine();

        // Inputan dimasukkan dalam sebuah file
        try {
            FileWriter fileWrit = new FileWriter("User.txt", true);
            fileWrit.write(String.format("%s;%s;%s;%s;%s;%s%n", addTodo, desc, start, finish, status,prio));
            fileWrit.close();
            System.out.println("BERHASIL DITAMBAHKAN");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Tidak Ada Data!");
        }
    }

    @Override
    public void deleteTodoList(){
        showTodoList();
        
        sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.print("Pilih Indeks> ");
        int index = sc.nextInt();
        
        try {
            if (index > todoList.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukkan data yang salah!"); 
            } else {
                System.out.println("Kamu akan menghapus:");
                System.out.print(index + ". ");
                todoList.get(index).showTodoLists();

                System.out.println("Apa kamu yakin?");
                System.out.println("Jawab (y/t): ");
                String jawab = sc.next();

                if (jawab.equalsIgnoreCase("y")) {
                    // hapus data
                    todoList.remove(index);
                    String isi = "";
                    // setelah dihapus maka ditulis ulang kedalam file
                    try {
                        FileWriter fileWrit = new FileWriter("User.txt", false);
                        for (int i = 0; i < todoList.size(); i++) {
                            String nama = todoList.get(i).getName();
                            String desc = todoList.get(i).getDesc();
                            String start = todoList.get(i).getStart();
                            String finish = todoList.get(i).getFinish();
                            String status = todoList.get(i).getStatus();
                            String prio = todoList.get(i).getPriority();
                            fileWrit.write(String.format("%s;%s;%s;%s;%s;%s%n", nama, desc, start, finish, status, prio));
                        }

                        fileWrit.close();
                        System.out.println("Berhasil Dihapus!");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void readTodoList(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("User.txt"));

            while ((line=br.readLine()) != null) {
                String []daftar = line.split(";");
                // isi file akan dimasukkan kedalam arraylist
                todoList.add(new Todolist(daftar[0], daftar[1], daftar[2], daftar[3], daftar[4], daftar[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void showTodoList(){
        readTodoList();

        if (todoList.size()>0) {
            System.out.println("TODO LIST: ");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.print(i+". ");
                todoList.get(i).showTodoLists();
            }
        } else {
            System.out.println("Tidak Ada Data!");
        }
    }

}

class User3 extends User{

    private Scanner sc;
    private List<Todolist> todoList;

    public User3(){}

    public User3(String username, String password){
        super("admin2", "abcd");
        todoList = new ArrayList<>();
    }

    @Override
    public void addTodoList(){
        sc = new Scanner(System.in);
        System.out.print("Tambah Kegiatan: ");
        String addTodo = sc.nextLine();
        System.out.print("Deskripsi Kegiatan: ");
        String desc = sc.nextLine();
        System.out.print("Jadwal Mulai: ");
        String start = sc.nextLine();
        System.out.print("Jadwal Selesai: ");
        String finish = sc.nextLine();
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Skala Prioritas(1-5): ");
        String prio = sc.nextLine();

        // Inputan dimasukkan dalam sebuah file
        try {
            FileWriter fileWrit = new FileWriter("User2.txt", true);
            fileWrit.write(String.format("%s;%s;%s;%s;%s;%s%n", addTodo, desc, start, finish, status,prio));
            fileWrit.close();
            System.out.println("BERHASIL DITAMBAHKAN");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Tidak Ada Data!");
        }
    }

    @Override
    public void deleteTodoList(){
        showTodoList();
        
        sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.print("Pilih Indeks> ");
        int index = sc.nextInt();
        
        try {
            if (index > todoList.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukkan data yang salah!"); 
            } else {
                System.out.println("Kamu akan menghapus:");
                System.out.print(index + ". ");
                todoList.get(index).showTodoLists();

                System.out.println("Apa kamu yakin?");
                System.out.println("Jawab (y/t): ");
                String jawab = sc.next();

                if (jawab.equalsIgnoreCase("y")) {
                    // hapus data
                    todoList.remove(index);
                    String isi = "";
                    // setelah dihapus maka ditulis ulang kedalam file
                    try {
                        FileWriter fileWrit = new FileWriter("User2.txt", false);
                        for (int i = 0; i < todoList.size(); i++) {
                            String nama = todoList.get(i).getName();
                            String desc = todoList.get(i).getDesc();
                            String start = todoList.get(i).getStart();
                            String finish = todoList.get(i).getFinish();
                            String status = todoList.get(i).getStatus();
                            String prio = todoList.get(i).getPriority();
                            fileWrit.write(String.format("%s;%s;%s;%s;%s;%s%n", nama, desc, start, finish, status, prio));
                        }

                        fileWrit.close();
                        System.out.println("Berhasil Dihapus!");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void readTodoList(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("User2.txt"));

            while ((line=br.readLine()) != null) {
                String []daftar = line.split(";");
                // isi file akan dimasukkan kedalam arraylist
                todoList.add(new Todolist(daftar[0], daftar[1], daftar[2], daftar[3], daftar[4], daftar[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void showTodoList(){
        readTodoList();

        if (todoList.size()>0) {
            System.out.println("TODO LIST: ");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.print(i+". ");
                todoList.get(i).showTodoLists();
            }
        } else {
            System.out.println("Tidak Ada Data!");
        }
    }

}



