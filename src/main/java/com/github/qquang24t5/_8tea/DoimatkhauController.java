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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class DoimatkhauController implements Initializable {

    @FXML
    private AnchorPane txt;
    @FXML
    private Text txtBaoLoi;
    @FXML
    private TextField txtMKCu;
    @FXML
    private TextField txtMKMoi;
    @FXML
    private TextField txtXacnhanMK;
    @FXML
    private Label lbThongbao1;
    @FXML
    private Label lbThongbao2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backHome(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("home");
    }

    @FXML
    private void doiMK(ActionEvent event) {
    }
    
}
