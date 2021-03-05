package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;


    public void onClick(ActionEvent event) {
        System.out.println("Test");
    }
}
