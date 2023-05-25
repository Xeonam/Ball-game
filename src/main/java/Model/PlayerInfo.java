package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Egy osztály, amely a játékosok adatait reprezentálja.
 */
public class PlayerInfo {

    /**
     * A játékos neve.
     */
    public static SimpleStringProperty name;
    /**
     * A játékos által megtett lépések száma.
     */
    public static SimpleIntegerProperty playerSteps = new SimpleIntegerProperty(0);
    /**
     * A játékos nyert-e.
     */
    public static SimpleBooleanProperty victory = new SimpleBooleanProperty(false);

    /**
     * A PlayerInfo osztály alapértelmezett konstruktora.
     */
    public PlayerInfo() {
    }

    /**
     * A játékos által megtett lépések számát adja vissza.
     *
     * @return playerSteps
     */
    public SimpleIntegerProperty getSteps() {
        return playerSteps;
    }

    /**
     * A játékos nevét adja vissza.
     *
     * @return name
     */
    public SimpleStringProperty getName() {
        return name;
    }

    /**
     * Beállítja a játékos által megtett lépések számát.
     *
     * @param steps A beállítandó lépések száma.
     */
    public void setSteps(int steps) {
        playerSteps.set(steps);
    }

}
