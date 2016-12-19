package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/Point2DPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 19:18:29 MSK
*/

public abstract class Point2DPOA extends org.omg.PortableServer.Servant
 implements com.games.java.model.players.corba.idls.game.Point2DOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getX", new java.lang.Integer (0));
    _methods.put ("setX", new java.lang.Integer (1));
    _methods.put ("getY", new java.lang.Integer (2));
    _methods.put ("setY", new java.lang.Integer (3));
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
       case 0:  // game/Point2D/getX
       {
         double $result = (double)0;
         $result = this.getX ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 1:  // game/Point2D/setX
       {
         double x = in.read_double ();
         this.setX (x);
         out = $rh.createReply();
         break;
       }

       case 2:  // game/Point2D/getY
       {
         double $result = (double)0;
         $result = this.getY ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // game/Point2D/setY
       {
         double y = in.read_double ();
         this.setY (y);
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
    "IDL:game/Point2D:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Point2D _this() 
  {
    return Point2DHelper.narrow(
    super._this_object());
  }

  public Point2D _this(org.omg.CORBA.ORB orb) 
  {
    return Point2DHelper.narrow(
    super._this_object(orb));
  }


} // class Point2DPOA
