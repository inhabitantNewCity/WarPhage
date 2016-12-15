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


    private Random random = new Random();
    private int numberCores = MIN_CORES_ON_FIELD + random.nextInt(MAX_CORES_ON_FIELD - MIN_CORES_ON_FIELD + 1) ;
    private int numberBigCores = 1 + random.nextInt(numberCores) ;
    private List<Core> cores = new LinkedList<>();
    @Override
    public Field generate() {

        Field field = new FieldSimple();
        field.initializing(generatingCores());
        return field;

    }

    private List<Core> generatingCores(){

        for(int i = 0; i < numberCores; i++ ){
            Core core = new Core(StateCore.BLACK);
            generateLocation(core);
            generateSize(core, i);
            core.setId(i);
            cores.add(core);
        }

        return cores;
    }

    private void generateSize(Core core, int numberStep) {
        if(numberStep < numberBigCores)
            core.setSize(SizeCore.BIG_CORE);
        else
            core.setSize(SizeCore.SMALL_CORE);
    }

    private void generateLocation(Core core) {
        Point2D location = new Point2D();
        do{
            location.x = (OFFSET + SIZE_BIG_CORE / 2) + random.nextInt(SIZE_OF_FIELD_X - 2 * (SIZE_BIG_CORE / 2 + OFFSET) + 1);
            location.y = (OFFSET + SIZE_BIG_CORE / 2) + random.nextInt(SIZE_OF_FIELD_Y - 2 * (SIZE_BIG_CORE / 2 + OFFSET) + 1);
        }while(PointInBoxChecker.isPointInBox(location.x, location.y, cores));

        core.setLocation(location);
    }

    static private class PointInBoxChecker {

        public static boolean isPointInBox(float x, float y, List<Core> space){
            for(Core core : space){
                if(((core.getLocation().x - SIZE_BIG_CORE <= x) && (core.getLocation().x + SIZE_BIG_CORE >= x)) &&
                        ((core.getLocation().y - SIZE_BIG_CORE <= y) && (core.getLocation().y + SIZE_BIG_CORE >= y)))
                    return true;
            }
            return false;
        }
    }

}
