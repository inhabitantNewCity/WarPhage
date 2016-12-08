package com.games.java.model.field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tmp on 04.12.2016.
 */
public class FieldSimple implements Field {

    private List<Core> cores = new ArrayList<>();

    @Override
    public void initializing(List<Core> list) {
       cores = list;
    }
}
