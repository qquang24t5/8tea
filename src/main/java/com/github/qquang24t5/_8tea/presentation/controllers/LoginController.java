package com.github.qquang24t5._8tea.presentation.controllers;

import com.github.qquang24t5._8tea.transference.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class LoginController {
    EmployeeController employeeController = new EmployeeController();

    @FXML
    private TextField tfdPhoneNumber;

    @FXML
    private TextField pfdPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label notification;

    @FXML
    void btnLogin_onMouseClicked(MouseEvent event) {
        Employee employee = Employee.builder()
                .mobile(tfdPhoneNumber.getText())
                .password(pfdPassword.getText())
                .build();
        List<String> nofi = employeeController.checkLogin(employee);
        notification.setText(nofi.toString());
    }

}
