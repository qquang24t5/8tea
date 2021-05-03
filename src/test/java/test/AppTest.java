package test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.*;

//test login
public class AppTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML());
        stage.setScene(scene);
        stage.show();

    }

    static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        String fxmlURL = "file:///C:/Users/Lenovo/Documents/software testing/8tea/src/main/resources/com/github/qquang24t5/_8tea/" + "login" + ".fxml";
        URL url = new URL(fxmlURL);
        fxmlLoader.setLocation(url);
        return fxmlLoader.load();
    }

    @Before
    public void setUp() throws Exception{}

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testWhenTwoFieldsIsEmty() {
        clickOn("#button");
        String errorMsg = lookup("#lbLoi").queryAs(Text.class).getText();
        MatcherAssert.assertThat(errorMsg, is("Hãy nhập đẩy đủ thông tin !"));
    }

    @Test
    public void testWhenPasswordIsEmty() {
        clickOn("#txtTaikhoan");
        write("398239");
        clickOn("#button");
        String errorMsg = lookup("#lbLoi").queryAs(Text.class).getText();
        MatcherAssert.assertThat(errorMsg, is("Hãy nhập đẩy đủ thông tin !"));
    }

    @Test
    public void testWhenUsernameIsEmty() {
        clickOn("#txtMatkhau");
        write("2924");
        clickOn("#button");
        String errorMsg = lookup("#lbLoi").queryAs(Text.class).getText();
        MatcherAssert.assertThat(errorMsg, is("Hãy nhập đẩy đủ thông tin !"));
    }
}
