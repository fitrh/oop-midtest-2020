package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginFirst {
    private Person personLogin;

    public void loginUser() throws SQLException {
        System.out.println("SELAMAT DATANG DI PERPUSTAKAAN ILKOM" +
                "SILAHKAN LOGIN TERLEBIH DAHULU");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Username : ");
            String username = sc.nextLine();
            System.out.print("Password : ");
            String password = sc.nextLine();
            try {
                personLogin = Person.loginUser(username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(personLogin == null){
                System.out.println("Akun Tidak Ditemukan Login Ulang");
            }else{
                switch (personLogin.getRole()){
                    case 1:
                        AdministratorControler administratorControler = new AdministratorControler(personLogin);
                        administratorControler.viewAdministrator();
                        break;
                    case 2:
                        PustakaControler pustakaControler = new PustakaControler(personLogin);
                        pustakaControler.viewPustakawan();
                        break;
                    case 3:
                        AnggotaControler anggotaControler = new AnggotaControler(personLogin);
                        anggotaControler.viewAnggota();
                        break;
                }
            }
        }
    }
}
