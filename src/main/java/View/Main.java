package View;

import Controller.Json;
import Model.Block;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Block> blocks = Json.readMap();

        for (Block block: blocks) {
            System.out.println(block);
        }
    }
}
