package org.fis.maven.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import org.fis.maven.Exceptions.UserPasswordIncorrect;
import org.fis.maven.Models.Admin;
import org.fis.maven.Services.AdminService;

import java.util.ArrayList;

public class AdminSetPrice {
    private int price;

    private Label usernameLabel;
    private Label passwordLabel;
    private Label priceLabel;

    private TextField userField;
    private TextField passwordField;
    private TextField priceField;

    public int getPrice() {
        return price;
    }

    public void setPrice(String price) {
        try {
            if (AdminService.checkCredentials(userField.getText(), passwordField.getText()))
                try {
                    ArrayList<Admin> admin = AdminService.getAdmin();
                    for (Admin i : admin) {
                        i.setPrice(Integer.parseInt(priceField.getText()));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }





