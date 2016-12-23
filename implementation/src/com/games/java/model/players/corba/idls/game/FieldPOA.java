package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/FieldPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 19:18:29 MSK
*/

public abstract class FieldPOA extends org.omg.PortableServer.Servant
 implements com.games.java.model.players.corba.idls.game.FieldOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("coreNext", new java.lang.Integer (0));
    _methods.put ("startGame", new java.lang.Integer (1));
    _methods.put ("getCountCores", new java.lang.Integer (2));
    _methods.put ("stopGame", new java.lang.Integer (3));
    _methods.put ("setPlayerOne", new java.lang.Integer (4));
    _methods.put ("setPlayerEnemy", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // game/Field/coreNext
       {
         com.games.java.model.players.corba.idls.game.Core $result = null;
         int i = in.read_ulong();
         $result = this.coreNext (i);
         out = $rh.createReply();
         com.games.java.model.players.corba.idls.game.CoreHelper.write (out, $result);
         break;
       }

       case 1:  // game/Field/startGame
       {
         this.startGame ();
         out = $rh.createReply();
         break;
       }

       case 2:  // game/Field/getCountCores
       {
         int $result = (int)0;
         $result = this.getCountCores ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       case 3:  // game/Field/stopGame
       {
         this.stopGame ();
         out = $rh.createReply();
         break;
       }

       case 4:  // game/Field/setPlayerOne
       {
         com.games.java.model.players.corba.idls.game.Player player = com.games.java.model.players.corba.idls.game.PlayerHelper.read (in);
         this.setPlayerOne (player);
         out = $rh.createReply();
         break;
       }

       case 5:  // game/Field/setPlayerEnemy
       {
         com.games.java.model.players.corba.idls.game.Player player = com.games.java.model.players.corba.idls.game.PlayerHelper.read (in);
         this.setPlayerEnemy (player);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:game/Field:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Field _this() 
  {
    return FieldHelper.narrow(
    super._this_object());
  }

  public Field _this(org.omg.CORBA.ORB orb) 
  {
    return FieldHelper.narrow(
    super._this_object(orb));
  }


} // class FieldPOA
