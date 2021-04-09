/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class BangCongThuc {
    String MaSP , MaNVL, DonViTinh ;
    int SoLuong ;
    
    public BangCongThuc()   {
        
    }

    public BangCongThuc(String MaSP, String MaNVL, String DonViTinh, int SoLuong) {
        this.MaSP = MaSP;
        this.MaNVL = MaNVL;
        this.DonViTinh = DonViTinh;
        this.SoLuong = SoLuong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaNVL() {
        return MaNVL;
    }

    public void setMaNVL(String MaNVL) {
        this.MaNVL = MaNVL;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
