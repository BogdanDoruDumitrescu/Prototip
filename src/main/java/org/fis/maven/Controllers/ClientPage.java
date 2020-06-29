package org.fis.maven.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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

    @FXML
    private Button logoutButton;
    @FXML
    private javafx.scene.control.TableView<Race> tableID;
    @FXML
    private javafx.scene.control.TableColumn<Race, String> driverColumn;
    @FXML
    private javafx.scene.control.TableColumn<Race, String> statusColumn;
    @FXML
    private javafx.scene.control.TableColumn<Race, Integer> kmColumn;
    @FXML
    private javafx.scene.control.TableColumn<Race, Integer> priceColumn;

    @FXML
    private Label creditLabel;
    @FXML
    private Label userLabel;
    @FXML
    private TextField moneyField;

    private static User current;

    public void initialize() {

        ArrayList<User> u = UserService.getU();
        for (User i : u) {
            if (i.isLogged() && i.getRole().equals("Client"))
                current = i;
        }

        ArrayList<Race> curse = new ArrayList<>();

        RaceService.loadRaces();

        for(Race i:RaceService.getR()){
            if(i.getClientUserName().equals(current.getUsername())){
                curse.add(i);
            }
        }

        tableID.setItems(FXCollections.observableArrayList(curse));
        driverColumn.setCellValueFactory(new PropertyValueFactory<Race, String>("driverUserName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Race, String>("state"));
        kmColumn.setCellValueFactory(new PropertyValueFactory<Race, Integer>("km"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Race, Integer>("totalPrice"));



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
        UserService.writeUser();
        this.initialize();
    }

    public void send(){
        try {
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("Request.fxml"));
            stage.setTitle("Request");
            stage.setScene(new Scene(ceva, 600, 600));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static User getCurrent() {
        return current;
    }
}
