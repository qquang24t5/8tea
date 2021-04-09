/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import DAO.DAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class LoginController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private TextField txtTaikhoan;
    @FXML
    private PasswordField txtMatkhau;
    @FXML
    private ImageView lbLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    


   

    @FXML
    private void dangnhap(ActionEvent event) throws IOException {
           
          
          String manv = txtTaikhoan.getText();
          String pass = txtMatkhau.getText();
          if(manv.isEmpty()||pass.isEmpty())
          {
              EightTeaApplication.alertInf("Hãy nhập đầy đủ thông tin !");
          }
          else 
          {
          String check = new DAO().ktraDangNhap(manv,pass);
          if(check!=null)
          {
              EightTeaApplication.userhientai=check;
              EightTeaApplication.setRoot("home");
              
          }
          else
          {
              EightTeaApplication.alertInf("Sai tài khoản hoặc mật khẩu");
              
              
          }
          }
    }
  
    
}
