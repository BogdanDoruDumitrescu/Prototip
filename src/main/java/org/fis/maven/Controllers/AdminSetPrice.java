package org.fis.maven.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.Exceptions.IncorrectAmount;
import org.fis.maven.Models.Admin;
import org.fis.maven.Models.Price;
import org.fis.maven.Services.AdminService;
import org.fis.maven.Services.PriceService;


import java.io.IOException;
import java.util.ArrayList;

public class AdminSetPrice {

    @FXML
    private Label id;
    @FXML
    private TextField priceField;
    @FXML
    public void SetPrice() {
        ArrayList<Price> p = PriceService.getP();
        boolean flag = false;

        for (Price i : p) {
            if (priceField.getText() == String.valueOf(0))
                flag = true;
        }

        try {
            if (flag) {
                throw new IncorrectAmount();
            } else {
                p.add(new Price(Integer.parseInt(priceField.getText())));
                PriceService.WritePrice();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

        @FXML
        public void ContinueButton()
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
    }