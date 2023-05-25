package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Egy osztály, amely a játékosok adatait reprezentálja.
 */
public class PlayerInfo {


    public static SimpleStringProperty name;
    public static SimpleIntegerProperty playerSteps = new SimpleIntegerProperty(0);
    public static SimpleBooleanProperty victory = new SimpleBooleanProperty(false);

    /**
     * A PlayerInfo osztály alapértelmezett konstruktora.
     */
    public PlayerInfo() {
    }

    /**
     * {@return A játékos által megtett lépések számát adja vissza.}
     */
    public SimpleIntegerProperty getSteps() {
        return playerSteps;
    }

    /**
     * {@return A játékos nevét adja vissza.}
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
