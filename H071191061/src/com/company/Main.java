package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        LoginFirst login = new LoginFirst();
        try {
            login.loginUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
