package Model;


/**
 * Az adatbázisban szereplő játékosokat reprezentáló osztály.
 */
public class PlayerDatabase {

    public String created;
    public String name;
    public Integer playerSteps;

//    public PlayerDatabase() {
//    }


    /**
     * Constructor for the PlayerDatabase class.
     *
     * @param name         A játékos neve.
     * @param playerSteps  A játékos által megtett lépések száma.
     * @param created      A létrehozási dátum.
     */
    public PlayerDatabase(String name, Integer playerSteps, String created) {
        this.name = name;
        this.playerSteps = playerSteps;
        this.created = created;
    }

    /**
     * {@return A játékos nevét adja vissza.}
     */
    public String getName() {
        return name;
    }

    /**
     * A játékos nevét állítja be.
     *
     * @param name az új név.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@return Visszaadja a játékos által megtett lépések számát.}
     */
    public Integer getPlayerSteps() {
        return playerSteps;
    }

    /**
     * Beállítja a játékos által megtett lépések számát.
     *
     * @param playerSteps A játékos által megtett lépések száma.
     */
    public void setPlayerSteps(Integer playerSteps) {
        this.playerSteps = playerSteps;
    }

    /**
     * {@return Visszaadja a létrehozási dátumot.}
     */
    public String getCreated() {
        return created;
    }

}

