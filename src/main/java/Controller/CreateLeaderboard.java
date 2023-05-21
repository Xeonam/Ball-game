package Controller;

import org.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;

public class CreateLeaderboard {

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
