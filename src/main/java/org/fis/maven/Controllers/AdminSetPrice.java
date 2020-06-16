package org.fis.maven.Controllers;

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



}