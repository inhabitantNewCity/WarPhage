package game;

/**
* game/StateCoreHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 14:50:36 MSK
*/

public final class StateCoreHolder implements org.omg.CORBA.portable.Streamable
{
  public game.StateCore value = null;

  public StateCoreHolder ()
  {
  }

  public StateCoreHolder (game.StateCore initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = game.StateCoreHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    game.StateCoreHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return game.StateCoreHelper.type ();
  }

}
