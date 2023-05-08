package Controller;


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
        new SceneSwitch(sceneMenu, "/map.fxml");
    }

    @FXML
    void onLeaderboard(ActionEvent event) throws IOException {
        //TODO
    }

}
