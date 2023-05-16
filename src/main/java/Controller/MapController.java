package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Ball;
import Model.Block;
import Model.Map;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.List;


public class MapController {

    @FXML
    AnchorPane sceneMap;

    @FXML
    GridPane gridPane;

    private List<Block> blocks = Json.readMap();

    Ball ball = new Ball();
    Map map = new Map(ball);

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

    @FXML
    private void initialize() {
        createBoard();
        
    }

    private void createBoard() {
        for (int row = 0; row < gridPane.getRowCount(); row++) {
            for (int column = 0; column < gridPane.getColumnCount(); column++) {
                var block = blocks.get(row * gridPane.getColumnCount() + column);
                var square = createSquare(block);
                gridPane.add(square, column, row);
            }
        }
    }

    private StackPane createSquare(Block block) {
        var square = new StackPane();
        var n = "0";
        var w = "0";
        var s = "0";
        var e = "0";

        if (block.getNorth() == 1) {
            n = "3";
        }
        if (block.getWest() == 1) {
            w = "3";
        }
        if (block.getSouth() == 1) {
            s = "3";
        }
        if (block.getEast() == 1) {
            e = "3";
        }

        if (block.isEndpoint()) {
            Text text = new Text("Cel:");
            text.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 20px;");
            square.getChildren().add(text);
        }

        square.setStyle("-fx-border-color: red; -fx-border-width: " + n + " " + e + " " + s + " " + w + ";");
        return square;
    }

}
