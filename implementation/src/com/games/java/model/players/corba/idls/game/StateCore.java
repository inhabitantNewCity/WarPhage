package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/StateCore.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

public class StateCore implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static com.games.java.model.players.corba.idls.game.StateCore[] __array = new com.games.java.model.players.corba.idls.game.StateCore [__size];

  public static final int _RED = 0;
  public static final com.games.java.model.players.corba.idls.game.StateCore RED = new com.games.java.model.players.corba.idls.game.StateCore(_RED);
  public static final int _GREEN = 1;
  public static final com.games.java.model.players.corba.idls.game.StateCore GREEN = new com.games.java.model.players.corba.idls.game.StateCore(_GREEN);
  public static final int _BLACK = 2;
  public static final com.games.java.model.players.corba.idls.game.StateCore BLACK = new com.games.java.model.players.corba.idls.game.StateCore(_BLACK);

  public int value ()
  {
    return __value;
  }

  public static com.games.java.model.players.corba.idls.game.StateCore from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected StateCore (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class StateCore
