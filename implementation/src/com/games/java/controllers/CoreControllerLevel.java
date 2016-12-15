package com.games.java.controllers;

import com.games.java.model.field.Core;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private int id;

    public CoreControllerLevel(Group coreView, Core coreModel){
        this.coreView = coreView;
        this.modelCore = coreModel;
        this.id = coreModel.getId();

        Label label = (Label) coreView.getChildren().get(1);
        label.textProperty().bind(Bindings.convert(coreModel.getCountPhage()));

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

}

