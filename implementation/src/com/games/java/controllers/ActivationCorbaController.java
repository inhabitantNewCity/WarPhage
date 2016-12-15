package com.games.java.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Tmp on 14.12.2016.
 */
public class ActivationCorbaController  {

    @FXML
    private Button button;

    @FXML
    private TextField namePlaer;

    @FXML
    public void createCorbaSettingsListeners(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Button) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/sample.fxml"));
        primaryStage.setTitle("War Phage");

        SeterAnimation animation = SeterAnimation.getInstance();
        animation.set().play();

        Scene scene = new Scene(root, 920, 460);
        scene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);


        primaryStage.show();
    }
}
