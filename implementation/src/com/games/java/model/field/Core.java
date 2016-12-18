package com.games.java.model.field;

import com.games.java.model.players.corba.idls.game.CorePOA;
import com.games.java.model.players.corba.idls.game.Point2D;
import com.games.java.model.players.corba.idls.game.SizeCore;
import com.games.java.model.players.corba.idls.game.StateCore;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

/**
 * Created by Tmp on 04.12.2016.
 */
public class Core extends CorePOA implements com.games.java.model.players.corba.idls.game.Core {

    private int id;
    private Point2D location;
    private StateCore state;
    private SizeCore size;
    private IntegerProperty countPhage = new SimpleIntegerProperty();

    public Core(StateCore state) {
        this.state = state;
    }

    public SizeCore getSize() {
        return size;
    }

    public void setSize(SizeCore size) {
        this.size = size;
    }


    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountPhage() {
        return countPhage.intValue();
    }

    public void setCountPhage(int countPhage) {
        this.countPhage.setValue(countPhage);
    }

    @Override
    public void updateCores(com.games.java.model.players.corba.idls.game.Core sourceCore) {
        int currentCountPhage = this.getCountPhage();
        int countPhage = sourceCore.getCountPhage() / 2;
        if (sourceCore.getState() == state) {
            this.countPhage.setValue(currentCountPhage + countPhage);
        } else {
            if (currentCountPhage - countPhage <= 0) {
                state = sourceCore.getState();
                this.countPhage.setValue(countPhage - currentCountPhage);
            } else {
                this.countPhage.setValue(currentCountPhage - countPhage);
            }
        }
    }

    public StateCore getState() {
        return state;
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
