
import Backend.Member;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lukman
 */
public class TestGedung {
    public static void main(String[] args) {
//        Member mb1 = new Member(5,"Asem", "pasuruan");
//        Member mb2 = new Member(6,"Asem jawawh", "malang");
//        Member mb3 = new Member(2,"Asem bajak", "pajak");
//        
//        mb1.save();
//        mb2.save();
//        mb3.save();
//        
//        mb2.setNama("anjeeeng");
//        mb2.save();
//        
//        mb3.delete();
//        
//        for(Member g : new Member().getAll()) {
//            System.out.println("Nama:" +g.getNama() +", rganti: "+ g.getR_ganti() + ", Alamat : "+g.getAlamat());
//        }
//        mb1.setAlamat("malang");
//        mb1.save();

        Member mb1 = new Member("Asem", "1111");
        Member mb2 = new Member("Asem jawawh", "2222");
        Member mb3 = new Member("Asem bajak", "3333");
        
        mb1.save();
        mb2.save();
        mb3.save();
        
        mb2.setNama("lukman");
        mb2.save();
        
        mb3.delete();
        
        for(Member g : new Member().getAll()) {
            System.out.println("Nama:" +g.getNama() +", Nomor HP : "+g.getNo_hp());
        }
        
        
    }
}
