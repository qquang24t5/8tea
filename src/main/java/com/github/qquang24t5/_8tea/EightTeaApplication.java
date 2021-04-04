package com.github.qquang24t5._8tea;

import com.github.qquang24t5._8tea.presentation.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EightTeaApplication extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(View.LOGIN.fxml), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void changeView(View view) throws IOException {
        setRoot(view.fxml);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EightTeaApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }

}