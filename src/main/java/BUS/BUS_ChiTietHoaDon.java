/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO;
import DTO.ChiTietHoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BUS_ChiTietHoaDon {
    DAO dao = new DAO();
    
    
    public ArrayList<ChiTietHoaDon> getListCTHD(){
    ArrayList<ChiTietHoaDon> list = new ArrayList<>();
    String sql = "SELECT * FROM ChiTietHoaDon";
    try {
        PreparedStatement ps = dao.conn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaHD(rs.getString("MaHD"));
            cthd.setMaSP(rs.getString("MaSP"));
            cthd.setSoLuong(rs.getInt("SoLuong"));
            cthd.setDonGia(rs.getDouble("DonGia"));
            list.add(cthd);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 
    
    public boolean ThemCTHD(ChiTietHoaDon cthd) {
        String sql = "insert into ChiTietHoaDon(MaHD,MaNV,NgayTao,MaKM,TongTien) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.setString(1,cthd.getMaHD());
            ps.setString(2,cthd.getMaSP());
            ps.setInt(4,cthd.getSoLuong());
            ps.setDouble(5,cthd.getDonGia());
            
            return ps.executeUpdate() > 0 ;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
