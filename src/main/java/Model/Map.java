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
}
