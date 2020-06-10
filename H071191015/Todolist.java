public class Todolist {

    private String eventName;
    private String desc;
    private String startSchedule;
    private String finishSchedule;
    private String status;
    private String priority;

    public Todolist(String name, String descr, String start, String finish, String stat, String prio){
        eventName = name;
        desc = descr;
        startSchedule = start;
        finishSchedule = finish;
        status = stat;
        priority = prio;
    }

    public String getName(){
        return eventName;
    }

    public String getDesc(){
        return desc;
    }

    public String getStart(){
        return startSchedule;
    }

    public String getFinish(){
        return finishSchedule;
    }

    public String getStatus(){
        return status;
    }

    public String getPriority(){
        return priority;
    }

    public void showTodoLists(){
        System.out.println("Kegiatan           : " + getName());
        System.out.println("Deskripsi           : " + getDesc());
        System.out.println("Jadwal Mulai        : " + getStart());
        System.out.println("Jadwal Selesai      : " + getFinish());
        System.out.println("Status              : " + getStatus());
        System.out.println("Skala Prioritas(1-5): " + getPriority());
        System.out.println();
    }

}