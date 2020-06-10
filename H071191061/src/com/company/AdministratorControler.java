package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class AdministratorControler {
    private Scanner sc = new Scanner(System.in);
    private Person AdminLogedIn;
    AdministratorControler(Person person){
        AdminLogedIn = person;
    }
    void viewAdministrator(){

        loop : while (true){
            System.out.println("Selamat datang Di Wilayah Administrator "+AdminLogedIn.getNama());
            System.out.println("Lakukan Apa yang ingin anda lakukan\n" +
                    "1. Menambah Pustakawan Baru\n" +
                    "2. Tampilkan Data Pustakawan\n" +
                    "3. Tampilkan Data Buku\n" +
                    "4. Tampilkan Data Transaksi Buku\n" +
                    "5. Logout\n");
            System.out.print("Pilihan anda dalam angka :");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    viewTambahPustakawan();
                    break;
                case 2:
                    viewDataPustakawan();
                    break;
                case 3:
                    viewDataBuku();
                    break;
                case 4:
                    viewDataTransaksiAnggota();
                    break;
                case 5:
                    System.out.println("Anda Akan Kembali kehalaman Login. Seeyou");
                    break loop;
                default:
                    System.out.println("Nomer yang anda masukan Salah, Pilih Nomer 1-5");

            }
        }
    }

    private void viewDataTransaksiAnggota() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inputkan Nama Anggota :");
        String nama = sc.nextLine();
        TransaksiBuku transaksiBuku = new TransaksiBuku();
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        try {
            allTransaksi = transaksiBuku.getTransaksiByName(nama);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("NO | Judul Buku | Pengarang | Penerbit | Jumlah");
        int i = 1;
        for (TransaksiBuku transaksi :
                allTransaksi) {
            System.out.println(String.format("%s | %s | %s | %s | %s | %s"
                    ,i,transaksi.getPeminjam(),transaksi.getBuku(),transaksi.getTanggal_pinjam(),transaksi.getTanggal_kembali(),transaksi.getSts_pengembalian()));
            i++;
        }
    }

    private void viewDataBuku() {
        Buku buku = new Buku();
        ArrayList<Buku> allBuku = new ArrayList<>(buku.getallBuku());
        System.out.println("NO | Judul Buku | Pengarang | Penerbit | Jumlah");
        int i = 1;
        for (Buku someBuku :
                allBuku) {
            System.out.println(String.format("%s | %s | %s | %s | %s"
                    ,i,someBuku.getJudulBuku(),someBuku.getPengarang(),someBuku.getPenerbit(),someBuku.getKetersediaan()));
        }
    }

    private void viewDataPustakawan() {
        Administrator administrator = new Administrator();
        ArrayList<Person> allPerson = new ArrayList<>(administrator.getAllPustakawan());
        int i =1;
        System.out.println("No | Nama | Username | Password");
        for (Person person :
                allPerson) {
            System.out.println(String.format("%s | %s | %s | %s " +
                    "",i,person.getNama(),person.getUsername(),person.getPassword()));
            i++;
        }

    }

    private void viewTambahPustakawan() {
        Administrator administrator = new Administrator();
        System.out.println("Inputkan data Pustakawan baru");
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        administrator.addPustakawan(nama,username,password);
    }
}
