package com.games.java.controllers.connections;

/**
 * Created by Tmp on 16.12.2016.
 */
public class ConnectionFactory {

    private static Connection[] connection = {new SimpleConnection()};

    public static Connection getConnection(){
        return connection[0];
    }
}
