package com.games.java.model.field;


import com.games.java.model.players.corba.idls.game.FieldPOA;
import com.games.java.model.players.corba.idls.game.Player;
import com.games.java.model.players.corba.idls.game.StateCore;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.games.java.model.utils.Constants.COUNT_ADDED_PHAGE;
import static com.games.java.model.utils.Constants.UPDATE_CURRENT_COUNT_PHAGE_DELAY;

/**
 * Created by Tmp on 04.12.2016.
 */
public class FieldSimple extends FieldPOA implements Field {

    private List<Core> cores = new ArrayList<Core>();
    private Player playerOne;
    private Player playerEnemy;
    private Timeline timer;
    private Iterator<Core> iterator;

    public FieldSimple(){
        timer = new Timeline(new KeyFrame(Duration.seconds(UPDATE_CURRENT_COUNT_PHAGE_DELAY), ev -> {
            for (Core core: cores) {
                if (core.getState() != StateCore.BLACK) {
                    core.setCountPhage(core.getCountPhage() + COUNT_ADDED_PHAGE);
                    playerOne.updateCoreView(core);
                    playerEnemy.updateCoreView(core);
                }
            }
        }));
        timer.setCycleCount(Animation.INDEFINITE);
    }

    @Override
    public void initializing(List<Core> cores) {
       this.cores = cores;
       iterator = cores.iterator();
    }

    public Core coreNext(int i){
       return cores.get(i);
    }

    public void startGame(){
       timer.play();
    }

    @Override
    public int getCountCores() {
        return cores.size();
    }

    public void stopGame()
    {
        timer.stop();
    }

    @Override
    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }

    @Override
    public void setPlayerEnemy(Player player) {
        this.playerEnemy = player;
    }

    @Override
    public boolean _is_equivalent(org.omg.CORBA.Object other) {
        return false;
    }

    @Override
    public int _hash(int maximum) {
        return 0;
    }

    @Override
    public Object _duplicate() {
        return null;
    }

    @Override
    public void _release() {

    }

    @Override
    public Request _request(String operation) {
        return null;
    }

    @Override
    public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result) {
        return null;
    }

    @Override
    public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result, ExceptionList exclist, ContextList ctxlist) {
        return null;
    }

    @Override
    public Policy _get_policy(int policy_type) {
        return null;
    }

    @Override
    public DomainManager[] _get_domain_managers() {
        return new DomainManager[0];
    }

    @Override
    public Object _set_policy_override(Policy[] policies, SetOverrideType set_add) {
        return null;
    }
}
