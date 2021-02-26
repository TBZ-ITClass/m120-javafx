package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane root = new GridPane();

        /*
         * TODO:
         *  - Alignment, Padding, Gaps und Fonts setzen
         */

        // UI Controls
        Text loginTxt = new Text("Login:");
        Label lblUsr = new Label("Username:");
        TextField txtUsr = new TextField();
        Label lblPwd = new Label("Password");
        PasswordField txtPwd = new PasswordField();
        Button loginBtn = new Button("Login");

        // add UI Controls to Grid
        root.add(loginTxt, 0, 0, 2, 1);
        root.add(lblUsr, 0, 1);
        root.add(txtUsr, 1, 1);
        root.add(lblPwd, 0, 2);
        root.add(txtPwd, 1, 2);
        root.add(loginBtn, 1, 3);

        // set Scene and show Stage
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
