package Controller;

import Model.PlayerInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Ball;
import Model.Block;
import Model.Map;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
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
    Label playerName;
    @FXML
    Label playerSteps;
    @FXML
    Circle circleBall;
    @FXML
    Label victoryLabel;

    private List<Block> blocks = Json.readMap();

    private Ball ball = new Ball();
    private Map map = new Map(ball);

    public MapController() {
    }


    @FXML
    private void onMenuButton(ActionEvent event) throws IOException {
        Logger.debug("Clicked on: " + ((Button) event.getSource()).getText());
        new SceneSwitch(sceneMap, "/menu.fxml");
    }

    @FXML
    private void onLeaderboardButton(ActionEvent event) throws IOException {
        Logger.debug("Clicked on: " + ((Button) event.getSource()).getText());
        new SceneSwitch(sceneMap, "/leaderboard.fxml");
    }

    @FXML
    private void initialize() {
        createBoard();
        moveBall();
        printName();
        printSteps();
        printVictory();
    }

    private void printVictory() {
        PlayerInfo.victory.addListener((observable, oldValue, newValue) -> {
            if (PlayerInfo.victory.getValue()) {
                victoryLabel.setText("You won!");
            } else {
                victoryLabel.setText("");
            }

        });
    }

    private void printSteps() {
        PlayerInfo.playerSteps.addListener((observable, oldValue, newValue) -> {
            playerSteps.setText("Steps: " + newValue.intValue());
        });
    }

    private void printName() {
        playerName.setText("Player: " + PlayerInfo.name.getValue());
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
        map.playerInfo.setSteps(0);
        PlayerInfo.victory.setValue(false);

        gridPane.setOnKeyPressed(keyEvent -> {
            var pos = map.block_array[ball.getPosRow()][ball.getPosColumn()];

            if (keyEvent.getCode() == KeyCode.R) {
                Logger.debug("Pressed " + keyEvent.getCode());
                resetGame();
            }

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


            if (map.victory()) {
                Logger.debug("The player has reached the endpoint!");
                PlayerInfo.victory.set(true);
                try {
                    map.playerToLeaderboard();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                gridPane.setOnKeyPressed(keyEvent1 -> {
                    if (keyEvent1.getCode() == KeyCode.R) {
                        resetGame();

                    }
                });

            }

        });
    }

    private void resetGame() {
        gridPane.getChildren().remove(circleBall);
        ball.setPosRow(ball.getSTARTING_ROW_POSITION());
        ball.setPosColumn(ball.getSTARTING_COLUMN_POSITION());
        gridPane.add(circleBall, ball.getPosColumn(), ball.getPosRow());
        moveBall();
    }

}
