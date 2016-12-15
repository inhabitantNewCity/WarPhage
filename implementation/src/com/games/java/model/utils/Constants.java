package com.games.java.model.utils;

import org.omg.CORBA.ORB;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Tmp on 09.12.2016.
 */
public class Constants {

        public static int MAX_CORES_ON_FIELD = 10;
        public static int MIN_CORES_ON_FIELD = 3;
        public static int SIZE_OF_FIELD_X = 450;
        public static int SIZE_OF_FIELD_Y = 250;
        public static int SIZE_BIG_CORE = 80;
        public static int SIZE_SMALL_CORE = 40;
        public static int OFFSET = 10;

        public static Map<SizeCore, String> IMAGE_CORES = new HashMap<SizeCore, String>(){
        {
            put(SizeCore.BIG_CORE,   "/images/core_black.png");
            put(SizeCore.SMALL_CORE, "/images/small_core.png");
        }};

        public static Map<StateCore, String> IMAGE_CORES_BY_STATUS = new HashMap<StateCore, String>(){
        {
            put(StateCore.GREEN,   "/images/core_green.png");
            put(StateCore.RED, "/images/core_red.png");
        }};

        public static String NAME_CORE_IMAGE_VIEW_ID = "coreImageView";
        public static String NAME_CORE_LABEL_ID = "coreLabel";
        public static String NAME_CORES_GROUP_ID = "coresGroup";

        public static String BACKGROUND_ANIMATOR_ID = "background";
        public static int COUNT_START_PHAGE = 100;
        public static int UPDATE_CURRENT_COUNT_PHAGE_DELAY = 1;
        public static int COUNT_ADDED_PHAGE = 10;

        public static Properties corbaStartProp = new Properties();
        static {
            corbaStartProp.put("org.omg.CORBA.ORBInitialPort", "1050");
            corbaStartProp.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        }
        ORB orb = ORB.init(new String[2], new Properties());
}
