package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class MapController {

    @FXML
    AnchorPane sceneMap;

    public MapController() {
    }


    @FXML
    private void onMenuButton(ActionEvent event) throws IOException {
        new SceneSwitch(sceneMap, "/menu.fxml");
    }

    @FXML
    private void onLeaderboardButton(ActionEvent event) throws IOException {
        new SceneSwitch(sceneMap, "/leaderboard.fxml");
    }


}
