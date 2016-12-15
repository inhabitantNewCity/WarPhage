package com.games.java.model.field;

import com.games.java.controllers.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tmp on 04.12.2016.
 */
public class FieldSimple implements Field {

    private Controller controller;
    private List<Core> cores = new ArrayList<>();

    @Override
    public void initializing(List<Core> list) {
       cores = list;
    }

    @Override
    public List<Core> getCores() {
       return cores;
    }

    @Override
    public void addCore(Core core) {
        cores.add(core);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
