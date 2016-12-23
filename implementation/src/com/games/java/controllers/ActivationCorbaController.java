package com.games.java.controllers;


import com.games.java.controllers.connections.ConnectionFactory;
import com.games.java.model.players.corba.idls.game.Field;
import com.games.java.model.players.corba.idls.game.Player;
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
    public void initialize(){
        //ConnectionFactory.getConnection()
    }

    @FXML
    public void createCorbaSettingsListeners(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage)((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        //Player player = ConnectionFactory.getConnection().getPlayerOne();
        //Player playerEnemy = ConnectionFactory.getConnection().getPlayerEnemy();
        //Field field = ConnectionFactory.getConnection().getField();

        //Controller controller = new StartController();
        //controller.setField(field);
        //controller.setPlayer(player);
        //controller.setEnemy(playerEnemy);

        //loader.setController(controller);
        Parent root = loader.load(getClass().getResource("/fxmls/sample.fxml"));

        //controller.setPlayer(player);
        primaryStage.setTitle("War Phage");

        SeterAnimation animation = SeterAnimation.getInstance();
        animation.set().play();
        ((Controller)loader.getController()).startGame();

        Scene scene = new Scene(root, 920, 460);

        scene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);


        primaryStage.show();
    }
}
