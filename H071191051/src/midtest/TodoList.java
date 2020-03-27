package midtest;

import java.io.*;

class TodoList {
    protected String callName;
    protected String activityName;
    protected String activitySchedule;
    protected String activityPriority;
    protected String activityStatus;
    protected String activityDescription;

    public TodoList() {

    }

    public TodoList(String callName) {
        this.callName = callName;
    }

    public void showList() throws IOException {
        System.out.println("+------------ To-Do-List Hari ini ------------+");
    }

    public void addList() throws IOException {

    }

    public String getDescription() {
        return null;
    }

    public String getCallName() {
        return callName;
    }
}