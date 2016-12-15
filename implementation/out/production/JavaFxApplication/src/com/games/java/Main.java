package com.games.java;

import com.games.java.controllers.SeterAnimation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// todo: add new window for registration and connect with other user
// todo: add class for set field after connection and getting external user
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxmls/initial.fxml"));
        primaryStage.setTitle("War Phage");

        //SeterAnimation animation = SeterAnimation.getInstance();
        //animation.set().play();

        Scene scene = new Scene(root, 360, 400);
        scene.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
