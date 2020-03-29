package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PustakaControler {
    Scanner sc = new Scanner(System.in);
    private Person pustakawan = new Person();

    public PustakaControler(Person pustakawan) {
        this.pustakawan = pustakawan;
    }

    public void viewPustakawan() throws SQLException {
        System.out.println("Selamat Datang " + pustakawan.getNama());
        loop:
        while (true) {
            System.out.println("Silahkan Pilih Menu");
            System.out.println("\n" +
                    "1. Lihat semua Data Buku\n" +
                    "2. Lihat Semua Record Peminjaman\n" +
                    "3. Lihat Record Peminjaman Anggota\n" +
                    "4. Tambah Buku\n" +
                    "5. Edit Buku\n" +
                    "6. Hapus Buku\n" +
                    "7. Peminjaman\n" +
                    "8. Pegembalian\n" +
                    "9. Tambah Anggota\n"+
                    "10. Exit");
            System.out.print("Pilihan :");
            int pilihan = sc.nextInt();
            switch (pilihan){
                case 1:
                    viewDataBuku();
                    break ;
                case 2:
                    viewDataTransaksi();
                    break;
                case 3:
                    viewDataTransaksiAnggota();
                    break ;
                case 4:
                    viewTambahBuku();
                    break ;
                case 5:
                    viewEditBuku();
                    break ;
                case 6:
                    viewHapusBuku();
                    break ;
                case 7:
                    viewPeminjaman();
                    break ;
                case 8:
                    viewPengembalian();
                    break ;
                case 9:
                    viewTambahAnggota();
                    break;
                case 10:
                    break loop;
            }
        }
    }

    private void viewTambahAnggota() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Masukan Data Anggota Baru");
        System.out.println("Nama        : ");
        String nama = scn.nextLine();
        System.out.println("Username    : ");
        String username = scn.nextLine();
        System.out.println("Password    : ");
        String password = scn.nextLine();

        Pustakawan pustakawan = new Pustakawan();
        pustakawan.addAnggota(username,nama,password);
    }

    private void viewPengembalian() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        int jumlahPinjaman = 0;
        System.out.print("Masukan Id Anggota : ");
        int idAnggota = sc.nextInt();
        String colum[] = {"COUNT(sts_pengembalian) AS total"};
        String constrain = "WHERE peminjam = "+idAnggota+" and sts_pengembalian = 'Belum Kembali' GROUP BY peminjam";
        ResultSet resultSet = DBHelper.selectColumn("transaksi_buku",colum,constrain);
        while (resultSet.next()){
            jumlahPinjaman = resultSet.getInt("total");
        }
        for (int i = 0; i < jumlahPinjaman; i++) {
            System.out.print("Masukan ID Buku yang dipinjam :");
            int idBuku = sc.nextInt();
            Buku buku = new Buku();
            buku = buku.getBukuById(idBuku);
            buku.editBuku(idBuku,buku.getJudulBuku(),buku.getPengarang(),buku.getPenerbit(),buku.getKetersediaan()+1);
            TransaksiBuku transaksiBuku = new TransaksiBuku();
            transaksiBuku.updateTransaksi(idAnggota,idBuku);
        }

    }

    private void viewPeminjaman() {
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        TransaksiBuku transaksiBuku = new TransaksiBuku();
        System.out.print("Masukan Jumlah Buku yang dipinjam(Maksimal 3) : ");
        ArrayList<Buku> bukus = new ArrayList<>();
        int jumlah = sc.nextInt();
        System.out.printf("Masukan Id Anggota : ");
        int idAnggota = sc.nextInt();
        try {
            if(cekAnggota(idAnggota)){
                Buku buku = new Buku();
                Person person = new Person();
                for (int i = 0; i < jumlah; i++) {
                    System.out.print("Masukan id Buku yang dipinjam : ");
                    int idBuku = sc.nextInt();
                    try {
                        bukus.add(buku.getBukuById(idBuku));
                        transaksiBuku.addTransaksi(idBuku,idAnggota);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.print("Nama : "+person.getNamaById(idAnggota));
                    System.out.printf("Telah Meminjam Buku sebanyak "+jumlah+" Yaitu dengan rincian berikut :");
                    int i = 1;
                    for (Buku buk :
                            bukus) {
                        System.out.println(String.format("%s. %s | %s | %s",i,buk.getJudulBuku(),buk.getPengarang(),buk.getPenerbit()));
                        i++;
                        buku.editBuku(buk.getIdBuku(),buk.getJudulBuku(),buk.getPengarang(),buk.getPenerbit(),buk.getKetersediaan() - 1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Masih Memiliki Tanggungan Buku yang belum dikembalikan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean cekAnggota(int idAnggota) throws SQLException {
        String[] column = new String[1];
        String status = "";
        column[0] = "sts_pengembalian";
        String clause = String.format("id = %s ORDER BY tangga_pinjam DESC LIMIT 1 ",idAnggota);
        ResultSet resultSet = DBHelper.selectColumn("transaksi_buku",column,clause);
        if (resultSet.next()){
            status = resultSet.getString("sts_pengembalian");
        }
        System.out.println(status);
        if (status.equals("Belum Kembali")) {
            return false;
        }else {
            return true;
        }
    }

    private void viewEditBuku() {
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        System.out.print("Masukan Id Buku yang Ingin di Edit : ");
        int id = sc.nextInt();
        System.out.print("Judul Buku : ");
        String judul = scn.nextLine();
        System.out.print("Pengarang : ");
        String pengarang = scn.nextLine();
        System.out.print("Penerbit : ");
        String penerbit = scn.nextLine();
        System.out.print("Jumlah : ");
        int jumlah = sc.nextInt();
        Buku buku = new Buku();
        buku.editBuku(id,judul,pengarang,penerbit,jumlah);
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

    private void viewDataTransaksi() throws SQLException {
        TransaksiBuku transaksiBuku = new TransaksiBuku();
        ArrayList<TransaksiBuku> allTransaksi = transaksiBuku.getAllTransaksi();
        System.out.println("NO | Judul Buku | Pengarang | Penerbit | Jumlah");
        int i = 1;
        for (TransaksiBuku transaksi :
                allTransaksi) {
            System.out.println(String.format("%s | %s | %s | %s | %s | %s"
                    ,i,transaksi.getPeminjam(),transaksi.getBuku(),transaksi.getTanggal_pinjam(),transaksi.getTanggal_kembali(),transaksi.getSts_pengembalian()));
            i++;
        }
    }

    private void viewHapusBuku() {
        Scanner scn = new Scanner(System.in);
        int id;
        System.out.println("Masukan ID buku yang ingin dihapus!");
        try {
            System.out.print("ID Buku : ");
            id = scn.nextInt();
            Buku buku = new Buku();
            buku.deleteBuku(id);
        }catch (Exception e){
            System.out.println("Inputan Anda Tidak Valid");
        }

    }

    private void viewTambahBuku() {
        Scanner scn = new Scanner(System.in);
        try{
            System.out.println("Inputkan Data Buku");
            System.out.println("Judul Buku :");
            String judul = scn.nextLine();
            System.out.println("Pengarang : ");
            String pengarang = scn.nextLine();
            System.out.println("Penerbit : ");
            String penerbit = scn.nextLine();
            System.out.println("Jumlah Buku : ");
            int jumlah = scn.nextInt();
            Buku buku = new Buku();
            buku.addBuku(judul,pengarang,penerbit,jumlah);
        }catch (Exception e){
            System.out.println("Inputan Anda Tidak Valid");
        }

    }

    private void viewDataBuku(){
        Buku buku = new Buku();
        ArrayList<Buku> allBuku = new ArrayList<>(buku.getallBuku());
        System.out.println("NO | Judul Buku | Pengarang | Penerbit | Jumlah");
        int i = 1;
        for (Buku someBuku :
                allBuku) {
            System.out.println(String.format("%s | %s | %s | %s | %s"
                    ,i,someBuku.getJudulBuku(),someBuku.getPengarang(),someBuku.getPenerbit(),someBuku.getKetersediaan()));
            i++;
        }
    }
}
