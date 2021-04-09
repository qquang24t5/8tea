/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO;
import DTO.SanPham;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class BUS_SanPham {
    DAO dao = new DAO();
    public ArrayList<SanPham> getListSP(){
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select * from SanPham";
        
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMaLoaiSP(rs.getString("MaLoaiSP"));
                //sp.setSize(rs.getString("Size"));
                sp.setGiaBan(rs.getDouble("GiaBan"));
                list.add(sp);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemSP(SanPham sp) {
        String sql = "insert into SanPham(MaSP,TenSP,MaLoaiSP,Size,GiaBan) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.setString(1,sp.getMaSP());
            ps.setString(2,sp.getTenSP());
            ps.setString(3,sp.getMaLoaiSP());
            //ps.setString(4,sp.getSize());
            ps.setDouble(5,sp.getGiaBan());
            return ps.executeUpdate() > 0 ;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaSP(String MaSP  , String TenSP,String MaLoaiSP , double GiaBan) {
        String sql = "UPDATE SanPham set TenSP='"+TenSP+"' , MaLoaiSP='"+MaLoaiSP+"' , GiaBan="+GiaBan+" where MaSP='"+MaSP+"' ";
         try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }
    
    public boolean XoaSP(String MaSP)   {
        String sql = "delete * from SanPham where MaSP = '"+MaSP+"'";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
