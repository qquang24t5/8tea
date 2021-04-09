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
public class PhanLoaiNVL {
    String MaLoaiNVL , TenNVL ;
    
    public PhanLoaiNVL()    {
        
    }

    public PhanLoaiNVL(String MaLoaiNVL, String TenNVL) {
        this.MaLoaiNVL = MaLoaiNVL;
        this.TenNVL = TenNVL;
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
    
    
}
