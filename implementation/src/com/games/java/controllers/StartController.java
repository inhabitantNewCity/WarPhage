package com.games.java.controllers;

import com.games.java.controllers.listeners.OncClickCoreListener;
import com.games.java.model.players.CurrentPlayer;
import com.games.java.model.players.Referee;
import com.games.java.model.players.corba.idls.game.Core;
import com.games.java.model.players.corba.idls.game.Field;
import com.games.java.model.players.corba.idls.game.Player;
import com.games.java.model.players.corba.idls.game.StateCore;
import com.games.java.model.utils.generaters.GeneratorFactory;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static com.games.java.model.utils.Constants.*;

public class StartController implements Controller {

    private SeterAnimation seterAnimation = SeterAnimation.getInstance();
    private Player playerOne = new CurrentPlayer(StateCore.GREEN);
    private Player enemyPlayer;
    private Field field;
    private Referee referee; //= new Referee(field, playerOne, enemyPlayer);

    @FXML
    private AnchorPane gameAnchorPane;
    private List<CoreControllerLevel> coreViews = new LinkedList<>();

    @FXML
    public void initialize() throws IOException {

        field = GeneratorFactory.getGenerator().generate();
        //field.setPlayerOne(playerOne);
        ((com.games.java.model.players.Player) playerOne).setController(this);
        //field.setController(this);
        List<Group> coreViews = rendering(field);
        Group group = new Group();
        group.getChildren().addAll(coreViews);
        group.setId(NAME_CORES_GROUP_ID);
        gameAnchorPane.getChildren().addAll(group);
        seterAnimation.setCoresGroup(group);
        field.startGame();

    }

    private List<Group> rendering(Field field) throws IOException {
        List<Group> images = new LinkedList<>();
        for(int i = 0; i < field.getCountCores(); i++ ){
            images.add(createCoreView(field.coreNext()));
        }
        return images;
    }

    @Override
    public void updateFieldView(Core core) {
        CoreControllerLevel currentCoreView = getCoreControllerLevelByCore(core);
        currentCoreView.updateView();
        //todo: check to victory though referee


    }


    private Group createCoreView(Core core){

        Group result = new Group();
        Image image = new Image(this.getClass().getResource(IMAGE_CORES.get(core.getSize())).toExternalForm());
        if(core.getState() != StateCore.BLACK)
            image = new Image(this.getClass().getResource(IMAGE_CORES_BY_STATUS.get(core.getState())).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setX(core.getLocation().getX());
        imageView.setY(core.getLocation().getY());
        imageView.setId(NAME_CORE_IMAGE_VIEW_ID + core.getId());

        Label label = new Label();
        label.setTranslateX(core.getLocation().getX() + SIZE_BY_SIZE_CORE.get(core.getSize()) / 2 - 3);
        label.setTranslateY(core.getLocation().getY() + SIZE_BY_SIZE_CORE.get(core.getSize()) / 2 - 7);
        label.setText(core.getCountPhage() + "");
        label.setId(NAME_CORE_LABEL_ID + core.getId());

        result.getChildren().add(imageView);
        result.getChildren().add(label);
        result.setOnMouseClicked(new OncClickCoreListener(this));

        coreViews.add(new CoreControllerLevel(result, core));
        return result;
    }

    @Override
    public Core getCorrectCore(Group view) {
        for(CoreControllerLevel coreView : coreViews){
            if(coreView.isCorrectCore(view))
                return coreView.getModelCore();
        }
        return null;
    }

    @Override
    public Player getPlayer() {
        return playerOne;
    }

    @Override
    public Player getEnemy(){
        return enemyPlayer;
    }

    @Override
    public void setPlayer(Player player) {
        playerOne = player;
    }

    @Override
    public void setEnemy(Player player) {
        enemyPlayer= player;
    }

    @Override
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public void startGame(){
        field.startGame();
    }

    private CoreControllerLevel getCoreControllerLevelByCore(Core core){
        CoreControllerLevel currentCoreView = null;
        for(CoreControllerLevel coreControllerLevel : coreViews){
            if(coreControllerLevel.getModelCore() == core){
                currentCoreView = coreControllerLevel;
            }
        }
        return currentCoreView;
    }

}
