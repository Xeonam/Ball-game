package Model;


/**
 * Az adatbázisban szereplő játékosokat reprezentáló osztály.
 */
public class PlayerDatabase {

    private String created;
    private String name;
    private Integer playerSteps;

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
     * A játékos nevét adja vissza.
     *
     * @return name
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
     * Visszaadja a játékos által megtett lépések számát.
     *
     * @return playerSteps
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
     * Visszaadja a létrehozási dátumot.
     *
     * @return created
     */
    public String getCreated() {
        return created;
    }

}

