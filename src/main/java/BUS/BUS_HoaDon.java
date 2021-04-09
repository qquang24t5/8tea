/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO;
import DTO.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BUS_HoaDon {
    DAO dao = new DAO();
    
    
    public ArrayList<HoaDon> getListHD(){
    ArrayList<HoaDon> list = new ArrayList<>();
    String sql = "SELECT * FROM HoaDon";
    try {
        PreparedStatement ps = dao.conn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            HoaDon hd = new HoaDon();
            hd.setMaHD(rs.getString("MaHD"));
            hd.setMaNV(rs.getString("MaNV"));
            hd.setNgayTao(rs.getString("NgayTao"));
            hd.setMaKM(rs.getString("MaKM"));
            hd.setTongTien(rs.getDouble("TongTien"));
            list.add(hd);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 
    
    public boolean ThemHD(HoaDon hd) {
        String sql = "insert into HoaDon(MaHD,MaNV,NgayTao,MaKM,TongTien) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.setString(1,hd.getMaHD());
            ps.setString(2,hd.getMaNV());
            ps.setString(3,hd.getNgayTao());
            ps.setString(4,hd.getMaKM());
            ps.setDouble(5,hd.getTongTien());
            
            return ps.executeUpdate() > 0 ;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public boolean SuaHD(String MaNV , String HoTen ,String GioiTinh , String SDT , String NgaySinh ,String MaCV )  {
//        String sql = "UPDATE NhanVien set HoTen='"+HoTen+"' ,GioiTinh='"+GioiTinh+"',SDT='"+SDT+"',NgaySinh='"+NgaySinh+"',MaCV='"+MaCV+"' where MaNV='"+MaNV+"' ";
//         try {
//            PreparedStatement ps = dao.conn().prepareStatement(sql);
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//         return false;
//    }
    
   
}
