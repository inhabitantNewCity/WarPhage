package game;

/**
* game/Point2DHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 14:50:36 MSK
*/

public final class Point2DHolder implements org.omg.CORBA.portable.Streamable
{
  public game.Point2D value = null;

  public Point2DHolder ()
  {
  }

  public Point2DHolder (game.Point2D initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = game.Point2DHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    game.Point2DHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return game.Point2DHelper.type ();
  }

}