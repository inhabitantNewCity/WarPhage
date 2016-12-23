package com.games.java.model.players.corba.game;


/**
* com/games/java/model/players/corba/game/PlayerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:30 MSK
*/

public abstract class PlayerPOA extends org.omg.PortableServer.Servant
 implements com.games.java.model.players.corba.game.PlayerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("calculateChanges", new java.lang.Integer (0));
    _methods.put ("updateCoreView", new java.lang.Integer (1));
    _methods.put ("setPlayerName", new java.lang.Integer (2));
    _methods.put ("getPlayerName", new java.lang.Integer (3));
    _methods.put ("setState", new java.lang.Integer (4));
    _methods.put ("getState", new java.lang.Integer (5));
    _methods.put ("setFieldName", new java.lang.Integer (6));
    _methods.put ("getFieldName", new java.lang.Integer (7));
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
       case 0:  // game/Player/calculateChanges
       {
         com.games.java.model.players.corba.game.Core core = com.games.java.model.players.corba.game.CoreHelper.read (in);
         this.calculateChanges (core);
         out = $rh.createReply();
         break;
       }

       case 1:  // game/Player/updateCoreView
       {
         com.games.java.model.players.corba.game.Core core = com.games.java.model.players.corba.game.CoreHelper.read (in);
         this.updateCoreView (core);
         out = $rh.createReply();
         break;
       }

       case 2:  // game/Player/setPlayerName
       {
         String name = in.read_wstring ();
         this.setPlayerName (name);
         out = $rh.createReply();
         break;
       }

       case 3:  // game/Player/getPlayerName
       {
         String $result = null;
         $result = this.getPlayerName ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 4:  // game/Player/setState
       {
         com.games.java.model.players.corba.game.StateCore state = com.games.java.model.players.corba.game.StateCoreHelper.read (in);
         this.setState (state);
         out = $rh.createReply();
         break;
       }

       case 5:  // game/Player/getState
       {
         com.games.java.model.players.corba.game.StateCore $result = null;
         $result = this.getState ();
         out = $rh.createReply();
         com.games.java.model.players.corba.game.StateCoreHelper.write (out, $result);
         break;
       }

       case 6:  // game/Player/setFieldName
       {
         String name = in.read_wstring ();
         this.setFieldName (name);
         out = $rh.createReply();
         break;
       }

       case 7:  // game/Player/getFieldName
       {
         String $result = null;
         $result = this.getFieldName ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:game/Player:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Player _this() 
  {
    return PlayerHelper.narrow(
    super._this_object());
  }

  public Player _this(org.omg.CORBA.ORB orb) 
  {
    return PlayerHelper.narrow(
    super._this_object(orb));
  }


} // class PlayerPOA
