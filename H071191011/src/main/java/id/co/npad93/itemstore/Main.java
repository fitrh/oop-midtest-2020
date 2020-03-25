package id.co.npad93.itemstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main 
{
    public static void main(String[] args) throws Exception
    {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:itemstore.db.sqlite3");
        System.out.println("Boo!");
    }
}
