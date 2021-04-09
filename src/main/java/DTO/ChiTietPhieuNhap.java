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
public class ChiTietPhieuNhap {
    String MaPN , MaNVL , DonViTinh ;
    double DonGiaNhap , SoLuong ;
    
    public ChiTietPhieuNhap()  {
        
    }

    public ChiTietPhieuNhap(String MaPN, String MaNVL, String DonViTinh, double DonGiaNhap, double SoLuong) {
        this.MaPN = MaPN;
        this.MaNVL = MaNVL;
        this.DonViTinh = DonViTinh;
        this.DonGiaNhap = DonGiaNhap;
        this.SoLuong = SoLuong;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
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

    public double getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(double DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
    
}
