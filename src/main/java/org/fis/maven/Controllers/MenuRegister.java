package org.fis.maven.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class MenuRegister {

    @FXML
    private Label id;

    @FXML
    public void registerButton(){
        try {
            Stage stage = (Stage) id.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("Register.fxml"));
            stage.setTitle("Register account");

            stage.setScene(new Scene(parent, 600,600));
            stage.show();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    @FXML
    public void loginButton(){
        try{
            Stage stage=(Stage)id.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            stage.setTitle("Login account");
            stage.setScene((new Scene(parent, 600,600)));
            stage.show();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}