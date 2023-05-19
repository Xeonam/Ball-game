package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Ball;
import Model.Block;
import Model.Map;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.tinylog.Logger;


import java.io.IOException;
import java.util.List;


public class MapController {

    @FXML
    AnchorPane sceneMap;

    @FXML
    GridPane gridPane;

    @FXML
    Circle circleBall;

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
        moveBall();
        
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

    public void moveBall() {


        gridPane.setOnKeyPressed(keyEvent -> {
            var pos = map.block_array[ball.getPosRow()][ball.getPosColumn()];

            if (keyEvent.getCode() == KeyCode.W && ball.getPosRow() != 0 && pos.getNorth() != 1) {
                Logger.debug("Pressed " + keyEvent.getCode());
                map.moveUp();

            } else if (keyEvent.getCode() == KeyCode.W && (ball.getPosRow() == 0 || pos.getNorth() == 1)) {
                Logger.error("Cannot move up. Wall encountered.");
            }

            if (keyEvent.getCode() == KeyCode.A && ball.getPosColumn() != 0 && pos.getWest() != 1) {
                Logger.debug("Pressed " + keyEvent.getCode());
                map.moveLeft();

            } else if (keyEvent.getCode() == KeyCode.A && (ball.getPosColumn() == 0 || pos.getWest() == 1)) {
                Logger.error("Cannot move left. Wall encountered.");
            }

            if (keyEvent.getCode() == KeyCode.S && ball.getPosRow() != 6 && pos.getSouth() != 1) {
                Logger.debug("Pressed " + keyEvent.getCode());
                map.moveDown();


            } else if (keyEvent.getCode() == KeyCode.S && (ball.getPosRow() == 6 || pos.getSouth() == 1)) {
                Logger.error("Cannot move down. Wall encountered.");
            }

            if (keyEvent.getCode() == KeyCode.D && ball.getPosColumn() != 6 && pos.getEast() != 1) {
                Logger.debug("Pressed " + keyEvent.getCode());
                map.moveRight();

            } else if (keyEvent.getCode() == KeyCode.D && (ball.getPosColumn() == 6 || pos.getEast() == 1)) {
                Logger.error("Cannot move right. Wall encountered.");
            }

            gridPane.getChildren().remove(circleBall);
            gridPane.add(circleBall, ball.getPosColumn(), ball.getPosRow());


        });
    }

}
