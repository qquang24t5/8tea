/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class HoadonController implements Initializable {

    @FXML
    private Text txtBaoLoi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backForm(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("home");
    }


    @FXML
    private void xemchitiet(ActionEvent event) {
    }

    @FXML
    private void giaodienlapHD(ActionEvent event) throws IOException {
        EightTeaApplication.setRoot("laphoadon");
    }
    
}