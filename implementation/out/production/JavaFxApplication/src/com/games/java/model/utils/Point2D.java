package com.games.java.model.utils;

import com.games.java.model.players.corba.idls.game.Point2DPOA;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

/**
 * Created by Tmp on 17.12.2016.
 */
public class Point2D extends Point2DPOA implements com.games.java.model.players.corba.idls.game.Point2D{

    private double x;
    private double y;

    public Point2D(){}
    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
