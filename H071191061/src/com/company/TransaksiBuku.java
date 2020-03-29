package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TransaksiBuku {
    private static final String TABEL = "transaksi_buku";
    private int id;
    private String peminjam;
    private String buku;
    private java.sql.Date tanggal_pinjam;
    private java.sql.Date tanggal_kembali;
    private String sts_pengembalian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getBuku() {
        return buku;
    }

    public void setBuku(String buku) {
        this.buku = buku;
    }

    public java.sql.Date getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(java.sql.Date tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public java.sql.Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(java.sql.Date tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public String getSts_pengembalian() {
        return sts_pengembalian;
    }

    public void setSts_pengembalian(String sts_pengembalian) {
        this.sts_pengembalian = sts_pengembalian;
    }

    public ArrayList<TransaksiBuku> getAllTransaksi() throws SQLException {
        ResultSet resultSet = DBHelper.selectAll(TABEL);
        Buku buku = new Buku();
        Person person = new Person();
        TransaksiBuku transaksiBuku;
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        while (resultSet.next()){
            transaksiBuku = new TransaksiBuku();
            transaksiBuku.setId(resultSet.getInt("id"));
            transaksiBuku.setPeminjam(person.getNamaById(resultSet.getInt("peminjam")));
            transaksiBuku.setBuku(buku.getJudulBukuById(resultSet.getInt("buku")));
            transaksiBuku.setTanggal_pinjam(resultSet.getDate("tangga_pinjam"));
            transaksiBuku.setTanggal_kembali(resultSet.getDate("tangga_kembali"));
            transaksiBuku.setSts_pengembalian(resultSet.getString("sts_pengembalian"));
            allTransaksi.add(transaksiBuku);
        }
        return allTransaksi;
    }

    public ArrayList<TransaksiBuku> getTransaksiByName(String nama) throws SQLException {
        Buku buku = new Buku();
        Person person = new Person();
        String clause = "peminjam = "+person.getIdByNama(nama);
        ResultSet resultSet = DBHelper.selectAll(TABEL,clause);
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        TransaksiBuku transaksiBuku;
        while (resultSet.next()){
            transaksiBuku = new TransaksiBuku();
            transaksiBuku.setId(resultSet.getInt("id"));
            transaksiBuku.setPeminjam(person.getNamaById(resultSet.getInt("peminjam")));
            transaksiBuku.setBuku(buku.getJudulBukuById(resultSet.getInt("buku")));
            transaksiBuku.setTanggal_pinjam(resultSet.getDate("tangga_pinjam"));
            transaksiBuku.setTanggal_kembali(resultSet.getDate("tangga_kembali"));
            transaksiBuku.setSts_pengembalian(resultSet.getString("sts_pengembalian"));
            allTransaksi.add(transaksiBuku);
        }
        return allTransaksi;
    }

    public void addTransaksi(int idBuku, int idPeminjam){

        LocalDate tanggalPinjam;
        LocalDate tanggalKembali;
        String status = "'Belum Kembali'";
        tanggalPinjam = java.time.LocalDate.now();
        tanggalKembali = tanggalPinjam.plusDays(7);
        HashMap<String,String > hashMap = new HashMap<>();
        hashMap.put("buku", String.valueOf(idBuku));
        hashMap.put("peminjam",String.valueOf(idPeminjam));
        hashMap.put("tangga_pinjam",String.format("'%s'",tanggalPinjam));
        hashMap.put("tangga_kembali",String.format("'%s'",tanggalKembali));
        hashMap.put("sts_pengembalian",status);

        DBHelper.insert(TABEL,hashMap);

    }

    public boolean updateTransaksi(int idPeminjam, int idBuku){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("sts_pengembalian","'Sudah Kembali'");
        String params = String.format("peminjam = %s and buku == %s",idPeminjam,idBuku);
        return DBHelper.update(TABEL,hashMap,params);
    }


}
