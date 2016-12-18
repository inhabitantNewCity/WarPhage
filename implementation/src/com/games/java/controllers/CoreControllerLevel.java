package com.games.java.controllers;

import com.games.java.model.players.corba.idls.game.Core;
import com.games.java.model.players.corba.idls.game.StateCore;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.games.java.model.utils.Constants.*;
/**
 * Created by Tmp on 13.12.2016.
 */
public class CoreControllerLevel {

    private Group coreView;
    private Core modelCore;
    private ImageView imageView;
    private Label label;
    private StateCore currentState;

    private int id;

    public CoreControllerLevel(Group coreView, Core coreModel){
        this.coreView = coreView;
        this.modelCore = coreModel;
        this.id = coreModel.getId();

        label = (Label) coreView.getChildren().get(1);
        currentState = coreModel.getState();

        ImageView imageView = (ImageView) coreView.getChildren().get(0);
        this.imageView = imageView;
    }

    public Group getCoreView() {
        return coreView;
    }

    public void setCoreView(Group coreView) {
        this.coreView = coreView;
    }

    public Core getModelCore() {
        return modelCore;
    }

    public void setModelCore(Core modelCore) {
        this.modelCore = modelCore;
    }

    public boolean isCorrectCore(Group view){
        return view == coreView;
    }

    public void setImage(Image image){
        imageView.setImage(image);
    }

    public int getId() {
        return id;
    }

    public void updateView(){
        label.setText(modelCore.getCountPhage() + "");
        if(currentState != modelCore.getState()){
            Image image = new Image(this.getClass().getResource(IMAGE_CORES_BY_STATUS.get(modelCore.getState())).toExternalForm());
            setImage(image);
        }
    }
}

