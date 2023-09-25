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

public class Member {

    private int idMember;
    private String nama, no_hp;

    public Member() {
    }

    public Member(String nama, String no_hp) {

        this.nama = nama;
        this.no_hp = no_hp;

    }

    public Member getById(int id) {
        Member mb = new Member();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM member " + "WHERE id_member = '" + id + "'");

        try {
            while (rs.next()) {
                mb = new Member();
                mb.setId_member(rs.getInt("id_member"));
                mb.setNama(rs.getString("nama"));
                mb.setNo_hp(rs.getString("no_hp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mb;

    }

    public ArrayList<Member> getAll() {

        ArrayList<Member> ListMember = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM member");

        try {
            while (rs.next()) {
                Member mb = new Member();
                mb.setId_member(rs.getInt("id_member"));
                mb.setNama(rs.getString("nama"));
                mb.setNo_hp(rs.getString("no_hp"));

                ListMember.add(mb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMember;
    }

    public void save() {
        if (getById(idMember).getId_member() == 0) {
            String SQL = "INSERT INTO member (nama, no_hp) VALUES("
                    + " '" + this.nama + "', "
                    + " '" + this.no_hp + "' "
                    + " )";
            this.idMember = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE member SET "
                    + " nama = '" + this.nama + "', "
                    + " no_hp = '" + this.no_hp + "' "
                    + " WHERE id_member = '" + this.idMember + "'";
            DBHelper.executeQuery(SQL);
        }

    }

    public void delete() {
        String SQL = "DELETE FROM member WHERE id_member = '" + this.idMember + "'";
        DBHelper.executeQuery(SQL);
    }

    public int getId_member() {
        return idMember;
    }

    public void setId_member(int idMember) {
        this.idMember = idMember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
    public String toString() {
        return nama;
    }
}
