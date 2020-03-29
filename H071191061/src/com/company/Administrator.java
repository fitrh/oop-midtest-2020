package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Administrator extends Person {


    public void addPustakawan(String nama, String username, String password){
        HashMap<String, String> map = new HashMap<>();
        map.put("nama",String.format("'%s'",nama));
        map.put("username", String.format("'%s'",username));
        map.put("password",String.format("'%s'",password));
        map.put("role","2");

        Boolean isSuccess = DBHelper.insert(getTABEL(),map);

        if (isSuccess){
            System.out.println("Data Pustakawan Baru Telah Ditambahkan");
        }else {
            System.out.println("Data Pustakawan Baru gagal ditambah");
        }
    }

    public ArrayList<Person> getAllPustakawan(){
        ResultSet resultSet = DBHelper.selectAll(getTABEL(),"role = 2");
        ArrayList<Person> allpustakawan = new ArrayList<>();
        while (true) {
            try {
                if (resultSet.next()) {
                    Person pustakawan = new Person();
                    pustakawan.setNama(resultSet.getString("nama"));
                    pustakawan.setIdPerson(resultSet.getInt("id"));
                    pustakawan.setUsername(resultSet.getString("username"));
                    pustakawan.setPassword(resultSet.getString("password"));
                    pustakawan.setRole(resultSet.getInt("role"));
                    allpustakawan.add(pustakawan);
                } else {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allpustakawan;
    }

}
