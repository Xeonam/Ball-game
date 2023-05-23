package Controller;


import Model.PlayerInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.tinylog.Logger;


import java.io.IOException;

public class MenuController {

    @FXML
    private AnchorPane sceneMenu;

    @FXML
    private TextField playerName;

    @FXML
    void onPlayGame(ActionEvent event) throws IOException {
        Logger.debug("Clicked on: " + ((Button) event.getSource()).getText());
        PlayerInfo.name = new SimpleStringProperty(playerName.getText());
        new SceneSwitch(sceneMenu, "/map.fxml");
    }

    @FXML
    void onLeaderboard(ActionEvent event) throws IOException {
        Logger.debug("Clicked on: " + ((Button) event.getSource()).getText());
        CreateLeaderboard.IsLeaderboardFileExists();
        new SceneSwitch(sceneMenu, "/leaderboard.fxml");
    }

}
