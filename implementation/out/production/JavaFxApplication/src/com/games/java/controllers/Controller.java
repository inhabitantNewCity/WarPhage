package com.games.java.controllers;

import com.games.java.model.field.Core;
import com.games.java.model.players.Player;
import javafx.scene.Group;

/**
 * Created by Tmp on 12.12.2016.
 */
public interface Controller {

    void updateFieldView(Core core);

    Core getCorrectCore(Group view);
    Player getPlayer();
    Player getEnemy();
}
