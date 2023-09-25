package Backend;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukman
 */
public class Gedung {
    private int id_gedung, r_ganti;
    private String nama, alamat;
    
    public Gedung(){}
    
    public Gedung(int r_ganti, String nama, String alamat) {
        
        this.r_ganti = r_ganti;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    public Gedung getById(int id) {
        Gedung gd = new Gedung();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM gedung " + "WHERE id_gedung = '"+id+"'");
        
        try {
            while(rs.next()) {
                gd = new Gedung();
                gd.setId_gedung(rs.getInt("id_gedung"));
                gd.setR_ganti(rs.getInt("r_ganti"));
                gd.setNama(rs.getString("nama"));
                gd.setAlamat(rs.getString("alamat"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } return gd;
    }
    
    public ArrayList<Gedung> getAll() {
        
        ArrayList<Gedung> ListGedung = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM gedung");
        
        try {
            while(rs.next()) {
                Gedung gd = new Gedung();
                gd.setId_gedung(rs.getInt("id_gedung"));
                gd.setR_ganti(rs.getInt("r_ganti"));
                gd.setNama(rs.getString("nama"));
                gd.setAlamat(rs.getString("alamat"));
                
                ListGedung.add(gd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListGedung;
    }
    
    public void save() {
        if(getById(id_gedung).getId_gedung() == 0) {
           String SQL = "INSERT INTO gedung (r_ganti, nama, alamat) VALUES("
                   +" '"+this.r_ganti+"', "
                   +" '"+this.nama+"', "
                   +" '"+this.alamat+"' "
                   +" )";
           this.id_gedung = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE gedung SET "
                    + " r_ganti = '"+this.r_ganti+"', "
                    + " nama = '"+this.nama+"', "
                    + " alamat = '"+this.alamat+"' "
                    + " WHERE id_gedung = '"+this.id_gedung+"'";
            DBHelper.executeQuery(SQL);
        }
        
    }
    
    public void delete() {
        String SQL = "DELETE FROM gedung WHERE id_gedung = '"+this.id_gedung+"'";
        DBHelper.executeQuery(SQL);
    }
    
//    public void edit() {
//        String SQL = "UPDATE gedung SET r_ganti = '"+this.r_ganti+"',nama = '"+this.nama+"', alamat = '"+this.alamat+"' WHERE id_gedung = '"+this.id_gedung+"'";
//        DBHelper.executeQuery(SQL);
//    }

    public int getId_gedung() {
        return id_gedung;
    }

    public void setId_gedung(int id_gedung) {
        this.id_gedung = id_gedung;
    }

    public int getR_ganti() {
        return r_ganti;
    }

    public void setR_ganti(int r_ganti) {
        this.r_ganti = r_ganti;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String toString() {
        return nama;
    }
    
}
