package org.fis.maven;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis.maven.Services.AdminService;
import org.fis.maven.Services.PriceService;


public class Main extends Application{

    public static void main (String[] args){
        // Logger LOGGER = LoggerFactory.getLogger(Main.class);

        // LOGGER.trace("This is a TRACE log");
        // LOGGER.debug("This is a DEBUG log");
        // LOGGER.info("This is an INFO log");
        // LOGGER.warn("This is a WARN log");
        // LOGGER.error("This is an ERROR log");
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //ClientService.loadClients();
        //AdminService.loadPrice();
        //DriverService.loadDrivers();
        PriceService.setPath("src/main/resources/Price.json");
        AdminService.setPath("src/main/resources/Admin.json");

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdminSetPrice.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.show();

    }


}