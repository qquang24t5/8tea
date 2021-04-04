package com.github.qquang24t5._8tea.it;

import com.github.qquang24t5._8tea.business.EmployeeController;
import com.github.qquang24t5._8tea.persistence.EmployeeRepo;
import com.github.qquang24t5._8tea.transference.Employee;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class LoggingInTest {

    @Start
    void start(Stage stage) {

        Employee mockedEmployee = Employee.builder()
                .mobile("0123456789")
                .passwordHash(EmployeeController.hash("123StrongPassword!"))
                .disabled(false)
                .build();

        new EmployeeRepo().create(mockedEmployee);

        stage.show();
    }

    @Test
    void loggingInSuccessfully(FxRobot robot) {
        robot.clickOn("#mobile").type(KeyCode.valueOf("0123456789"));
    }

}
