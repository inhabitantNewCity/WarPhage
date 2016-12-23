package com.games.java.model.players.corba.registry;


/**
* com/games/java/model/players/corba/registry/RegistryFactoryPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 19:29:30 MSK
*/

public abstract class RegistryFactoryPOA extends org.omg.PortableServer.Servant
 implements com.games.java.model.players.corba.registry.RegistryFactoryOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registry", new java.lang.Integer (0));
    _methods.put ("getCurrentName", new java.lang.Integer (1));
    _methods.put ("getPlayerOne", new java.lang.Integer (2));
    _methods.put ("getPlayerEnemy", new java.lang.Integer (3));
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
       case 0:  // registry/RegistryFactory/registry
       {
         com.games.java.model.players.corba.game.Player player = com.games.java.model.players.corba.game.PlayerHelper.read (in);
         this.registry (player);
         out = $rh.createReply();
         break;
       }

       case 1:  // registry/RegistryFactory/getCurrentName
       {
         String $result = null;
         $result = this.getCurrentName ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // registry/RegistryFactory/getPlayerOne
       {
         String $result = null;
         $result = this.getPlayerOne ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 3:  // registry/RegistryFactory/getPlayerEnemy
       {
         String $result = null;
         $result = this.getPlayerEnemy ();
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
    "IDL:registry/RegistryFactory:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public RegistryFactory _this() 
  {
    return RegistryFactoryHelper.narrow(
    super._this_object());
  }

  public RegistryFactory _this(org.omg.CORBA.ORB orb) 
  {
    return RegistryFactoryHelper.narrow(
    super._this_object(orb));
  }


} // class RegistryFactoryPOA
