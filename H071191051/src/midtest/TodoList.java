package midtest;

import java.io.*;

class TodoList {
    protected String callName;

    public TodoList() {

    }

    public TodoList(String callName) {
        this.callName = callName;
    }

    public void showList() throws IOException {
        System.out.println("+------------ To-Do-List Hari ini ------------+");
    }

    public void addList() throws IOException {
        System.out.println("+---------------- Adding List ----------------+");
    }

    public String getDescription() {
        return null;
    }

    public String getCallName() {
        return callName;
    }
}