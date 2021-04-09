/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_ChucNang;
import DTO.ChucNang;
import com.github.qquang24t5._8tea.EightTeaApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setDSQuyen();
        
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
    
}
