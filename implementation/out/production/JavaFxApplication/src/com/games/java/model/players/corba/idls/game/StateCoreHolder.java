package com.games.java.model.players.corba.idls.game;

/**
* com/games/java/model/players/corba/idls/game/StateCoreHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 19:18:29 MSK
*/

public final class StateCoreHolder implements org.omg.CORBA.portable.Streamable
{
  public com.games.java.model.players.corba.idls.game.StateCore value = null;

  public StateCoreHolder ()
  {
  }

  public StateCoreHolder (com.games.java.model.players.corba.idls.game.StateCore initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.games.java.model.players.corba.idls.game.StateCoreHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.games.java.model.players.corba.idls.game.StateCoreHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.games.java.model.players.corba.idls.game.StateCoreHelper.type ();
  }

}
