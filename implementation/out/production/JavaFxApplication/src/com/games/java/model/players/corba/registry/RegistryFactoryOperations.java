package com.games.java.model.players.corba.registry;


/**
* com/games/java/model/players/corba/registry/RegistryFactoryOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:30 MSK
*/

public interface RegistryFactoryOperations 
{
  void registry (com.games.java.model.players.corba.game.Player player);
  String getCurrentName ();
  String getPlayerOne ();
  String getPlayerEnemy ();
} // interface RegistryFactoryOperations
