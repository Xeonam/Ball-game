package Controller;

import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;

/**
 * Egy segédprogram osztály a ranglista fájl létrehozásához, ha az nem létezik.
 */
public class CreateLeaderboard {

    /**
     * Ellenőrzi, hogy létezik-e a ranglista fájl. Ha nem, akkor létrehozza a fájlt, és inicializálja egy üres JSON-tömbbel.
     */
    public static void IsLeaderboardFileExists() {
        File file = new File("leaderboard.json");
        if (!file.exists()) {
            try {
                boolean fileCreated = file.createNewFile();
                if (fileCreated) {
                    FileWriter writer = new FileWriter(file);
                    writer.write("[]");
                    writer.flush();
                    writer.close();
                    Logger.debug("File created: " + file.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Logger.debug("File already exists.");
        }

    }
}
