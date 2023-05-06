package Controller;

import Model.Block;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Json {
    public static List<Block> readMap() {

        ArrayList<Block> blocksList = new ArrayList<>();
        // Create Gson object
        Gson gson = new GsonBuilder().create();

        // Read the JSON file into a 2D array of Blocks
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("map.json");

        // Create a Reader from the input stream
        Reader reader = new InputStreamReader(inputStream);
        Block[][] blocksArray = gson.fromJson(reader, Block[][].class);

        for (Block[] blocks : blocksArray) {
            blocksList.addAll(Arrays.asList(blocks));
        }

        return blocksList;
    }
}
