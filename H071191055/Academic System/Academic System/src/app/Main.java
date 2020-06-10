package app;

import java.io.IOException;
import java.util.*;

/**
 * Main
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static int choose;

    public static void main(String[] args) throws IOException {
        Login login = Login.getInstance();
        login.LoginAction();
    }
}