package Controller;


import Model.PlayerInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class MenuController {

    @FXML
    private AnchorPane sceneMenu;

    @FXML
    private TextField playerName;

    @FXML
    void onPlayGame(ActionEvent event) throws IOException {
        PlayerInfo.name = new SimpleStringProperty(playerName.getText());
        new SceneSwitch(sceneMenu, "/map.fxml");
    }

    @FXML
    void onLeaderboard(ActionEvent event) throws IOException {
        CreateLeaderboard.IsLeaderboardFileExists();
        new SceneSwitch(sceneMenu, "/leaderboard.fxml");
    }

}
