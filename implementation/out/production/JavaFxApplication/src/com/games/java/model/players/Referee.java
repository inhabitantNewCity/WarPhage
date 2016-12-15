package com.games.java.model.players;

import com.games.java.model.field.Core;
import com.games.java.model.field.Field;
import com.games.java.model.utils.StateCore;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tmp on 13.12.2016.
 */
public class Referee {

    private Field field;
    private List<Core> cores;
    private Player[] players = new Player[2];
    private Player winerPlayer;

    public Referee(Field field, Player currentPlayer, Player enemyPlayer) {
        this.field = field;
        this.cores = field.getCores();
        this.players[0] = currentPlayer;
        this.players[1] = enemyPlayer;
    }

    public boolean checkVictory(){
       for(Player player : players){
           if(checkVictoryForPlayerByStatus(player.getState()))
               return true;
       }
       return false;
    }

    public Player getWiner(){
        return winerPlayer;
    }

    private boolean checkVictoryForPlayerByStatus(StateCore status){
        for(Core core : cores){
           if(core.getState() != status)
               return false;
        }
        for(Player player : players){
            if(player.getState() == status){
                winerPlayer = player;
            }
        }
        return true;
    }
}
