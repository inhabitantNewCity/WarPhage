package com.games.java.controllers;

import com.games.java.controllers.animation.AnimationFactory;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;

import static com.games.java.model.utils.Constants.*;
/**
 * Created by Tmp on 11.12.2016.
 */
public class SeterAnimation {

    private Group coresGroup;

    private SeterAnimation(){};
    private static SeterAnimation instance = new SeterAnimation();
    public static SeterAnimation getInstance(){
        return instance;
    }

    public Transition set(){

        Transition transition = AnimationFactory.getAnimator(BACKGROUND_ANIMATOR_ID).getTransition(coresGroup);

        ParallelTransition parallelTransition = new ParallelTransition(coresGroup, transition);
        return parallelTransition;
    }

    public void setCoresGroup(Group coresGroup) {
        this.coresGroup = coresGroup;
    }
}
