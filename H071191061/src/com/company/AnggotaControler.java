package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class AnggotaControler {
    private Person anggota;
    private Scanner sc = new Scanner(System.in);
    AnggotaControler(Person anggota){
        this.anggota = anggota;
    }

    void viewAnggota(){
        System.out.println("Selamat Datang "+anggota.getNama());
        loop : while (true){
            System.out.println("Silahkan Pilih Menu");
            System.out.println("1. Lihat semua Data Buku\n" +
                    "2. Cari Buku Berdasarkan Judul\n" +
                    "3. Cari Berdasarkan Penerbit\n" +
                    "4. Cari Berdasarkan Penulis\n" +
                    "5. Data Diri\n"+
                    "5. Logout");
            System.out.print("Pilihan :");
            int pilihan = sc.nextInt();
            switch (pilihan){
                case 1 :
                    viewDataBuku();
                    break ;
                case 2:
                    viewSearchBerdasarkan(1);
                    break ;
                case 3:
                    viewSearchBerdasarkan(2);
                case 4:
                    viewSearchBerdasarkan(3);
                case 5:
                    anggota.printData();
                case 6:
                    break loop;
                default:
                    System.out.println("Angka yang anda pilih tidak sesuai, silahkan pilih antara 1-5 sesuai Menu");
            }

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
        }
    }

    private void viewSearchBerdasarkan(int key){
        Scanner scn = new Scanner(System.in);
        Buku buku = new Buku();
        System.out.print("Masukan Judul Buku : ");
        String keyword = scn.nextLine();
        ArrayList<Buku> hasil = new ArrayList<>();
        if (key==1){
            try {
                hasil.addAll(buku.getBukuByJudul(keyword));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (key==2){
            try {
                hasil.addAll(buku.getBukuByPenerbit(keyword));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                hasil.addAll(buku.getBukuByPengarang(keyword));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (hasil.isEmpty()){
            System.out.println("Buku Masih Belum Tersedia");
        }else {
            int i = 1;
            for (Buku someBuku :
                    hasil) {
                System.out.println(String.format("%s | %s | %s | %s | %s"
                        ,i,someBuku.getJudulBuku(),someBuku.getPengarang(),someBuku.getPenerbit(),someBuku.getKetersediaan()));
                i++;
            }
        }

    }
}
