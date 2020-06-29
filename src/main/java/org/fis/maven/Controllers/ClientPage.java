package org.fis.maven.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.fis.maven.Models.Race;
import org.fis.maven.Models.User;
import org.fis.maven.Services.RaceService;
import org.fis.maven.Services.UserService;

import java.util.ArrayList;

public class ClientPage {

    private Button logoutButton;
    private javafx.scene.control.TableView<Race> tableID;
    private javafx.scene.control.TableColumn<Race, String> driverColumn;
    private javafx.scene.control.TableColumn<Race, String> raceColumn;
    private javafx.scene.control.TableColumn<Race, Integer> kmColumn;
    private javafx.scene.control.TableColumn<Race, Integer> priceColumn;

    private Label creditLabel;
    private Label userLabel;
    private TextField moneyField;

    private User current;

    public void initialize() {
        tableID.setItems(FXCollections.observableArrayList(RaceService.getR()));
        driverColumn.setCellValueFactory(new PropertyValueFactory<Race, String>("Driver"));
        raceColumn.setCellValueFactory(new PropertyValueFactory<Race, String>("Race"));
        kmColumn.setCellValueFactory(new PropertyValueFactory<Race, Integer>("km"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Race, Integer>("price"));

        ArrayList<User> u = UserService.getU();
        for (User i : u) {
            if (i.isLogged() && i.getRole().equals("Client"))
                current = i;
        }

        userLabel.setText(String.valueOf(current.getUsername()));
        creditLabel.setText(String.valueOf(current.getCredit()));
    }

    public void logOut() {
        try {
            current.setLogged(false);
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("LogRegMenu.fxml"));
            stage.setTitle("Menu");
            stage.setScene(new Scene(ceva, 600, 600));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void addMoney() {
        current.setCredit(current.getCredit() + Integer.parseInt(moneyField.getText()));
        this.initialize();
    }
}
