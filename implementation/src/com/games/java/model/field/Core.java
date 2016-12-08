package com.games.java.model.field;

import com.games.java.model.utils.SizeCore;
import com.games.java.model.utils.StateCore;
import com.sun.javafx.geom.Point2D;

/**
 * Created by Tmp on 04.12.2016.
 */
public class Core {

    private Point2D location;
    private Number userId;
    private StateCore state;
    private SizeCore size;

    public Core(StateCore state) {
        this.state = state;
    }

    public SizeCore getSize() {
        return size;
    }

    public void setSize(SizeCore size) {
        this.size = size;
    }

    public Number getUserId() {
        return userId;
    }

    public void setUserId(Number userId) {
        this.userId = userId;
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }



}
