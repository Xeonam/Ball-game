package Model;

public class Block {

    private boolean endpoint;
    private int north;
    private int west;
    private int south;
    private int east;

    public Block(int north, int west, int south, int east, boolean isEndpoint) {
        this.north = north;
        this.west = west;
        this.south = south;
        this.east = east;
        this.endpoint = isEndpoint;
    }

    public int getNorth() {
        return north;
    }

    public int getEast() {
        return east;
    }

    public int getSouth() {
        return south;
    }

    public int getWest() {
        return west;
    }

    public boolean isEndpoint() {
        return endpoint;
    }

    @Override
    public String toString() {
        return "Block{" +
                "endpoint=" + endpoint +
                ", north=" + north +
                ", west=" + west +
                ", south=" + south +
                ", east=" + east +
                '}';
    }
}