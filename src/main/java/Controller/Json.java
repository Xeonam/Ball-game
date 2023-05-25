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
/**
 * A `Json` osztály felelős a pálya JSON fájlból történő beolvasásáért.
 */
public class Json {
    /**
     * Beolvassa a térképet a JSON fájlból és visszaadja a blokkok listáját.
     *
     * @return a blokkok listája
     */
    public static List<Block> readMap() {

        ArrayList<Block> blocksList = new ArrayList<>();

        Gson gson = new GsonBuilder().create();

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("map.json");

        Reader reader = new InputStreamReader(inputStream);
        Block[][] blocksArray = gson.fromJson(reader, Block[][].class);

        for (Block[] blocks : blocksArray) {
            blocksList.addAll(Arrays.asList(blocks));
        }

        return blocksList;
    }
}
