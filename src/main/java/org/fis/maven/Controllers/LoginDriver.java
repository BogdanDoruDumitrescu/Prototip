package org.fis.maven.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.Exceptions.UserPasswordIncorrect;
import org.fis.maven.Models.User;
import org.fis.maven.Services.UserService;

import java.io.IOException;

public class LoginDriver {
    @FXML
    private TextField idField;
    @FXML
    private PasswordField passField;

    private static User current;

    @FXML
    public void initialize(){
        UserService.loadUser();
    }

    @FXML
    public void back(){
        try
        {
            Stage stage=(Stage)idField.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Login or Register Menu");
            stage.setScene(new Scene(ceva,600,600));
            stage.show();

        }catch(IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void login(){
        try {
            if(UserService.checkCredentials(idField.getText(), UserService.encodePassword(passField.getText()))){
                try
                {
                    for(User i:UserService.getU()){
                        if(i.getUsername().equals(idField.getText())&&i.getRole().equals("Driver")){
                            current = i;
                            break;
                        }
                    }

                    current.setLogged(true);

                    Stage stage=(Stage)idField.getScene().getWindow();
                    Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("DriverPage.fxml"));
                    stage.setTitle("Driver Page");
                    stage.setScene(new Scene(ceva,600,600));
                    stage.show();

                }catch(IOException e) {
                    System.out.println(e);
                }
            }else{
                throw new UserPasswordIncorrect();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static User getCurrent() {
        return current;
    }
}
