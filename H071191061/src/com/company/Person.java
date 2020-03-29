package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {


    private static final String TABEL = "person";
    private int IdPerson;
    private String nama;
    private String username;
    private String password;
    protected int role;

    public static String getTABEL() {
        return TABEL;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int idPerson) {
        IdPerson = idPerson;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static Person loginUser(String username, String password) throws SQLException {
        username.replace("'","").replace(" ","");
        password.replace("'","").replace(" ","");
        ResultSet resultSet = DBHelper.selectAll(TABEL,String.format("username = '%s' and password = '%s'",username,password));
        if (!resultSet.next()){
            return null;
        }else{
            Person person = new Person();
            person.setIdPerson(resultSet.getInt("id"));
            person.setNama(resultSet.getString("nama"));
            person.setUsername(resultSet.getString("username"));
            person.setPassword(resultSet.getString("password"));
            person.setRole(resultSet.getInt("role"));
            return person;
        }
    }

    public void printData(){
        System.out.println("Nama : "+getNama());
        System.out.println("Username : "+getUsername());
        System.out.println("Password : "+getPassword());
    }

    public String getNamaById(int idPerson) throws SQLException {
        String nama = "";
        String query = "id = "+idPerson;
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()) nama = resultSet.getString("nama");
        return nama;
    }

    public int getIdByNama(String nama) throws SQLException {
        int id = 0;
        String query = "nama = '"+nama+"'";
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()) id = resultSet.getInt("id");
        return id;
    }
}
