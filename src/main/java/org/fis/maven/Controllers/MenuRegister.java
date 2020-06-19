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
    public void logindriver(){
        try{
            Stage stage=(Stage)id.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            stage.setTitle("Login as driver");
            stage.setScene((new Scene(parent, 600,600)));
            stage.show();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    @FXML
    public void loginclient(){
        try{
            Stage stage=(Stage)id.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("LoginClient.fxml"));
            stage.setTitle("Login as client");
            stage.setScene((new Scene(parent, 600,600)));
            stage.show();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    @FXML
    public void butonBack()
    {
        try
        {
            Stage stage=(Stage)id.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("AdminSetPrice.fxml"));
            stage.setTitle("Set the price");
            stage.setScene(new Scene(ceva,600,600));

        }catch(IOException e) {
            System.out.println(e);
        }
    }
}