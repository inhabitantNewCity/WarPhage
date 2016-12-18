package com.games.java.model.players;

import com.games.java.controllers.Controller;

/**
 * Created by Tmp on 04.12.2016.
 */
public interface Player extends com.games.java.model.players.corba.idls.game.Player {
    //todo: add method for update core
    //todo: add method for set controller

    void setController(Controller controller);
}
