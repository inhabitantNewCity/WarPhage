package com.games.java.model.players.corba;

import com.games.java.model.players.corba.idls.game.Player;
import com.games.java.model.players.corba.idls.game.PlayerPOA;
import com.games.java.model.players.corba.idls.game.StateCore;
import com.games.java.model.players.corba.idls.registry.RegistryFactory;
import com.games.java.model.players.corba.idls.registry.RegistryFactoryHelper;
import com.games.java.model.players.corba.idls.registry.RegistryFactoryPOA;

import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import java.util.HashMap;
import java.util.Map;

import static com.games.java.model.utils.Constants.*;

/**
 * Created by Tmp on 17.12.2016.
 */
public class RegistryFactoryImpl extends RegistryFactoryPOA{

    private volatile int countPlayersFlag = 0;
    private volatile String[] players = new String[2];
    private volatile int countPlayers = 0;
    private static NamingContextExt namingContextExt;
    private static POA rootpoa;
    private volatile Map<Player, String> CURRENT_PLAYERS = new HashMap<>();
    public volatile String[] result = new String[1];

    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(new String[2], corbaStartProp);

            rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            RegistryFactoryImpl factory = new RegistryFactoryImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(factory);
            RegistryFactory rRef = RegistryFactoryHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            namingContextExt = NamingContextExtHelper.narrow(objRef);
            NameComponent[] component = namingContextExt.to_name(NAME_REGISTRY_SERVICE);
            namingContextExt.rebind(component, rRef);

            System.out.println("Registry Service is ready and waiting ...");
            orb.run();

        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (AdapterInactive adapterInactive) {
            adapterInactive.printStackTrace();
        } catch (WrongPolicy wrongPolicy) {
            wrongPolicy.printStackTrace();
        } catch (ServantNotActive servantNotActive) {
            servantNotActive.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
    }

    @Override
    public void registry(Player player) {

        new Thread(() -> {

            try {
                countPlayersFlag++;
                countPlayers++;
                registryCurrentPlayer(player);
                while (countPlayersFlag < 2);
                System.out.println("player two loging");
            } catch (ServantNotActive servantNotActive) {
                servantNotActive.printStackTrace();
            } catch (WrongPolicy wrongPolicy) {
                wrongPolicy.printStackTrace();
            } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
                invalidName.printStackTrace();
            } catch (CannotProceed cannotProceed) {
                cannotProceed.printStackTrace();
            } catch (NotFound notFound) {
                notFound.printStackTrace();
            }

        }).run();

    }

    @Override
    public String getCurrentName() {
        return result[0];
    }

    private void registryCurrentPlayer(Player player) throws ServantNotActive, WrongPolicy, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {

        NameComponent[] component;
        if(countPlayersFlag == 1 ) {
            component = namingContextExt.to_name(NAME_MAIN_PLAYER + countPlayers);
            players[countPlayersFlag - 1] = NAME_MAIN_PLAYER + countPlayers;
            CURRENT_PLAYERS.put(player,players[countPlayersFlag-1]);
        }
        else {
            component = namingContextExt.to_name(NAME_SECOND_PALAYER + countPlayers);
            players[countPlayersFlag - 1] = NAME_SECOND_PALAYER + countPlayers;
            CURRENT_PLAYERS.put(player, players[countPlayersFlag - 1]);
        }
        player.setFieldName(NAME_FIELD + (countPlayers - countPlayersFlag));

        System.out.println("Player number " + countPlayersFlag + " is loged");
        result[0] = players[countPlayersFlag - 1];
    }

    @Override
    public String getPlayerOne() {
        //countPlayersFlag = 0;
        return players[0];
    }

    @Override
    public String getPlayerEnemy() {
        //countPlayersFlag = 0;
        return players[1];
    }



}
