package com.games.java.model.players.corba.idls.game;

/**
* com/games/java/model/players/corba/idls/game/Point2DHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 19:18:29 MSK
*/

public final class Point2DHolder implements org.omg.CORBA.portable.Streamable
{
  public com.games.java.model.players.corba.idls.game.Point2D value = null;

  public Point2DHolder ()
  {
  }

  public Point2DHolder (com.games.java.model.players.corba.idls.game.Point2D initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.games.java.model.players.corba.idls.game.Point2DHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.games.java.model.players.corba.idls.game.Point2DHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.games.java.model.players.corba.idls.game.Point2DHelper.type ();
  }

}
