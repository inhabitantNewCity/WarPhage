package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/_CoreStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

public class _CoreStub extends org.omg.CORBA.portable.ObjectImpl implements com.games.java.model.players.corba.idls.game.Core
{

  public com.games.java.model.players.corba.idls.game.SizeCore getSize ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getSize", true);
                $in = _invoke ($out);
                com.games.java.model.players.corba.idls.game.SizeCore $result = com.games.java.model.players.corba.idls.game.SizeCoreHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getSize (        );
            } finally {
                _releaseReply ($in);
            }
  } // getSize

  public void setSize (com.games.java.model.players.corba.idls.game.SizeCore size)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setSize", true);
                com.games.java.model.players.corba.idls.game.SizeCoreHelper.write ($out, size);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setSize (size        );
            } finally {
                _releaseReply ($in);
            }
  } // setSize

  public com.games.java.model.players.corba.idls.game.Point2D getLocation ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getLocation", true);
                $in = _invoke ($out);
                com.games.java.model.players.corba.idls.game.Point2D $result = com.games.java.model.players.corba.idls.game.Point2DHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getLocation (        );
            } finally {
                _releaseReply ($in);
            }
  } // getLocation

  public void setLocation (com.games.java.model.players.corba.idls.game.Point2D location)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setLocation", true);
                com.games.java.model.players.corba.idls.game.Point2DHelper.write ($out, location);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setLocation (location        );
            } finally {
                _releaseReply ($in);
            }
  } // setLocation

  public int getId ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getId", true);
                $in = _invoke ($out);
                int $result = $in.read_ulong ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getId (        );
            } finally {
                _releaseReply ($in);
            }
  } // getId

  public void setId (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setId", true);
                $out.write_ulong (id);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setId (id        );
            } finally {
                _releaseReply ($in);
            }
  } // setId

  public int getCountPhage ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getCountPhage", true);
                $in = _invoke ($out);
                int $result = $in.read_ulong ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getCountPhage (        );
            } finally {
                _releaseReply ($in);
            }
  } // getCountPhage

  public void setCountPhage (int countPhage)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("setCountPhage", true);
                $out.write_ulong (countPhage);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                setCountPhage (countPhage        );
            } finally {
                _releaseReply ($in);
            }
  } // setCountPhage

  public void updateCores (com.games.java.model.players.corba.idls.game.Core sourceCore)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateCores", true);
                com.games.java.model.players.corba.idls.game.CoreHelper.write ($out, sourceCore);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                updateCores (sourceCore        );
            } finally {
                _releaseReply ($in);
            }
  } // updateCores

  public com.games.java.model.players.corba.idls.game.StateCore getState ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getState", true);
                $in = _invoke ($out);
                com.games.java.model.players.corba.idls.game.StateCore $result = com.games.java.model.players.corba.idls.game.StateCoreHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getState (        );
            } finally {
                _releaseReply ($in);
            }
  } // getState

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:game/Core:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _CoreStub
