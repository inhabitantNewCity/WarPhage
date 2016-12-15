package com.games.java.model.field;

import com.games.java.controllers.Controller;

import java.util.List;

/**
 * Created by Tmp on 04.12.2016.
 */
public interface Field {

    void initializing(List<Core> list);
    List<Core> getCores();
    void addCore( Core core);
    void setController(Controller controller);

}
