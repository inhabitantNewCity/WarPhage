package game;


/**
* game/CoreOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Tmp/Desktop/computer/lening/netCreacer/distributedSystem/WarPhage/implementation/src/com/games/java/model/players/corba/idls/Regestry.idl
* 23 ������� 2016 �. 14:50:36 MSK
*/

public interface CoreOperations 
{
  game.SizeCore getSize ();
  void setSize (game.SizeCore size);
  game.Point2D getLocation ();
  void setLocation (game.Point2D location);
  int getId ();
  void setId (int id);
  int getCountPhage ();
  void setCountPhage (int countPhage);
  void updateCores (game.Core sourceCore);
  game.StateCore getState ();
} // interface CoreOperations
