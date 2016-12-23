package com.games.java.model.players;

import com.games.java.controllers.Controller;
import com.games.java.model.players.corba.idls.game.Core;
import com.games.java.model.players.corba.idls.game.PlayerPOA;
import com.games.java.model.players.corba.idls.game.StateCore;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

/**
 * Created by Tmp on 11.12.2016.
 */
//todo: create necessary functianality for User, this entity should manage madel
//todo: update view though controller
public class CurrentPlayer extends PlayerPOA implements Player {


    private Controller controller;
    private Core previousSelectedCore;
    private StateCore state;
    private String fieldName;
    private String name;

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


    @Override
    public void updateCoreView(Core core) {
        controller.updateFieldView(core);

    }

    @Override
    public void setFieldName(String name) {
       this.fieldName = name;
    }

    @Override
    public void setPlayerName(String name) {
        this.name = name;
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public void setState(StateCore state) {
        this.state = state;
    }

    @Override
    public String getFieldName() {
        return fieldName;
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
