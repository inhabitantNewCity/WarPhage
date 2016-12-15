package com.games.java.model.field;

import com.games.java.controllers.CoreControllerLevel;
import com.games.java.model.utils.SizeCore;
import com.games.java.model.utils.StateCore;
import com.sun.javafx.geom.Point2D;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import static com.games.java.model.utils.Constants.*;

/**
 * Created by Tmp on 04.12.2016.
 */
public class Core {

    private int id;
    private Point2D location;
    private StateCore state;
    private SizeCore size;
    private IntegerProperty countPhage = new SimpleIntegerProperty();

    private CoreControllerLevel core;
    private Timeline timer;

    public Core(StateCore state) {
        this.state = state;
        timer = new Timeline(new KeyFrame(Duration.seconds(UPDATE_CURRENT_COUNT_PHAGE_DELAY), ev -> {
            countPhage.setValue(countPhage.intValue() + COUNT_ADDED_PHAGE);
        }));
        timer.setCycleCount(Animation.INDEFINITE);
    }

    public SizeCore getSize() {
        return size;
    }

    public void setSize(SizeCore size) {
        this.size = size;
    }


    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IntegerProperty getCountPhage() {
        return countPhage;
    }

    public void setCountPhage(int countPhage) {
        this.countPhage.setValue(countPhage);
    }


    public CoreControllerLevel getCore() {
        return core;
    }

    public void setCore(CoreControllerLevel core) {
        this.core = core;
    }

    public void updateCores(Core sourceCore){
        int currentCountPhage = this.getCountPhage().getValue();
        int countPhage = sourceCore.getCountPhage().getValue() / 2;
        if(sourceCore.getState() == state) {
            this.countPhage.setValue(currentCountPhage + countPhage);
        } else {
            if (currentCountPhage - countPhage <= 0){
                state = sourceCore.getState();
                this.countPhage.setValue(countPhage - currentCountPhage);
            } else {
                this.countPhage.setValue(currentCountPhage - countPhage);
            }
        }
        timer.stop();
        timer.play();
    }

    public StateCore getState() {
        return state;
    }
}
