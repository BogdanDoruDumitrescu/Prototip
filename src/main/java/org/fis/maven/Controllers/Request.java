package org.fis.maven.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.fis.maven.Models.Race;
import org.fis.maven.Models.User;
import org.fis.maven.Services.RaceService;
import org.fis.maven.Services.UserService;

import java.util.ArrayList;

public class Request {
    @FXML
    private Label priceLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private TextField kmField;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User,String> numeColumn;

    private int total=0;

    @FXML
    public void initialize(){
        ArrayList<User> soferi = new ArrayList<>();

        UserService.loadUser();
        for(User i: UserService.getU()){
            if(i.getRole().equals("Driver")&&i.getStatus().equals("Available")){
                soferi.add(i);
            }
        }

        table.setItems(FXCollections.observableArrayList(soferi));
        numeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        table.getSelectionModel().select(0);

        priceLabel.setText(String.valueOf(Race.getPricePerKm()));
        totalLabel.setText(String.valueOf(total));
    }

    @FXML
    public void backButton(){
        try{
            Stage stage=(Stage)totalLabel.getScene().getWindow();
            Parent ceva = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
            stage.setTitle("Login or Register Menu");
            stage.setScene(new Scene(ceva,800,600));
            stage.show();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void calcul(){
        int ppk = Race.getPricePerKm();
        int km = Integer.parseInt(kmField.getText());

        total = ppk*km;

        totalLabel.setText(String.valueOf(total));
    }

    @FXML
    public void send(){
        String numesofer = table.getSelectionModel().getSelectedItem().getUsername();
        String numeclient = ClientPage.getCurrent().getUsername();
        int km = Integer.parseInt(kmField.getText());
        int ppk = Race.getPricePerKm();

        this.calcul();

        RaceService.getR().add(new Race(numesofer, numeclient, km, total, "Pending"));
        RaceService.writeRace();

        this.backButton();
    }
}
