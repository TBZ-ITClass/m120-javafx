package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.util.HTTPHandler;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text actiontarget;


    public void signIn(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Init errors
        ArrayList<String> errors = new ArrayList<>();
        actiontarget.setText("");


        // TODO: Create validator class to make validation easier.
        if(username.length() < 1)
            errors.add("Please provide a username.");

        if(password.length() < 4)
            errors.add("Please provide a password with at least 4 characters.");

        if(errors.size() != 0) {
            // Show errors and prevent outgoing request.
            actiontarget.setText(String.join("\n", errors));
            return;
        }
        try {
            switch (HTTPHandler.post("/login", "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\"}")) {
                case "200":
                    System.out.println("Logged in!");
                    System.exit(0);
                    break;
                case "401":
                    actiontarget.setText("Password is wrong.");
                    break;
                default:
                    actiontarget.setText("Password is wrong.");
                    //actiontarget.setText("Unknown error occurred. Try it again.");
            }

        } catch (IOException e) {
            System.out.println(e);
            actiontarget.setText("Unknown error occurred. Try it again.");
        }
    }
}
