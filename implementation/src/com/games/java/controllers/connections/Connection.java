package com.games.java.controllers.connections;


import com.games.java.model.players.corba.idls.game.Field;
import com.games.java.model.players.corba.idls.game.Player;

/**
 * Created by Tmp on 16.12.2016.
 */
public interface Connection {

    boolean isMainPlayer();
    com.games.java.model.players.Player getPlayerOne() ;
    Player getPlayerEnemy();

    Field getField();
}
