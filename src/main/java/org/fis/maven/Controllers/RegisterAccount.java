package org.fis.maven.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.scene.control.Label;

import org.fis.maven.Models.User;
import org.fis.maven.Services.UserService;


import java.io.IOException;
import java.util.ArrayList;

public class RegisterAccount {
    @FXML
    private TextField NameField;
    @FXML
    private TextField UsernameField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private TextField MailField;
    @FXML
    private TextField RoleField;
    @FXML
    private TextField CreditField;
    @FXML
    private Label id;
    @FXML
    public void backButton()
    {
        try
        {
            Stage stage=(Stage)id.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Choice");
            stage.setScene(new Scene(ceva,600,600));

        }catch(IOException e) {
            System.out.println(e);
        }
    }

    public void signin() {
        ArrayList<User> u = UserService.getU();

        try{
            u.add(new User(NameField.getText(),UsernameField.getText(),PasswordField.getText(),MailField.getText(),RoleField.getText(),Integer.parseInt(CreditField.getText())));
            UserService.writeUser();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
