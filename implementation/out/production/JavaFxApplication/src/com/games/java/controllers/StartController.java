package com.games.java.controllers;

import com.games.java.controllers.listeners.OncClickCoreListener;
import com.games.java.model.field.Core;
import com.games.java.model.field.Field;
import com.games.java.model.players.CurrentPlayer;
import com.games.java.model.players.Player;
import com.games.java.model.players.Referee;
import com.games.java.model.utils.SizeCore;
import com.games.java.model.utils.StateCore;
import com.games.java.model.utils.generaters.GeneratorFactory;
import com.sun.javafx.geom.Point2D;
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
    @FXML
    private ImageView startPlayerCore;
    @FXML
    private ImageView startEnemyCore;
    @FXML
    private Label labelPlayerCountPhage;
    @FXML
    private Label labelEnemyCountPhage;

    private List<CoreControllerLevel> coreViews = new LinkedList<>();

    @FXML
    public void initialize() throws IOException {

        field = GeneratorFactory.getGenerator().generate();
        field.setController(this);
        List<Group> coreViews = rendering(field);
        Group group = new Group();
        group.getChildren().addAll(coreViews);
        startChangedForField(startEnemyCore, startPlayerCore, group);
        group.setId(NAME_CORES_GROUP_ID);
        gameAnchorPane.getChildren().addAll(group);
        seterAnimation.setCoresGroup(group);

    }

    private void startChangedForField(ImageView startEnemyCore, ImageView startPlayerCore, Group group) {
        Core coreP = new Core(StateCore.GREEN);
        Core coreE = new Core(StateCore.RED);
        Group groupP = new Group();
        Group groupE = new Group();

        coreP.setLocation(new Point2D((float) startPlayerCore.getX(), (float) startPlayerCore.getY()));
        coreP.setCountPhage(COUNT_START_PHAGE);
        coreP.setSize(SizeCore.BIG_CORE);
        coreP.setId(100);
        labelPlayerCountPhage.setText(coreP.getCountPhage() + "");
        groupP.getChildren().add(startPlayerCore);
        groupP.getChildren().add(labelPlayerCountPhage);
        groupP.setOnMouseClicked(new OncClickCoreListener(this));
        group.getChildren().add(groupP);
        coreViews.add(new CoreControllerLevel(groupP, coreP));

        coreE.setLocation(new Point2D((float) startEnemyCore.getX(), (float) startEnemyCore.getY()));
        coreE.setCountPhage(COUNT_START_PHAGE);
        coreE.setSize(SizeCore.BIG_CORE);
        coreE.setId(101);
        labelEnemyCountPhage.setText(coreE.getCountPhage() + "");
        groupE.getChildren().add(startEnemyCore);
        groupE.getChildren().add(labelEnemyCountPhage);
        groupE.setOnMouseClicked(new OncClickCoreListener(this));
        group.getChildren().add(groupE);
        coreViews.add(new CoreControllerLevel(groupE,coreE));

        field.addCore(coreP);
        field.addCore(coreE);

    }

    private List<Group> rendering(Field field) throws IOException {
        List<Group> images = new LinkedList<>();
        for(Core core : field.getCores()){
            images.add(createCoreView(core));
        }
        return images;
    }

    @Override
    public void updateFieldView(Core core) {
        CoreControllerLevel currentCoreView = getCoreControllerLevelByCore(core);
        Image image = new Image(this.getClass().getResource(IMAGE_CORES_BY_STATUS.get(core.getState())).toExternalForm());
        currentCoreView.setImage(image);
        //todo: check to victory though referee


    }


    private Group createCoreView(Core core){

        Group result = new Group();
        Image image = new Image(this.getClass().getResource(IMAGE_CORES.get(core.getSize())).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setX(core.getLocation().x);
        imageView.setY(core.getLocation().y);
        imageView.setId(NAME_CORE_IMAGE_VIEW_ID + core.getId());

        Label label = new Label();
        label.setTranslateX(core.getLocation().x + core.getSize().getSize() / 2 - 3);
        label.setTranslateY(core.getLocation().y + core.getSize().getSize() / 2 - 7);
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
