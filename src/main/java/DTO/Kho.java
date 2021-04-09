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
public class Kho {
    String MaNVL, MaLoaiNVL ,TenNVL ,DoViTinh ,MaNCC;
    int SoLuong ;
    double DonGiaNhap;
    
    public Kho()    {
        
    }

    public Kho(String MaNVL, String MaLoaiNVL, String TenNVL, String DoViTinh, String MaNCC, int SoLuong, double DonGiaNhap) {
        this.MaNVL = MaNVL;
        this.MaLoaiNVL = MaLoaiNVL;
        this.TenNVL = TenNVL;
        this.DoViTinh = DoViTinh;
        this.MaNCC = MaNCC;
        this.SoLuong = SoLuong;
        this.DonGiaNhap = DonGiaNhap;
    }

    public String getMaNVL() {
        return MaNVL;
    }

    public void setMaNVL(String MaNVL) {
        this.MaNVL = MaNVL;
    }

    public String getMaLoaiNVL() {
        return MaLoaiNVL;
    }

    public void setMaLoaiNVL(String MaLoaiNVL) {
        this.MaLoaiNVL = MaLoaiNVL;
    }

    public String getTenNVL() {
        return TenNVL;
    }

    public void setTenNVL(String TenNVL) {
        this.TenNVL = TenNVL;
    }

    public String getDoViTinh() {
        return DoViTinh;
    }

    public void setDoViTinh(String DoViTinh) {
        this.DoViTinh = DoViTinh;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(double DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }
    
    
}
