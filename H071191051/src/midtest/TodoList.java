package midtest;

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

    public void deleteAndRename() {
        File file = new File("kegiatan.txt");
        File file_2 = new File("temp.txt");
        file.delete();
        file_2.renameTo(file);
    }

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

    public void closeIO(FileReader fileInput, BufferedReader bufferInput) throws IOException {
        fileInput.close();
        bufferInput.close();
    }

    public void closeIO(FileWriter fileOutput, BufferedWriter bufferOutput) throws IOException {
        fileOutput.close();
        bufferOutput.close();
    }

    public void closeIO(FileReader fileInput, FileWriter fileOutput, BufferedReader bufferInput,
            BufferedWriter bufferOutput) throws IOException {
        fileInput.close();
        fileOutput.close();
        bufferInput.close();
        bufferOutput.close();
    }

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