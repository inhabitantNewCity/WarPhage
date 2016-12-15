package com.games.java.model.utils;

/**
 * Created by Tmp on 09.12.2016.
 */
import static com.games.java.model.utils.Constants.*;
public enum SizeCore {
    BIG_CORE, SMALL_CORE;

    public int getSize(){
        switch (this){
            case BIG_CORE: return SIZE_BIG_CORE;
            default: SMALL_CORE: return SIZE_SMALL_CORE;
        }
    }
}
