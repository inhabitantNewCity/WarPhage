package com.games.java.model.players.corba.idls.registry;


/**
* com/games/java/model/players/corba/idls/registry/RegistryFactoryHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

abstract public class RegistryFactoryHelper
{
  private static String  _id = "IDL:registry/RegistryFactory:1.0";

  public static void insert (org.omg.CORBA.Any a, com.games.java.model.players.corba.idls.registry.RegistryFactory that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.games.java.model.players.corba.idls.registry.RegistryFactory extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (com.games.java.model.players.corba.idls.registry.RegistryFactoryHelper.id (), "RegistryFactory");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.games.java.model.players.corba.idls.registry.RegistryFactory read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_RegistryFactoryStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.games.java.model.players.corba.idls.registry.RegistryFactory value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static com.games.java.model.players.corba.idls.registry.RegistryFactory narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.games.java.model.players.corba.idls.registry.RegistryFactory)
      return (com.games.java.model.players.corba.idls.registry.RegistryFactory)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.games.java.model.players.corba.idls.registry._RegistryFactoryStub stub = new com.games.java.model.players.corba.idls.registry._RegistryFactoryStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static com.games.java.model.players.corba.idls.registry.RegistryFactory unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.games.java.model.players.corba.idls.registry.RegistryFactory)
      return (com.games.java.model.players.corba.idls.registry.RegistryFactory)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.games.java.model.players.corba.idls.registry._RegistryFactoryStub stub = new com.games.java.model.players.corba.idls.registry._RegistryFactoryStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}