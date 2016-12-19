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
        }


    }

    @Override
    public Player getPlayerOne() {
        if(playerOne == null) {
            try {

                CurrentPlayer playerOne = new CurrentPlayer(StateCore.GREEN);

                org.omg.CORBA.Object ref = rootPoa.servant_to_reference(playerOne);
                Player rRef = PlayerHelper.narrow(ref);

                org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
                nameService = NamingContextExtHelper.narrow(objRef);
                NameComponent[] component = nameService.to_name(NAME_MAIN_PLAYER);
                nameService.rebind(component, rRef);

                factory.registry(rRef);
                namePlayer = factory.getPlayerOne();

            } catch (WrongPolicy wrongPolicy) {
                wrongPolicy.printStackTrace();
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
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
        return playerOne;
    }


    @Override
    public Player getPlayerEnemy() {
        if(playerEnemy == null)
            playerEnemy = PlayerHelper.narrow(orb.string_to_object(factory.getPlayerEnemy()));
        return playerEnemy;
    }

    public Field getField(){
        Field field = null;
        try {
            if (isMainPlayer()) {
                field = GeneratorFactory.getGenerator().generate();
                registryField(field);
                return field;
            }
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

        Field fieldRef = FieldHelper.narrow(rootPoa.servant_to_reference((FieldSimple) field));
        nameService.rebind(nameService.to_name(playerOne.getFieldName()), fieldRef);

    }

}
