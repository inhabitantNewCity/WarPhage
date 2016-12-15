package com.games.java.model.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tmp on 09.12.2016.
 */
public interface Constants {

        int MAX_CORES_ON_FIELD = 10;
        int MIN_CORES_ON_FIELD = 3;
        int SIZE_OF_FIELD_X = 450;
        int SIZE_OF_FIELD_Y = 250;
        int SIZE_BIG_CORE = 80;
        int SIZE_SMALL_CORE = 40;
        int OFFSET = 10;

        Map<SizeCore, String> IMAGE_CORES = new HashMap<SizeCore, String>(){
        {
            put(SizeCore.BIG_CORE,   "/images/core_black.png");
            put(SizeCore.SMALL_CORE, "/images/small_core.png");
        }};

        Map<StateCore, String> IMAGE_CORES_BY_STATUS = new HashMap<StateCore, String>(){
        {
            put(StateCore.GREEN,   "/images/core_green.png");
            put(StateCore.RED, "/images/core_red.png");
        }};

        String NAME_CORE_IMAGE_VIEW_ID = "coreImageView";
        String NAME_CORE_LABEL_ID = "coreLabel";
        String NAME_CORES_GROUP_ID = "coresGroup";

        String BACKGROUND_ANIMATOR_ID = "background";
        int COUNT_START_PHAGE = 100;
        int UPDATE_CURRENT_COUNT_PHAGE_DELAY = 1;
        int COUNT_ADDED_PHAGE = 10;


}
