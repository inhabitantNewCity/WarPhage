package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/CorePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 19:18:29 MSK
*/

public abstract class CorePOA extends org.omg.PortableServer.Servant
 implements com.games.java.model.players.corba.idls.game.CoreOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getSize", new java.lang.Integer (0));
    _methods.put ("setSize", new java.lang.Integer (1));
    _methods.put ("getLocation", new java.lang.Integer (2));
    _methods.put ("setLocation", new java.lang.Integer (3));
    _methods.put ("getId", new java.lang.Integer (4));
    _methods.put ("setId", new java.lang.Integer (5));
    _methods.put ("getCountPhage", new java.lang.Integer (6));
    _methods.put ("setCountPhage", new java.lang.Integer (7));
    _methods.put ("updateCores", new java.lang.Integer (8));
    _methods.put ("getState", new java.lang.Integer (9));
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
       case 0:  // game/Core/getSize
       {
         com.games.java.model.players.corba.idls.game.SizeCore $result = null;
         $result = this.getSize ();
         out = $rh.createReply();
         com.games.java.model.players.corba.idls.game.SizeCoreHelper.write (out, $result);
         break;
       }

       case 1:  // game/Core/setSize
       {
         com.games.java.model.players.corba.idls.game.SizeCore size = com.games.java.model.players.corba.idls.game.SizeCoreHelper.read (in);
         this.setSize (size);
         out = $rh.createReply();
         break;
       }

       case 2:  // game/Core/getLocation
       {
         com.games.java.model.players.corba.idls.game.Point2D $result = null;
         $result = this.getLocation ();
         out = $rh.createReply();
         com.games.java.model.players.corba.idls.game.Point2DHelper.write (out, $result);
         break;
       }

       case 3:  // game/Core/setLocation
       {
         com.games.java.model.players.corba.idls.game.Point2D location = com.games.java.model.players.corba.idls.game.Point2DHelper.read (in);
         this.setLocation (location);
         out = $rh.createReply();
         break;
       }

       case 4:  // game/Core/getId
       {
         int $result = (int)0;
         $result = this.getId ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       case 5:  // game/Core/setId
       {
         int id = in.read_ulong ();
         this.setId (id);
         out = $rh.createReply();
         break;
       }

       case 6:  // game/Core/getCountPhage
       {
         int $result = (int)0;
         $result = this.getCountPhage ();
         out = $rh.createReply();
         out.write_ulong ($result);
         break;
       }

       case 7:  // game/Core/setCountPhage
       {
         int countPhage = in.read_ulong ();
         this.setCountPhage (countPhage);
         out = $rh.createReply();
         break;
       }

       case 8:  // game/Core/updateCores
       {
         com.games.java.model.players.corba.idls.game.Core sourceCore = com.games.java.model.players.corba.idls.game.CoreHelper.read (in);
         this.updateCores (sourceCore);
         out = $rh.createReply();
         break;
       }

       case 9:  // game/Core/getState
       {
         com.games.java.model.players.corba.idls.game.StateCore $result = null;
         $result = this.getState ();
         out = $rh.createReply();
         com.games.java.model.players.corba.idls.game.StateCoreHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:game/Core:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Core _this() 
  {
    return CoreHelper.narrow(
    super._this_object());
  }

  public Core _this(org.omg.CORBA.ORB orb) 
  {
    return CoreHelper.narrow(
    super._this_object(orb));
  }


} // class CorePOA
