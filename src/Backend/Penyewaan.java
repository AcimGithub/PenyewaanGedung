package Backend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukman
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

public class Penyewaan {
    private int id_penyewaan;
    private Gedung gd = new Gedung();
    private Member mb = new Member();
    private String tanggal;
    private String mulai;
    private String selesai;
    private int totalHarga;
    
    
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public Member getMember() {
        return mb;
    }

    public void setMember(Member mb) {
        this.mb = mb;
    }
    

    public int getId_penyewaan() {
        return id_penyewaan;
    }

    public void setId_penyewaan(int id_penyewaan) {
        this.id_penyewaan = id_penyewaan;
    }

    public Gedung getGedung() {
        return gd;
    }

    public void setGedung(Gedung gd) {
        this.gd = gd;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    public Penyewaan() {}
    
    public Penyewaan(Member mb, Gedung gd, String mulai, String selesai) {
        this.mb = mb;
        this.gd = gd;
        this.mulai = mulai;
        this.selesai = selesai;
//        this.totalHarga = totalHarga;
    }
    
    public Penyewaan getById(int id) {
        Penyewaan sw = new Penyewaan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penyewaan " + "WHERE id_penyewaan = '"+id+"'");
        
        try {
            while(rs.next()) {
                sw = new Penyewaan();
                Gedung gd = new Gedung().getById(rs.getInt("id_gedung"));
                Member mb = new Member().getById(rs.getInt("id_member"));
                
                sw.setId_penyewaan(rs.getInt("id_penyewaan"));
                sw.setMember(mb);
                sw.setGedung(gd);
                sw.setTanggal(rs.getString("tanggal"));
                sw.setMulai(rs.getString("mulai"));
                sw.setSelesai(rs.getString("selesai"));
                sw.setTotalHarga(rs.getInt("totalHarga"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } return sw;
    }
    
    public ArrayList<Penyewaan> getAll() {
        ArrayList<Penyewaan> ListPenyewaan = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penyewaan");
        
        try {
            while(rs.next()) {
                Penyewaan sw = new Penyewaan();
                Gedung gd = new Gedung().getById(rs.getInt("id_gedung"));
                Member mb = new Member().getById(rs.getInt("id_member"));
                
                sw.setId_penyewaan(rs.getInt("id_penyewaan"));
                sw.setMember(mb);
                sw.setGedung(gd);
                sw.setTanggal(rs.getString("tanggal"));
                sw.setMulai(rs.getString("mulai"));
                sw.setSelesai(rs.getString("selesai"));
                sw.setTotalHarga(rs.getInt("totalHarga"));
                
                ListPenyewaan.add(sw);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPenyewaan;
    }
    
    public void edit() {
        String SQL = "UPDATE penyewaan SET "
                    + " id_member = '"+this.mb.getId_member()+"', "
                    + " id_gedung = '"+this.gd.getId_gedung()+"', "
                    + " tanggal = '"+this.tanggal+"', "
                    + " mulai = '"+this.mulai+"', "
                    + " selesai = '"+this.selesai+"', "
                    + " totalHarga = '"+this.totalHarga+"' "
                    + " WHERE id_penyewaan = '"+this.id_penyewaan+"'";
            DBHelper.executeQuery(SQL);
    }
    
    public void save() {
        
        
           String SQL = "INSERT INTO penyewaan (id_member, id_gedung, tanggal, mulai, selesai, totalHarga) VALUES("
                   +" '"+this.mb.getId_member()+"', "
                   +" '"+this.gd.getId_gedung()+"', "
                   +" '"+this.tanggal+"', "
                   +" '"+this.mulai+"', "
                   +" '"+this.selesai+"', "
                   +" '"+this.totalHarga+"' "
                   +" )";
           this.id_penyewaan = DBHelper.insertQueryGetId(SQL);
        
    }
    
    public void delete() {
        String SQL = "DELETE FROM penyewaan WHERE id_penyewaan = '"+this.id_penyewaan+"'";
        DBHelper.executeQuery(SQL);
    }
    
}
