package org.fis.maven.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.Exceptions.UserPasswordIncorrect;
import org.fis.maven.Models.User;
import org.fis.maven.Services.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class LoginClient {
    @FXML
    private Label id;
    @FXML
    private TextField UsernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    public void butonBack()
    {
        try
        {
            Stage stage=(Stage)id.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Login or Register Menu");
            stage.setScene(new Scene(ceva,600,600));
            stage.show();

        }catch(IOException e) {
            System.out.println(e);
        }
    }


    public void login() {
            try {
                if (UserService.checkCredentials(UsernameField.getText(), UserService.encodePassword(passwordField.getText()))){
                    try{
                        ArrayList<User> u = UserService.getU();
                        for(User i:u){
                            if(UsernameField.getText().equals(i.getUsername())){
                                i.setLogged(true);
                            }
                        }
                        Stage stage=(Stage)id.getScene().getWindow();
                        Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
                        stage.setTitle("Login or Register Menu");
                        stage.setScene(new Scene(ceva,600,600));
                        stage.show();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
                else
                    throw new UserPasswordIncorrect();
            }catch (UserPasswordIncorrect e){
                System.out.println(e);
            }
    }
}
