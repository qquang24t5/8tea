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
public class KhuyenMai {
    String MaKM ,TenKM , NgayBD , NgayKT ;
    float PhanTramKM;
    String TrangThai ;
    
    public KhuyenMai()  {
        
    }

    public KhuyenMai(String MaKM, String TenKM, String NgayBD, String NgayKT, float PhanTramKM, String TrangThai) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.PhanTramKM = PhanTramKM;
        this.TrangThai = TrangThai;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public float getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(float PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
