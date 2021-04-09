package com.github.qquang24t5._8tea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class EightTeaApplication extends Application {

    private static Scene scene;
    public static String userhientai=null;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Quản lý cửa hàng trà sữa");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EightTeaApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void alertInf(String inf) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(inf);
        a.setTitle("Thông báo");
        a.setHeaderText(null);
        a.showAndWait();
    }

    public static boolean alertConf(String inf) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText(inf);
        a.setTitle("Thông báo");
        a.setHeaderText(null);
        Optional<ButtonType> option = a.showAndWait();

        if (option.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
