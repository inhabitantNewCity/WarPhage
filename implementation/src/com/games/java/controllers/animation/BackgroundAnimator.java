package com.games.java.controllers.animation;

import javafx.animation.Transition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Created by Tmp on 10.12.2016.
 */
public class BackgroundAnimator implements Animator {
    private static final Duration DURATION_ANIMATION = Duration.INDEFINITE;
    private static final Duration DURATION_DELAY = Duration.millis(100);

    @Override
    public Transition getTransition(Node element) {

        TranslateTransition firstTransition = new TranslateTransition(Duration.millis(200), element);
        firstTransition.setFromX(element.getLayoutX());
        firstTransition.setFromY(element.getLayoutY());
        firstTransition.setToX(element.getTranslateX() + 2);
        firstTransition.setToY(element.getTranslateY() + 2);
        firstTransition.setAutoReverse(true);
        firstTransition.setCycleCount(2);
        firstTransition.setDelay(DURATION_DELAY);

        TranslateTransition secondTransition = new TranslateTransition(Duration.millis(200), element);
        secondTransition.setFromX(element.getLayoutX());
        secondTransition.setFromY(element.getLayoutY());
        secondTransition.setToX(element.getTranslateX() - 2);
        secondTransition.setToY(element.getTranslateY() + 2);
        secondTransition.setAutoReverse(true);
        secondTransition.setCycleCount(2);
        secondTransition.setDelay(DURATION_DELAY);

        SequentialTransition sequentialTransition = new SequentialTransition(element, firstTransition, secondTransition);
        sequentialTransition.setDelay(DURATION_DELAY);
        sequentialTransition.setCycleCount(1000000000);

        return sequentialTransition;
    }
}
