package com.games.java.model.field;

import java.util.List;

/**
 * Created by Tmp on 04.12.2016.
 */
public interface Field extends com.games.java.model.players.corba.idls.game.Field {

    void initializing(List<Core> list);

    void startGame();
    int getCountCores();
    void stopGame();


}
