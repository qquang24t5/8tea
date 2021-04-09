/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DAO;
import DTO.Quyen_ChucNang;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class BUS_Quyen_ChucNang {
    DAO dao = new DAO();
    
    public ArrayList<Quyen_ChucNang> getListQCN(){
        ArrayList<Quyen_ChucNang> list = new ArrayList<>();
        String sql = "select * from Quyen_ChucNang";
        
        try {
            PreparedStatement ps  = dao.conn().prepareStatement(sql);
            ResultSet rs  =  ps.executeQuery();
            while(rs.next())
            {
                Quyen_ChucNang qcn = new Quyen_ChucNang();
                qcn.setMaCN(rs.getString("MaCN"));
                qcn.setMaCV(rs.getString("MaCV"));
                list.add(qcn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean ThemQCN(Quyen_ChucNang qcn){
        String sql = "insert into Quyen_ChucNang(MaCN,MaCV) values(?,?)";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.setString(1, qcn.getMaCN());
            ps.setString(2, qcn.getMaCV());
            
            return ps.executeUpdate() > 0 ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaQCN(String MaCV ,String MaCN){
        String sql = "update Quyen_ChucNang set MaCN='"+MaCN+"' where MaCV = '"+MaCV+"";
        
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.executeUpdate() ;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean XoaQCN(String MaCV)
    {
        String sql = "delete * from Quyen_ChucNang";
        try {
            PreparedStatement ps = dao.conn().prepareStatement(sql);
            ps.executeUpdate() ;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
