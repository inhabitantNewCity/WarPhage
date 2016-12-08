package com.games.java.model.utils.generaters;

import com.games.java.model.field.Core;
import com.games.java.model.field.Field;
import com.games.java.model.field.FieldSimple;
import com.games.java.model.utils.SizeCore;
import com.games.java.model.utils.StateCore;

import com.sun.javafx.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.games.java.model.utils.Constants.*;

/**
 * Created by Tmp on 04.12.2016.
 */
public class SimpleGenerator implements Generator {

    //TODO: excluded numbers <0
    private Random random = new Random();
    private int numberCores = 1 + random.nextInt() % MAX_CORES_ON_FIELD;
    private int numberBigCores = 1 + random.nextInt() % numberCores;

    @Override
    public Field generate() {

        Field field = new FieldSimple();
        field.initializing(generatingCores());
        return field;

    }

    private List<Core> generatingCores(){
        List<Core> cores = new LinkedList<>();

        for(int i = 0; i < numberCores; i++ ){
            Core core = new Core(StateCore.BLACK);
            generateLocation(core);
            generateSize(core, i);
            cores.add(core);
        }

        return cores;
    }

    private void generateSize(Core core, int numberStep) {
        if(numberStep < numberBigCores)
            core.setSize(SizeCore.BIG_CORE);
    }

    private void generateLocation(Core core) {
        Point2D location = new Point2D();

        location.x = (OFFSET + SIZE_BIG_CORE) + random.nextInt() % (SIZE_OF_FIELD_X - 2*(SIZE_BIG_CORE + OFFSET));
        location.y = (OFFSET + SIZE_BIG_CORE) + random.nextInt() % (SIZE_OF_FIELD_Y - 2*(SIZE_BIG_CORE + OFFSET));

        core.setLocation(location);
    }

}
