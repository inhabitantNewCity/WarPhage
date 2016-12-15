package com.games.java.controllers.animation;

import javafx.animation.Transition;
import javafx.scene.Node;

/**
 * Created by Tmp on 10.12.2016.
 */
public interface Animator {
    Transition getTransition (Node element);
}
