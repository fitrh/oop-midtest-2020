package com.ItemStoreProject;

public class Login {
    private Akun akun;
    private DataSource dataSource = DataSource.getInstance();
    private static Login loginInstance;
    private Login() {}
    public static Login getInstance() {
        if (loginInstance == null) {
            loginInstance = new Login();
        }
        return loginInstance;
    }
    public boolean check (String username, String password){
        if(dataSource.getAkun(username)==null){
            return false;
        }
        akun = dataSource.getAkun(username);
        if(akun.authPassword(password)==true) {
            return true;
        }
        return false;

    }
}
