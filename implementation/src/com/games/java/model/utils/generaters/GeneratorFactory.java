package com.games.java.model.utils.generaters;

/**
 * Created by Tmp on 04.12.2016.
 */
public class GeneratorFactory {

    private static GeneratorFactory factory = new GeneratorFactory();
    private Generator[] generators = { new SimpleGenerator()};

    public static GeneratorFactory getInstance(){
        return factory;
    }

    public Generator getGenerator(){
        return generators[0];
    }

}
