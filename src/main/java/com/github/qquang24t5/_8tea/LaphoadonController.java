/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_PhanLoaiSP;
import BUS.BUS_SanPham;
import BUS.BUS_HoaDon;
import DTO.ChiTietHoaDon;
import DTO.PhanLoaiSP;
import DTO.SanPham;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class LaphoadonController implements Initializable {

    @FXML
    private TableView<ChiTietHoaDon> tblHD;
    @FXML
    private TableView<SanPham> tblSP;
    @FXML
    private TextField txtKM;
    @FXML
    private TextField txtThanhToan;
    @FXML
    private Label txtThongbaoKM;
    ArrayList<PhanLoaiSP> list;
    Button[] listcb;
    @FXML
    private VBox vboxLoaiSP;
    @FXML
    private TableColumn<SanPham, String> colTenSP;
    @FXML
    private TableColumn<ChiTietHoaDon, Integer> colSL;
    @FXML
    private TableColumn<ChiTietHoaDon, Double> colDG;
    @FXML
    private TableColumn<ChiTietHoaDon, Double> colTT;
    @FXML
    private TableColumn<ChiTietHoaDon, String> colSP;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setCBLoaiSP();
        setTblSP();
        setTbOrder();
    }    

    @FXML
    private void backForm(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("hoadon");
    }

    @FXML
    private void ktraKM(ActionEvent event) {
    }

    @FXML
    private void lapHD(ActionEvent event) {
    }

    @FXML
    private void resetHD(ActionEvent event) {
    }
    public void setCBLoaiSP(){
         list = new BUS_PhanLoaiSP().getListLoaiSP();
         listcb = new Button[list.size()+1];
         int i = 0;
         for(PhanLoaiSP sp : list)
         {
             listcb[i]= new Button(sp.getTenLoai());
             listcb[i].setPrefSize(112, 27);
             listcb[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String text = ((Button)e.getSource()).getText();
                    String maloai = new BUS_PhanLoaiSP().layMaLoaiSP(text);
                    setTblSP(maloai);
                }
            });
             vboxLoaiSP.getChildren().add(listcb[i]);
             i++;
         }
         Button tatca = new Button("Tất cả");
         tatca.setPrefSize(112, 27);
         tatca.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                   
                    setTblSP();
                }
            });
         vboxLoaiSP.getChildren().add(tatca);
    }
    public void setTblSP(String maloai){
         tblSP.getItems().removeAll();
        ObservableList<SanPham> li = FXCollections.observableArrayList();
        ArrayList<SanPham> listsp = new BUS_SanPham().getListSP(maloai);
        for(SanPham sp : listsp)
        {
            li.add(sp);
        }
        
        
        colTenSP.setCellValueFactory(new PropertyValueFactory<SanPham, String> ("TenSP"));
        
        tblSP.setItems(li);
    }
    public void setTblSP(){
         tblSP.getItems().removeAll();
        ObservableList<SanPham> li = FXCollections.observableArrayList();
        ArrayList<SanPham> listsp = new BUS_SanPham().getListSP();
        for(SanPham sp : listsp)
        {
            li.add(sp);
        }
        
        
        colTenSP.setCellValueFactory(new PropertyValueFactory<SanPham, String> ("TenSP"));
        
        tblSP.setItems(li);
    }
    public void setTbOrder(){
        tblHD.getItems().removeAll();
        ObservableList<ChiTietHoaDon> li = FXCollections.observableArrayList();
        ArrayList<ChiTietHoaDon> listcthd = new BUS_HoaDon().loadOrder(EightTeaApplication.userhientai);
        for(ChiTietHoaDon od : listcthd)
        {
            li.add(od);
        }
        colSP.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, String> ("MaSP"));
        colSL.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, Integer> ("SoLuong"));
        colDG.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, Double> ("DonGia"));
        colTT.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, Double> ("ThanhTien"));
        
        tblHD.setItems(li);
        
    }

    @FXML
    private void themSPorder(MouseEvent event) {
      tblSP.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            if(mouseEvent.getClickCount() == 2){
               EightTeaApplication.alertInf("double click");
            }
        }
    }
});
    }
}
