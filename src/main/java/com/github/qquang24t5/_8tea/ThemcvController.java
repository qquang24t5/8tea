/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.qquang24t5._8tea;

import BUS.BUS_ChucNang;
import DTO.
        ChucNang;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author MINH TUAN
 */
public class ThemcvController implements Initializable {

    @FXML
    private TableView<ChucNang> tblQuyen;
    @FXML
    private TableColumn<ChucNang, String> colMaQuyen;
    @FXML
    private TableColumn<ChucNang, String> colTenQuyen;
    @FXML
    private Button btnThem;
    @FXML
    private TextField txtTenQuyen;
    @FXML
    private TextField txtMaQuyen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setTableChucNang();
    }    

    @FXML
    private void backFormCV(MouseEvent event) throws IOException {
        EightTeaApplication.setRoot("chucvu");
    }
    
    public void setTableChucNang()
    {
        tblQuyen.getItems().removeAll();
        ObservableList<
                ChucNang> li = FXCollections.observableArrayList();
        ArrayList<
                ChucNang> listcn = new BUS_ChucNang().getListCN();
        for(ChucNang cn:listcn)
        {
            li.add(cn);
        }
        colMaQuyen.setCellValueFactory(new PropertyValueFactory<ChucNang, String>("MaCN"));
        colTenQuyen.setCellValueFactory(new PropertyValueFactory<ChucNang, String>("TenCN"));
        
        tblQuyen.setItems(li);
    }

    @FXML
    private void themQuyen(ActionEvent event) {
        ArrayList<String> ers = new ArrayList<>();
        if(txtMaQuyen.getText().isEmpty() || txtTenQuyen.getText().isEmpty())
        {
           EightTeaApplication.alertInf("Hãy nhập đầy đủ thông tin !");
        }
        else
        {
        ChucNang cn = new ChucNang();
        cn.setMaCN(txtMaQuyen.getText());
        cn.setTenCN(txtTenQuyen.getText());
        if(new BUS_ChucNang().ThemCN(cn))
            {
                EightTeaApplication.alertInf("Đã thêm quyền chức năng mới");
                setTableChucNang();
            }
            else
            {
                EightTeaApplication.alertInf("Lỗi hệ thống, vui lòng thử lại sau !");
            }
                
            }
        }
    
}
