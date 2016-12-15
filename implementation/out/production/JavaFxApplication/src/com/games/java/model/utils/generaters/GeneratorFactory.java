package com.games.java.model.utils.generaters;

/**
 * Created by Tmp on 04.12.2016.
 */
public class GeneratorFactory {

    private static Generator[] generators = { new SimpleGenerator()};
    private GeneratorFactory(){}

    public  static Generator getGenerator(){
        return generators[0];
    }

}
