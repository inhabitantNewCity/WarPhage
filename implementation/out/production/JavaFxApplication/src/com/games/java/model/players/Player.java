package com.games.java.model.players;

import com.games.java.controllers.Controller;
import com.games.java.model.field.Core;
import com.games.java.model.utils.StateCore;

/**
 * Created by Tmp on 04.12.2016.
 */
public interface Player {
    //todo: add method for update core
    //todo: add method for set controller

    void setController(Controller controller);
    void calculateChanges(Core core);
    StateCore getState();
}
