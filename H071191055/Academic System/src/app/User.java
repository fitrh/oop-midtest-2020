package app;

/**
 * User
 */
public class User {

    String userName;
    int id;
    String password;
    private boolean check = false;

    public User(int id, String userName, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean verifyPassword(String password) {
        if (this.password.equals(password)) {
            return check = true;
        }
        return check;
    }

    public boolean verifyUsername(String userName) {
        if (this.userName.equals(userName)) {
            return check = true;
        }
        return check;
    }

    // public void getDetail(DataSource dataSource) {

    // }
}