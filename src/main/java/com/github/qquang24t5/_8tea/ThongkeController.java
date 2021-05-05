/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_HoaDon;
import BUS.BUS_NhanVien;
import BUS.BUS_SanPham;
import DTO.HoaDon;
import DTO.NhanVien;
import DTO.SanPham;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class ThongkeController implements Initializable {

    
    @FXML
    private TableView<HoaDon> tblDoanhThu;
    @FXML
    private TableColumn<HoaDon, String> colMaHD;
    @FXML
    private TableColumn<HoaDon, String> colNgayLap;
    @FXML
    private TableColumn<HoaDon, String> colKM;
    @FXML
    private TableColumn<HoaDon, Double> colTong;
    @FXML
    private TableColumn<SanPham, String> colSP;
    @FXML
    private TableColumn<SanPham, String> colTongSP;
    @FXML
    private RadioButton rdToanTG;
    @FXML
    private ToggleGroup thongkegr;
    @FXML
    private RadioButton rdKhoangTG;
    @FXML
    private DatePicker dateBD;
    @FXML
    private DatePicker dateKT;
    @FXML
    private Label lbTongHD;
    @FXML
    private ComboBox cbNV;
    @FXML
    private TableView<SanPham> tblSP;
    @FXML
    private Text txtLoi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setCBNV();
    }    

    @FXML
    private void backForm(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("home");
    }

    @FXML
    private void thongke(ActionEvent event) {
        txtLoi.setText("");
        if(rdKhoangTG.isSelected()&&(dateBD.getValue()==null||dateKT.getValue()==null)){
            txtLoi.setText("Hãy chọn khoảng thời gian cần thống kê !");
            
        } 
        else if(rdKhoangTG.isSelected()&&dateBD.getValue()!=null&&dateKT.getValue()!=null){
        if(!(dateBD.getValue().isBefore(dateKT.getValue())||dateBD.getValue().isEqual(dateKT.getValue()))){
           
            txtLoi.setText("Ngày bắt đầu phải bằng hoặc trước ngày kết thúc !");
        }else{
            String manv;
        if(String.valueOf(cbNV.getValue()).equals("Tất cả")){
            manv = "ALL";
            
        }else{
            manv = new BUS_NhanVien().MaNV(String.valueOf(cbNV.getValue()));
            
        }
        
        setTblHD(manv);
        setTblSP(manv);
        }
            
    }else
        {
            
            String manv;
        if(String.valueOf(cbNV.getValue()).equals("Tất cả")){
            manv = "ALL";
            
        }else{
            manv = new BUS_NhanVien().MaNV(String.valueOf(cbNV.getValue()));
            
        }
       
        setTblHD(manv);
        setTblSP(manv);
        }
        
    }
    public void setCBNV(){
        ObservableList<String> list = FXCollections.observableArrayList();
        ArrayList<NhanVien> listnv = new BUS_NhanVien().getListNV();

        for (NhanVien s : listnv) {
            list.add(s.getHoTen());
        }
        list.add("Tất cả");
        cbNV.setItems(list);
        cbNV.getSelectionModel().selectLast();
    }

    @FXML
    private void clickToanTG(ActionEvent event) {
        dateBD.setDisable(true);
        dateKT.setDisable(true);
        dateBD.setValue(null);
        dateKT.setValue(null);
    }

    @FXML
    private void clickKhoangTG(ActionEvent event) {
        dateBD.setDisable(false);
        dateKT.setDisable(false);
    }
    public void setTblHD(String manv){
        tblDoanhThu.getItems().removeAll();
        ArrayList<HoaDon> listhd=null;
        ObservableList<HoaDon> li = FXCollections.observableArrayList();
        if(manv.equals("ALL")&&rdToanTG.isSelected()){
            listhd = new BUS_HoaDon().getListHD();
        }else if(rdKhoangTG.isSelected()){
            LocalDate bd = dateBD.getValue();//For reference
            LocalDate kt = dateKT.getValue();//For reference
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listhd = new BUS_HoaDon().thongkeHD(bd.format(formatter),kt.format(formatter), manv);
        }else if(!manv.equals("ALL")&&rdToanTG.isSelected()){
            listhd = new BUS_HoaDon().getListHD(manv);
        }
        double tongtien = 0;
        for(HoaDon hd : listhd)
        {
            li.add(hd);
            tongtien+=hd.getTongTien();
        }
        
        
        colMaHD.setCellValueFactory(new PropertyValueFactory<HoaDon, String> ("MaHD"));
        colNgayLap.setCellValueFactory(new PropertyValueFactory<HoaDon, String> ("NgayTao"));
        colKM.setCellValueFactory(new PropertyValueFactory<HoaDon, String> ("MaKM"));
        colTong.setCellValueFactory(new PropertyValueFactory<HoaDon, Double> ("TongTien"));
        lbTongHD.setText(String.valueOf(tongtien));
        tblDoanhThu.setItems(li);
    }
    public void setTblSP(String manv){
        tblSP.getItems().removeAll();
        ArrayList<SanPham> listsp=null;
        ObservableList<SanPham> li = FXCollections.observableArrayList();
        if(manv.equals("ALL")&&dateBD.getValue()==null&&dateKT.getValue()==null){
            listsp = new BUS_SanPham().thongkeSP(manv);
        }else if(dateBD.getValue()!=null&&dateKT.getValue()!=null){
            LocalDate bd = dateBD.getValue();//For reference
            LocalDate kt = dateKT.getValue();//For reference
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listsp = new BUS_SanPham().thongkeSP(bd.format(formatter),kt.format(formatter), manv);
        }else if(!manv.equals("ALL")&&dateBD.getValue()==null&&dateKT.getValue()==null){
            listsp = new BUS_SanPham().thongkeSP(manv);
        }
        
        for(SanPham hd : listsp)
        {
            li.add(hd);
        }
        
        
        colSP.setCellValueFactory(new PropertyValueFactory<SanPham, String> ("TenSP"));
        colTongSP.setCellValueFactory(new PropertyValueFactory<SanPham, String> ("MaSP"));
        
        tblSP.setItems(li);
    }
}
