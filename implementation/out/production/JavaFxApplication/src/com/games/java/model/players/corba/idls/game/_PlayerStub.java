package com.games.java.model.players.corba.idls.game;


/**
* com/games/java/model/players/corba/idls/game/_PlayerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com/games/java/model/players/corba/idls/Regestry.idl
* 18 ������� 2016 �. 11:38:08 MSK
*/

public class _PlayerStub extends org.omg.CORBA.portable.ObjectImpl implements com.games.java.model.players.corba.idls.game.Player
{

  public void calculateChanges (com.games.java.model.players.corba.idls.game.Core core)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("calculateChanges", true);
                com.games.java.model.players.corba.idls.game.CoreHelper.write ($out, core);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                calculateChanges (core        );
            } finally {
                _releaseReply ($in);
            }
  } // calculateChanges

  public void updateCoreView (com.games.java.model.players.corba.idls.game.Core core)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateCoreView", true);
                com.games.java.model.players.corba.idls.game.CoreHelper.write ($out, core);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                updateCoreView (core        );
            } finally {
                _releaseReply ($in);
            }
  } // updateCoreView

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
    "IDL:game/Player:1.0"};

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
} // class _PlayerStub
