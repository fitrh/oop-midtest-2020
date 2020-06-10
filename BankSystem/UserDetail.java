import java.util.ArrayList;

class UserDetail {
    private String name;
    private int age;
    private String address;
    private String email;
    private String accountNumber;
    private int moneyAmount;
    private String password;
    private ArrayList<String> activityLog = new ArrayList<>();
    int i = 0;

    protected UserDetail(String name, String password, int age, int moneyAmount, String email, String accountNumber,
            String address) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.address = address;
        this.email = email;
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
    }

    protected UserDetail() {

    }

    protected void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void saving(int amount) {
        moneyAmount += amount;
        activityLog.add(++i + ". Menambah saldo sebanyak : " + amount + "\n");
    }

    protected void takeMoney(int amount) {
        if (moneyAmount >= amount) {
            moneyAmount -= amount;
            activityLog.add(++i + ". Menarik saldo sebanyak : " + amount + "\n");
        } else {
            System.out.println("Maaf saldo anda tidak cukup");
        }
    }

    protected void transfer(int amount, String accountNumber, String name) {
        if (moneyAmount >= amount) {
            moneyAmount -= amount;
            activityLog.add(++i + ". Transfer ke rekening " + accountNumber + "(" + name + ")" + " Sebanyak : " + amount
                    + "\n");
        } else {
            System.out.println("Maaf saldo anda tidak mencukupi");
        }
    }

    protected void savingFromTransfer(int amount) {
        moneyAmount += amount;
    }

    protected String getName() {
        return name;
    }

    protected String getPassword() {
        return password;
    }

    protected int getAge() {
        return age;
    }

    protected String getAccountNumber() {
        return accountNumber;
    }

    protected String getAddress() {
        return address;
    }

    protected String getEmail() {
        return email;
    }

    protected int getMoneyAmount() {
        return moneyAmount;
    }

    protected ArrayList<String> getActivityLog() {
        return activityLog;
    }
}