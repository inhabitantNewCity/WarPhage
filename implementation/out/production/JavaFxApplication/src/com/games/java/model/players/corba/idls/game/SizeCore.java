package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/SizeCore.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:54 MSK
*/

public class SizeCore implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static com.games.java.model.players.corba.idls.game.SizeCore[] __array = new com.games.java.model.players.corba.idls.game.SizeCore [__size];

  public static final int _BIG_CORE = 0;
  public static final com.games.java.model.players.corba.idls.game.SizeCore BIG_CORE = new com.games.java.model.players.corba.idls.game.SizeCore(_BIG_CORE);
  public static final int _SMALL_CORE = 1;
  public static final com.games.java.model.players.corba.idls.game.SizeCore SMALL_CORE = new com.games.java.model.players.corba.idls.game.SizeCore(_SMALL_CORE);

  public int value ()
  {
    return __value;
  }

  public static com.games.java.model.players.corba.idls.game.SizeCore from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected SizeCore (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class SizeCore
