package com.github.qquang24t5._8tea.presentation;

import com.github.qquang24t5._8tea.EightTeaApplication;
import com.github.qquang24t5._8tea.business.EmployeeController;
import com.github.qquang24t5._8tea.transference.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class LoginController {

    private final EmployeeController employeeController = new EmployeeController();

    @FXML
    private TextField tfdMobile;

    @FXML
    private TextField pfdPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblNotification;

    public void btnLogin_onMouseClicked(MouseEvent event) throws IOException {

        Employee e = Employee.builder()
                .mobile(tfdMobile.getText())
                .password(pfdPassword.getText())
                .build();

        List<String> errors = employeeController.logIn(e);

        if (errors.isEmpty()) {
            lblNotification.setStyle(null);
            EightTeaApplication.changeView(View.STARTUP);
        } else {
            lblNotification.setStyle("-fx-background-color: PINK");
            StringBuilder errorsAsString = new StringBuilder();
            for (String s : errors) {
                errorsAsString.append(s).append("\n");
            }
            lblNotification.setText(errorsAsString.toString());
        }

    }
}

