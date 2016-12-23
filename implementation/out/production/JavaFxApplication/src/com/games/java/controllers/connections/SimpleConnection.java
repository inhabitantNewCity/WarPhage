package com.games.java.controllers.connections;

import com.games.java.model.field.FieldSimple;
import com.games.java.model.players.CurrentPlayer;
import com.games.java.model.players.corba.idls.game.*;
import com.games.java.model.players.corba.idls.registry.RegistryFactory;
import com.games.java.model.players.corba.idls.registry.RegistryFactoryHelper;

import com.games.java.model.utils.generaters.GeneratorFactory;
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

import javax.naming.*;

import java.util.Hashtable;

import static com.games.java.model.utils.Constants.*;
/**
 * Created by Tmp on 16.12.2016.
 */
public class SimpleConnection implements Connection {

    private Player playerOne;
    private com.games.java.model.players.Player playerOneImpl;
    private Player playerEnemy;
    private Field field;

    private NamingContextExt nameService;
    private POA rootPoa;
    private javax.naming.Context context;
    private RegistryFactory factory;
    private String namePlayer;


    @Override
    public boolean isMainPlayer() {
        return namePlayer.contains(NAME_MAIN_PLAYER);
    }

    public SimpleConnection(){

        try {
            rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            nameService = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            Hashtable env = new Hashtable();
            context = new InitialContext(env);
            factory = RegistryFactoryHelper.narrow(nameService.resolve_str(NAME_REGISTRY_SERVICE));

            // registry local player
            playerOneImpl = new CurrentPlayer(StateCore.GREEN);

            org.omg.CORBA.Object ref = rootPoa.servant_to_reference((CurrentPlayer) playerOneImpl);
            playerOne = PlayerHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            nameService = NamingContextExtHelper.narrow(objRef);
            NameComponent[] component = nameService.to_name(NAME_MAIN_PLAYER);
            nameService.rebind(component, playerOne);

            System.out.println("player one is registring with name: " + NAME_MAIN_PLAYER);

            factory.registry(playerOne);

            namePlayer = factory.getCurrentName();
            nameService.rebind(nameService.to_name(namePlayer), playerOne);

            Thread.sleep(100);

            if(isMainPlayer()) {
                String nameEnemy = factory.getPlayerEnemy();
                System.out.println("it is main class with name: " + namePlayer + " and enemy with name: " + nameEnemy);
                playerEnemy = PlayerHelper.narrow(nameService.resolve_str(nameEnemy));

            } else {
                playerOneImpl.setState(StateCore.RED);
                String nameEnemy = factory.getPlayerOne();
                System.out.println("it is enemy class with name: " + namePlayer + " and enemy with name: " + nameEnemy);
                playerEnemy = PlayerHelper.narrow(nameService.resolve_str(nameEnemy));

            }

            System.out.println("player one is registred with name: " + namePlayer);

        } catch (AdapterInactive adapterInactive) {
            adapterInactive.printStackTrace();
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        } catch (WrongPolicy wrongPolicy) {
            wrongPolicy.printStackTrace();
        } catch (ServantNotActive servantNotActive) {
            servantNotActive.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public com.games.java.model.players.Player getPlayerOne() {
        return playerOneImpl;
    }


    @Override
    public Player getPlayerEnemy() {
        System.out.println("getPlayerEnemy");
        System.out.println("player one is " + factory.getPlayerOne());
        System.out.println("enemy is " + factory.getPlayerEnemy());
        return playerEnemy;
    }

    public Field getField(){
        Field field = null;
        try {
            if (isMainPlayer()) {
                field = GeneratorFactory.getGenerator().generate();
                registryField(field);
                System.out.println("Main Field: " + playerOne.getFieldName());
                return field;
            }
            System.out.println("External Field");
            return getFieldFromService();
        } catch (WrongPolicy wrongPolicy) {
            wrongPolicy.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (ServantNotActive servantNotActive) {
            servantNotActive.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        }
        return field;
    }

    private Field getFieldFromService() throws CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound {
        return FieldHelper.narrow(nameService.resolve_str(playerOne.getFieldName()));
    }

    private void registryField(Field field) throws ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {

        field.setPlayerOne(playerOne);
        field.setPlayerEnemy(playerEnemy);
        Field fieldRef = FieldHelper.narrow(rootPoa.servant_to_reference((FieldSimple) field));
        nameService.rebind(nameService.to_name(playerOne.getFieldName()), fieldRef);


    }

}
