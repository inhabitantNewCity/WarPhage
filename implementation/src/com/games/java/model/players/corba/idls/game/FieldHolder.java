package com.games.java.model.players.corba.idls.game;

/**
* com/games/java/model/players/corba/idls/game/FieldHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

public final class FieldHolder implements org.omg.CORBA.portable.Streamable
{
  public com.games.java.model.players.corba.idls.game.Field value = null;

  public FieldHolder ()
  {
  }

  public FieldHolder (com.games.java.model.players.corba.idls.game.Field initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.games.java.model.players.corba.idls.game.FieldHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.games.java.model.players.corba.idls.game.FieldHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.games.java.model.players.corba.idls.game.FieldHelper.type ();
  }

}