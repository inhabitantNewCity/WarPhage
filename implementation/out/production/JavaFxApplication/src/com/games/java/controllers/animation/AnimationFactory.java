package com.games.java.controllers.animation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tmp on 10.12.2016.
 */
//todo: add animation for move phage
public class AnimationFactory {
    private AnimationFactory(){}

    private static Map<String, Class<? extends Animator>> animators = new HashMap<String, Class<? extends Animator>>(){{
        put("background", BackgroundAnimator.class);
    }};

    public static Animator getAnimator(String key){
        Animator animator = null;
        try {
            animator = animators.get(key).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return animator;
    }
}
