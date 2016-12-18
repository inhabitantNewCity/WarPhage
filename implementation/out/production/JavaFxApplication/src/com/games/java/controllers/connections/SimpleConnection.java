package com.games.java.controllers.connections;

import com.games.java.model.players.CurrentPlayer;
import com.games.java.model.players.Player;
import com.games.java.model.players.corba.idls.game.StateCore;
import com.games.java.model.players.corba.idls.registry.RegistryFactory;
import com.games.java.model.players.corba.idls.registry.RegistryFactoryHelper;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import javax.naming.*;

import java.util.Hashtable;

import static com.games.java.model.utils.Constants.*;
/**
 * Created by Tmp on 16.12.2016.
 */
public class SimpleConnection implements Connection {

    private Player playerOne;
    private Player playerEnemy;

    private NamingContextExt nameService;
    private POA rootPoa;
    private javax.naming.Context context;
    private RegistryFactory factory;
    private int countPlayers;

    @Override
    public boolean IsMainPlayer() {
        return false;
    }

    public SimpleConnection(){

        try {
            rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            nameService = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            Hashtable env = new Hashtable();
            context = new InitialContext(env);
            factory = RegistryFactoryHelper.narrow(orb.string_to_object(NAME_REGISTRY_SERVICE));



        } catch (AdapterInactive adapterInactive) {
            adapterInactive.printStackTrace();
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Player getPlayerOne(){
        if(playerOne == null){
            playerOne = new CurrentPlayer(StateCore.GREEN);
                register(playerOne);
        }
        return playerOne;
    }

    private void register(Player player){

            try {
                NameComponent[] path = nameService.to_name(NAME_MAIN_PLAYER);
                //nameService.rebind(path, rootPoa.servant_to_reference(playerOne));

            } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
                invalidName.printStackTrace();
            }

    }

    @Override
    public Player getPlayerEnemy() {
        return playerEnemy;
    }


}
