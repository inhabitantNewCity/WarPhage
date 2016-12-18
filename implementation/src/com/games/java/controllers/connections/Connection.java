package com.games.java.controllers.connections;

import com.games.java.model.players.Player;

/**
 * Created by Tmp on 16.12.2016.
 */
public interface Connection {

    boolean IsMainPlayer();
    Player getPlayerOne();
    Player getPlayerEnemy();
}
