import java.io.*;
import java.util.*;
import java.nio.file.*;

class TodoList {
    private String callName;
    private Scanner sc = new Scanner(System.in);

    public TodoList() {

    }

    public TodoList(String callName) {
        this.callName = callName;
    }

    // method yang nantinya akan di override pada delivered class
    public void showList() throws IOException {
        System.out.println("+-------------- To-Do-List Today -------------+\n");
    }

    public void addList() throws IOException {
        System.out.println("+---------------- Adding List ----------------+\n");
    }

    public void deleteList() throws IOException {
        System.out.println("+---------------- Delete List ----------------+\n");
    }

    public void editList() throws IOException {
        System.out.println("+----------------- Edit List -----------------+\n");
    }

    public void descList() throws IOException {
        System.out.println("+------------ Description List ---------------+\n");
    }

    // berfungsi untuk rename dan delete file
    public void deleteAndRename() {
        File file = new File("kegiatan.txt");
        File file_2 = new File("temp.txt");
        file.delete();
        file_2.renameTo(file);
    }

    // berfungsi untuk close file IO dan buffer IO
    public void closeIO(FileWriter fileOutput, BufferedWriter bufferOutput) throws IOException {
        bufferOutput.close();
        fileOutput.close();
    }

    public void closeIO(FileReader fileInput, BufferedReader bufferInput) throws IOException {
        bufferInput.close();
        fileInput.close();
    }

    public void closeIO(FileReader fileInput, BufferedReader bufferInput, FileWriter fileOutput,
            BufferedWriter bufferOutput) throws IOException {
        bufferInput.close();
        bufferOutput.close();
        fileInput.close();
        fileOutput.close();
    }

    // untuk mengeluarkan opsi (y/n) pada beberapa class
    public boolean getYerOrNo(String message) {
        System.out.println("\n" + message + "\n");
        System.out.print("> ");
        String choice = sc.next();
        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    // mengecek apakah inputan user ada/sesuai dengan line yang ada pada file.txt
    public boolean checkLineisExist(int choice, BufferedReader bufferInput, BufferedWriter bufferOutput, String data)
            throws IOException {
        if (choice > checkTotalLineatFile() || choice < 1) {
            while (data != null) {
                bufferOutput.write(data);
                bufferOutput.newLine();
                data = bufferInput.readLine();
            }
            bufferOutput.flush();
            return false;
        } else {
            return true;
        }
    }

    // mengecek total baris yang terisi pada file.txt
    public long checkTotalLineatFile() throws IOException {
        Path path = Paths.get("kegiatan.txt");
        return Files.lines(path).count();
    }

    public String getDescription() {
        return null;
    }

    public String getCallName() {
        return callName;
    }
}