package Model;

/**
 * A Block osztály reprezentál egy egységet a modellben.
 * Egy blokk négy oldallal rendelkezik (észak, nyugat, dél, kelet) és egy végponttal.
 */
public class Block {

    private boolean endpoint;
    private int north;
    private int west;
    private int south;
    private int east;

    /**
     * Block osztály konstruktor.
     *
     * @param north       az északi oldal értéke
     * @param west        a nyugati oldal értéke
     * @param south       a déli oldal értéke
     * @param east        a keleti oldal értéke
     * @param isEndpoint  igaz, ha a blokk végpont, egyébként hamis
     */
    public Block(int north, int west, int south, int east, boolean isEndpoint) {
        this.north = north;
        this.west = west;
        this.south = south;
        this.east = east;
        this.endpoint = isEndpoint;
    }

    /**
     *  Az északi oldal értékét adja vissza.
     *
     *  @return north
     */
    public int getNorth() {
        return north;
    }

    /**
     *  A keleti oldal értékét adja vissza.
     *
     *  @return east
     */
    public int getEast() {
        return east;
    }

    /**
     *  A déli oldal értékét adja vissza.
     *
     *  @return south
     */
    public int getSouth() {
        return south;
    }

    /**
     *  A nyugati oldal értékét adja vissza.
     *
     *  @return west
     */
    public int getWest() {
        return west;
    }

    /**
     * Visszaadja, hogy a cella végpont-e vagy sem.
     *
     * @return endpoint
     */
    public boolean isEndpoint() {
        return endpoint;
    }

}