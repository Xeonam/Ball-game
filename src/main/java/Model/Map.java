package Model;

import Controller.Json;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class Map {
    List<Block> blocks = Json.readMap();
    public Block[][] block_array = ListToBlock();
    private Ball ball;

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

    public void moveUp() {
        while (ball.getPosRow() != 0 && block_array[ball.getPosRow()][ball.getPosColumn()].getNorth() != 1) {
            ball.setPosRow(ball.getPosRow() - 1);
        }
    }

    public void moveLeft() {
        while (ball.getPosColumn() != 0 && block_array[ball.getPosRow()][ball.getPosColumn()].getWest() != 1) {
            ball.setPosColumn(ball.getPosColumn() - 1);
        }
    }

    public void moveDown() {
        while (ball.getPosRow() != 6 && block_array[ball.getPosRow()][ball.getPosColumn()].getSouth() != 1) {
            ball.setPosRow(ball.getPosRow() + 1);
        }
    }

    public void moveRight() {
        while (ball.getPosColumn() != 6 && block_array[ball.getPosRow()][ball.getPosColumn()].getEast() != 1) {
            ball.setPosColumn(ball.getPosColumn() + 1);
        }
    }
}
