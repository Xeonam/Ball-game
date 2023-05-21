package Model;

import Controller.CreateLeaderboard;
import Controller.Json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.tinylog.Logger;

public class Map {
    List<Block> blocks = Json.readMap();
    public Block[][] block_array = ListToBlock();
    private Ball ball;
    public PlayerInfo playerInfo = new PlayerInfo();
    public PlayerDatabase playerDatabase = new PlayerDatabase();

    public Map(Ball ball) {
        this.ball = ball;
    }

    public Block[][] ListToBlock() {
        Block[][] block_array = new Block[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                block_array[i][j] = blocks.get(i * 7 + j);
            }
        }
        return block_array;
    }

    public void playerToLeaderboard() throws IOException {
        CreateLeaderboard.IsLeaderboardFileExists();
        Logger.debug("Adding player to leaderboard");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Gson gson = new Gson();

        FileReader fileReader = new FileReader("leaderboard.json");
        List<PlayerDatabase> leaderBoard = gson.fromJson(fileReader, new TypeToken<List<PlayerDatabase>>() {
        }.getType());

        PlayerDatabase playerDatabase = new PlayerDatabase(playerInfo.getName().getValue(), playerInfo.getSteps().intValue(), now.format(formatter));
        leaderBoard.add(playerDatabase);

        String json = gson.toJson(leaderBoard);
        FileWriter fileWriter = new FileWriter("leaderboard.json");
        fileWriter.write(json);
        fileWriter.close();
    }

    public void moveUp() {
        while (ball.getPosRow() != 0 && block_array[ball.getPosRow()][ball.getPosColumn()].getNorth() != 1) {
            ball.setPosRow(ball.getPosRow() - 1);
            playerInfo.setSteps((playerInfo.getSteps().intValue() + 1));
        }
    }

    public void moveLeft() {
        while (ball.getPosColumn() != 0 && block_array[ball.getPosRow()][ball.getPosColumn()].getWest() != 1) {
            ball.setPosColumn(ball.getPosColumn() - 1);
            playerInfo.setSteps((playerInfo.getSteps().intValue() + 1));
        }
    }

    public void moveDown() {
        while (ball.getPosRow() != 6 && block_array[ball.getPosRow()][ball.getPosColumn()].getSouth() != 1) {
            ball.setPosRow(ball.getPosRow() + 1);
            playerInfo.setSteps((playerInfo.getSteps().intValue() + 1));
        }
    }

    public void moveRight() {
        while (ball.getPosColumn() != 6 && block_array[ball.getPosRow()][ball.getPosColumn()].getEast() != 1) {
            ball.setPosColumn(ball.getPosColumn() + 1);
            playerInfo.setSteps((playerInfo.getSteps().intValue() + 1));
        }
    }

    public boolean victory() {
        return (block_array[ball.getPosRow()][ball.getPosColumn()].isEndpoint());

    }
}
