package org.fis.maven.Controllers;

<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminSetPrice {
    private int price;

    private Label usernameLabel;
    private Label passwordLabel;
    private Label priceLabel;

    private TextField usernameTextField;
    private TextField passwordTextField;
    private TextField priceTextField;

    public void setPrice(String price){
        int foo;
        try {
            foo = Integer.parseInt(price);
        }
        catch (NumberFormatException e)
        {
            foo = 0;
        }


    }

    public int getPrice(){return price};

    public void setPrice(){

    }


=======

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.fis.maven.Exceptions.IncorrectAmount;
import org.fis.maven.Models.Admin;
import org.fis.maven.Services.AdminService;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class AdminSetPrice {
>>>>>>> origin/SetPriceDone

    @FXML
    private TextField priceField;

    @FXML
    public void SetPrice(){
        ArrayList<Admin> p = AdminService.getP();
        boolean flag = false;

        for(Admin i:p){
            if(priceField.getText() == String.valueOf(0))
                flag = true;
        }

    try

    {
        if (flag) {
            throw new IncorrectAmount();
        } else {
            p.add(new Admin(Integer.parseInt(priceField.getText())));
            AdminService.WritePrice();
        }
    }catch(Exception e){
    System.out.println(e);}

}

}


