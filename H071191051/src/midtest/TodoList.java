package midtest;

import java.io.*;

class TodoList {
    private String callName;

    public TodoList() {

    }

    public TodoList(String callName) {
        this.callName = callName;
    }

    public void showList() throws IOException {
        System.out.println("+-------------- To-Do-List Today -------------+");
    }

    public void addList() throws IOException {
        System.out.println("+---------------- Adding List ----------------+");
    }

    public void deleteList() throws IOException {
        System.out.println("+---------------- Delete List ----------------+");
    }

    public void editList() throws IOException {
        System.out.println("+----------------- Edit List -----------------+");
    }

    public void deleteAndRename() throws IOException {
        File file = new File("kegiatan.txt");
        File file_2 = new File("temp.txt");
        file.delete();
        file_2.renameTo(file);
    }

    public String getDescription() {
        return null;
    }

    public String getCallName() {
        return callName;
    }
}