package com.games.java.controllers.listeners;

import com.games.java.controllers.Controller;


import com.games.java.model.players.corba.idls.game.Core;
import com.games.java.model.players.corba.idls.game.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

/**
 * Created by Tmp on 11.12.2016.
 */
public class OncClickCoreListener implements EventHandler<MouseEvent> {

    private Controller controller;

    public OncClickCoreListener(Controller controller) {
        this.controller = controller;
    }
    //todo: add work with external user
    @Override
    public void handle(MouseEvent event) {

        Core core = controller.getCorrectCore((Group) event.getSource());
        Player player = controller.getPlayer();
        Player enemy = controller.getEnemy();

        //player.setController(controller);
        //enemy.setController(controller);

        player.calculateChanges(core);
        //enemy.calculateChanges(core);
    }
}
