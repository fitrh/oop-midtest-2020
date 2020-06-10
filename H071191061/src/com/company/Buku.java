package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Buku {
    private static final String TABEL = "buku";
    private int idBuku;
    private String judulBuku;
    private String pengarang;
    private String penerbit;
    private int ketersediaan;
    

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(int ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    public ArrayList<Buku> getallBuku(){
        ResultSet resultSet = DBHelper.selectAll(TABEL);
        ArrayList<Buku> allbuku = new ArrayList<>();
        while (true){
            try {
                if (resultSet.next()){
                    Buku buku = new Buku();
                    buku.setIdBuku(resultSet.getInt("id"));
                    buku.setJudulBuku(resultSet.getString("judul_buku"));
                    buku.setPengarang(resultSet.getString("pengarang"));
                    buku.setPenerbit(resultSet.getString("penerbit"));
                    buku.setKetersediaan(resultSet.getInt("ketersediaan"));
                    allbuku.add(buku);
                }else{
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allbuku;
    }

    public void addBuku(String judul, String pengarang, String penerbit, int ketersediaan){
        HashMap<String,String> map = new HashMap<>();
        map.put("judul_buku", String.format("'%s'",judul));
        map.put("pengarang", String.format("'%s'",pengarang));
        map.put("penerbit", String.format("'%s'",penerbit));
        map.put("ketersediaan",Integer.toString(ketersediaan));

        boolean isSuccess = DBHelper.insert("buku",map);

        if(isSuccess){
            System.out.println("Buku Berhasil Ditambahakan");
        }else {
            System.out.println("Buku Gagal DItambahkan");
        }
    }

    public void editBuku(int id, String judul, String pengarang, String penerbit, int ketersediaan){
        HashMap<String,String> map = new HashMap<>();
        map.put("judul_buku", "'"+judul+"'");
        map.put("pengarang", "'"+pengarang+"'");
        map.put("penerbit","'"+penerbit+"'");
        map.put("ketersediaan",Integer.toString(ketersediaan));

        String clause = String.format("id = %s", id);

        boolean isSuccess = DBHelper.update(TABEL,map,clause);

        if(isSuccess){
            System.out.println("Buku Berhasil Diedit");
        }else {
            System.out.println("Buku Gagal Diedit");
        }
    }

    public void deleteBuku(int id){
        String clause = "id="+id;
        boolean isSuccess = DBHelper.delete(TABEL,clause);
        if (isSuccess){
            System.out.println("Buku Berhasil Dihapus");
        }else{
            System.out.println("Buku Gagal Dihapus, mungkin id yang anda masukan salah");
        }
    }

    public ArrayList<Buku> getBukuByJudul(String judulBuku) throws SQLException {
        ArrayList<Buku> allBuku = new ArrayList<>();
        Buku buku;
        String query = "judul_buku like '%"+judulBuku+"%'";
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()){
            buku = new Buku();
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setKetersediaan(resultSet.getInt("ketersediaan"));
            buku.setIdBuku(resultSet.getInt("id"));
            allBuku.add(buku);
        }
        return allBuku;
    }

    public ArrayList<Buku> getBukuByPenerbit(String penerbit) throws SQLException {
        ArrayList<Buku> allBuku = new ArrayList<>();
        Buku buku;
        String query = "penerbit like '%"+penerbit+"%'";
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()){
            buku = new Buku();
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setKetersediaan(resultSet.getInt("ketersediaan"));
            buku.setIdBuku(resultSet.getInt("id"));
            allBuku.add(buku);
        }
        return allBuku;
    }

    public ArrayList<Buku> getBukuByPengarang(String pengarang) throws SQLException {
        ArrayList<Buku> allBuku = new ArrayList<>();
        Buku buku;
        String query = "penerbit like '%"+pengarang+"%'";
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()){
            buku = new Buku();
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setKetersediaan(resultSet.getInt("ketersediaan"));
            buku.setIdBuku(resultSet.getInt("id"));
            allBuku.add(buku);
        }
        return allBuku;
    }

    public String getJudulBukuById(int idBuku) throws SQLException {
        String judul = "";
        String query = "id = "+idBuku;
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()) judul = resultSet.getString("judul_buku");
        return judul;
    }

    public Buku getBukuById(int idBuku) throws SQLException {
        Buku buku = new Buku();
        String query = "id = "+idBuku;
        ResultSet resultSet = DBHelper.selectAll(TABEL,query);
        while (resultSet.next()){
            buku.setIdBuku(resultSet.getInt("id"));
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setKetersediaan(resultSet.getInt("ketersediaan"));
        }
        return buku;
    }

}
