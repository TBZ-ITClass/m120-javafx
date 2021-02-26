package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane root = new GridPane();
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        // UI Controls
        Text loginTxt = new Text("Login");
        loginTxt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        loginTxt.setFill(Color.rgb(36, 48, 94));

        Label lblUsr = new Label("Username:");
        TextField txtUsr = new TextField();

        Label lblPwd = new Label("Password");
        PasswordField txtPwd = new PasswordField();

        Text lblErr = new Text("");
        lblErr.setFill(Color.rgb(247, 92, 108));

        Button loginBtn = new Button("Login");

        /*
         * TODO:
         *  - Alignment, Padding, Gaps und Fonts setzen
         */


        // add UI Controls to Grid
        root.add(loginTxt, 0, 0, 2, 1);
        root.add(lblUsr, 0, 1);
        root.add(txtUsr, 1, 1);
        root.add(lblPwd, 0, 2);
        root.add(txtPwd, 1, 2);
        root.add(lblErr, 1, 3);
        root.add(loginBtn, 1, 4);

        loginBtn.setOnAction(event -> {
            String username = txtUsr.getText();
            String password = txtPwd.getText();

            // Init errors
            ArrayList<String> errors = new ArrayList<>();
            lblErr.setText("");


            // TODO: Create validator class to make validation easier.
            if(username.length() < 1)
                errors.add("Please provide a username.");

            if(password.length() < 4)
                errors.add("Please provide a password with at least 4 characters.");

            if(errors.size() != 0) {
                // Show errors and prevent outgoing request.
                lblErr.setText(String.join("\n", errors));
                return;
            }
            System.out.println(txtUsr.getText() + " | " + txtPwd.getText());
        });

        // set Scene and show Stage
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 500, 415));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
