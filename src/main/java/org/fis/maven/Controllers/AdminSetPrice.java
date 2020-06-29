package org.fis.maven.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.maven.Models.Race;
import org.fis.maven.Services.RaceService;

import java.io.IOException;

public class AdminSetPrice {
    @FXML
    private TextField priceField;

    @FXML
    public void back() {
        try {
            Stage stage = (Stage) priceField.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Login or Register Menu");
            stage.setScene(new Scene(ceva, 600, 600));
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void setPrice() {
        try {
            System.out.println(Race.getPricePerKm());
            Race.setPricePerKm(Integer.parseInt(priceField.getText()));
            System.out.println(Race.getPricePerKm());
        }catch(Exception e){

        }
    }
}
