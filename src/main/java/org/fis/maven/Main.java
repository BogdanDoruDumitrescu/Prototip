package org.fis.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis.maven.Services.AdminService;
import org.fis.maven.Services.ClientService;
import org.fis.maven.Services.DriverService;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminSetPrice.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main (String[] args){
        Logger LOGGER = LoggerFactory.getLogger(Main.class);

        LOGGER.trace("This is a TRACE log");
        LOGGER.debug("This is a DEBUG log");
        LOGGER.info("This is an INFO log");
        LOGGER.warn("This is a WARN log");
        LOGGER.error("This is an ERROR log");
        launch(args);


    }

}
