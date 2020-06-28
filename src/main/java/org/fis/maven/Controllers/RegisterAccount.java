package org.fis.maven.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.scene.control.Label;

import org.fis.maven.Exceptions.AlreadyExists;
import org.fis.maven.Models.Admin;
import org.fis.maven.Models.User;
import org.fis.maven.Services.AdminService;
import org.fis.maven.Services.UserService;


import javax.jws.soap.SOAPBinding;
import java.awt.*;
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
    private ChoiceBox role;
    @FXML
    private TextField CreditField;
    @FXML
    private Label id;
    @FXML

    public void initialize(){
        role.getItems().addAll("Admin", "Driver", "Client");
        role.setValue("Driver");
        AdminService.loadAdmins();
        UserService.loadUser();
    }

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
        try {
            if (role.getValue().equals("Admin")) {
                for (Admin i : AdminService.getA()) {
                    if (i.getUsername().equals(UsernameField.getText())) {
                        throw new AlreadyExists();
                    }
                }

                AdminService.getA().add(new Admin(NameField.getText(), UsernameField.getText(), AdminService.encodePassword(PasswordField.getText()), MailField.getText()));
                AdminService.writeAdmins();
            } else {
                for(User i:UserService.getU()){
                    if(i.getUsername().equals(UsernameField.getText())){
                        throw new AlreadyExists();
                    }
                }

                UserService.getU().add(new User(NameField.getText(), UsernameField.getText(), UserService.encodePassword(PasswordField.getText()), MailField.getText(), role.getValue().toString(), Integer.parseInt(CreditField.getText())));
                UserService.writeUser();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
