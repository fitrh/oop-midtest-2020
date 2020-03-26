package app;

/**
 * User
 */
public class User {

    String userName;
    int id;
    String password;
    private boolean checkPass = false;

    public User(int id, String userName, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean verifyPassword(String password) {
        if (this.password.equals(password)) {
            return checkPass = true;
        }
        return checkPass;
    }

    // public void getDetail(DataSource dataSource) {

    // }
}