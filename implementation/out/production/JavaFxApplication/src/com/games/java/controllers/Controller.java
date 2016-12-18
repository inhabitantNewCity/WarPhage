package com.games.java.controllers;


import com.games.java.model.players.Player;
import com.games.java.model.players.corba.idls.game.Core;
import javafx.scene.Group;

/**
 * Created by Tmp on 12.12.2016.
 */
public interface Controller {

    void updateFieldView(Core core);

    Core getCorrectCore(Group view);

    Player getPlayer();
    Player getEnemy();

    void setPlayer(Player player);
    void setEnemy(Player player);

    void startGame();
}
