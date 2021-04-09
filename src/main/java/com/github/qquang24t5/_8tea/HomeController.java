/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_ChucVu;
import BUS.BUS_NhanVien;
import DTO.NhanVien;
import com.github.qquang24t5._8tea.EightTeaApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnNV;
    @FXML
    private Label txtName;
    @FXML
    private Label txtPer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setHome();

    }

    @FXML
    private void formQLNV(ActionEvent event) throws IOException {
        EightTeaApplication.setRoot("nhanvien");
    }

    @FXML
    private void dangxuat(ActionEvent event) throws IOException {
        if (EightTeaApplication.alertConf("Bạn có muốn đăng xuất ?")) {
            EightTeaApplication.setRoot("login");
            EightTeaApplication.userhientai = null;
        }

    }

    @FXML
    private void formCV(ActionEvent event) throws IOException {
        EightTeaApplication.setRoot("chucvu");
    }

    public void setHome() {
        NhanVien cu = new BUS_NhanVien().TimNV(EightTeaApplication.userhientai);
        txtName.setText(cu.getHoTen());
        txtPer.setText(new BUS_ChucVu().tenCV(cu.getMaCV()));
    }
}
