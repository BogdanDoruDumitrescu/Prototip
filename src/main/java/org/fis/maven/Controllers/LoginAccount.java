package org.fis.maven.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.awt.*;

import java.io.IOException;

public class LoginAccount {
    @FXML
    private Label id;
    @FXML
    public void signin(){

    }

    @FXML
    public void butonBack()
    {
        try
        {
            Stage stage=(Stage)id.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Set the price");
            stage.setScene(new Scene(ceva,600,600));

        }catch(IOException e) {
            System.out.println(e);
        }
    }
}
