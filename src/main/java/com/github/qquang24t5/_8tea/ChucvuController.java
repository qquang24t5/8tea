/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_ChucNang;
import BUS.BUS_ChucVu;
import DTO.ChucNang;
import DTO.ChucVu;
import com.github.qquang24t5._8tea.EightTeaApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class ChucvuController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private TableView<ChucVu> tblChucvu;
    
    @FXML
    private TableColumn<ChucVu, String> colMaCV;
    @FXML
    private TableColumn<ChucVu, String> colTenCV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setDSQuyen();
        setTableCV();
    }    



    @FXML
    private void backHome(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("home");
    }

    @FXML
    private void themQuyen(ActionEvent event) throws IOException {
        EightTeaApplication.setRoot("themcv");
    }

    @FXML
    private void suaQuyen(ActionEvent event) {
    }

    @FXML
    private void xoaQuyen(ActionEvent event) {
    }
    public void setDSQuyen()
    {
        ArrayList<ChucNang> listcn = new BUS_ChucNang().getListCN();
        CheckBox[] list = new CheckBox[listcn.size()];
        int i = 0;
        for(ChucNang cn : listcn)
        {
            list[i] = new CheckBox(cn.getTenCN());
            vbox.getChildren().add(list[i]);
            i++;
        }
        vbox.setSpacing(10);
    }
    
    
    public void setTableCV()
    {
        tblChucvu.getItems().removeAll();
        ObservableList<ChucVu> li = FXCollections.observableArrayList();
        ArrayList<ChucVu> listcv = new BUS_ChucVu().getListCV();
        for(ChucVu cv:listcv)
        {
            li.add(cv);
        }
        colMaCV.setCellValueFactory(new PropertyValueFactory<ChucVu, String>("MaCV"));
        colTenCV.setCellValueFactory(new PropertyValueFactory<ChucVu, String>("TenCV"));
        
        tblChucvu.setItems(li);
    }
    
}
