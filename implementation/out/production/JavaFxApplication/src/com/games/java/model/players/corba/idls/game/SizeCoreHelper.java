package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/SizeCoreHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

abstract public class SizeCoreHelper
{
  private static String  _id = "IDL:game/SizeCore:1.0";

  public static void insert (org.omg.CORBA.Any a, com.games.java.model.players.corba.idls.game.SizeCore that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.games.java.model.players.corba.idls.game.SizeCore extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (com.games.java.model.players.corba.idls.game.SizeCoreHelper.id (), "SizeCore", new String[] { "BIG_CORE", "SMALL_CORE"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.games.java.model.players.corba.idls.game.SizeCore read (org.omg.CORBA.portable.InputStream istream)
  {
    return com.games.java.model.players.corba.idls.game.SizeCore.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.games.java.model.players.corba.idls.game.SizeCore value)
  {
    ostream.write_long (value.value ());
  }

}
