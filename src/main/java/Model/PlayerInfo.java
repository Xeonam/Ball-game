package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class PlayerInfo {


    public static SimpleStringProperty name;
    public static SimpleIntegerProperty playerSteps = new SimpleIntegerProperty(0);
    public static SimpleBooleanProperty victory = new SimpleBooleanProperty(false);


    public PlayerInfo() {
    }

    public SimpleIntegerProperty getSteps() {
        return playerSteps;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setSteps(int steps) {
        playerSteps.set(steps);
    }

}
