package com.games.java.model.players;

import com.games.java.controllers.Controller;
import com.games.java.model.field.Core;
import com.games.java.model.utils.StateCore;

/**
 * Created by Tmp on 11.12.2016.
 */
//todo: create necessary functianality for User, this entity should manage madel
//todo: update view though controller
public class CurrentPlayer implements Player {


    private Controller controller;
    private Core previousSelectedCore;
    private StateCore state;

    public CurrentPlayer(StateCore state){
        this.state = state;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void calculateChanges(Core core) {
        if(previousSelectedCore == null){
            previousSelectedCore = core;
            return;
        }
        if((previousSelectedCore == core)
                || (previousSelectedCore.getState() == StateCore.BLACK)
                || (previousSelectedCore.getState() != state)) {

            previousSelectedCore = null;
            return;
        }
        core.updateCores(previousSelectedCore);
        controller.updateFieldView(core);
        previousSelectedCore = null;
    }

    @Override
    public StateCore getState() {
        return state;
    }

}
