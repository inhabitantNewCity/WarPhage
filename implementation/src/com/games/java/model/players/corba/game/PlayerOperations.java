package com.games.java.model.players.corba.game;


/**
* com/games/java/model/players/corba/game/PlayerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:30 MSK
*/

public interface PlayerOperations 
{
  void calculateChanges (com.games.java.model.players.corba.game.Core core);
  void updateCoreView (com.games.java.model.players.corba.game.Core core);
  void setPlayerName (String name);
  String getPlayerName ();
  void setState (com.games.java.model.players.corba.game.StateCore state);
  com.games.java.model.players.corba.game.StateCore getState ();
  void setFieldName (String name);
  String getFieldName ();
} // interface PlayerOperations
