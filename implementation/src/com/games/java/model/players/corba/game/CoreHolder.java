package com.games.java.model.players.corba.game;

/**
* com/games/java/model/players/corba/game/CoreHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:30 MSK
*/

public final class CoreHolder implements org.omg.CORBA.portable.Streamable
{
  public com.games.java.model.players.corba.game.Core value = null;

  public CoreHolder ()
  {
  }

  public CoreHolder (com.games.java.model.players.corba.game.Core initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.games.java.model.players.corba.game.CoreHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.games.java.model.players.corba.game.CoreHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.games.java.model.players.corba.game.CoreHelper.type ();
  }

}
