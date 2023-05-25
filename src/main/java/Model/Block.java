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
     * {@return az északi oldal értékét adja vissza}
     */
    public int getNorth() {
        return north;
    }

    /**
     * {@return a keleti oldal értékét adja vissza}
     */
    public int getEast() {
        return east;
    }

    /**
     * {@return a déli oldal értékét adja vissza}
     */
    public int getSouth() {
        return south;
    }

    /**
     * {@return a nyugati oldal értékét adja vissza}
     */
    public int getWest() {
        return west;
    }

    /**
     * {@return visszaadja, hogy a cella végpont-e vagy sem}
     */
    public boolean isEndpoint() {
        return endpoint;
    }

}