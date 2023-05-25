package Model;


/**
 * Egy labda osztályt reprezentál koordinátákkal együtt.
 */
public class Ball {
    private final int STARTING_ROW_POSITION = 1;
    private final int STARTING_COLUMN_POSITION = 4;
    private int posRow = STARTING_ROW_POSITION;
    private int posColumn = STARTING_COLUMN_POSITION;

    /**
     * Az aktuális sor pozícióját adja vissza.
     *
     * @return posRow
     */
    public int getPosRow() {
        return posRow;
    }

    /**
     * Beállítja a labda sor pozícióját.
     *
     * @param posRow Az új sor pozíció
     */
    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    /**
     * Az aktuális oszlop pozícióját adja vissza.
     *
     * @return posColumn
     */
    public int getPosColumn() {
        return posColumn;
    }

    /**
     * Beállítja a labda oszlop pozícióját.
     *
     * @param posColumn Az új oszlop pozíció
     */
    public void setPosColumn(int posColumn) {
        this.posColumn = posColumn;
    }

    /**
     *  A kezdő sor pozíciója.
     *
     * @return STARTING_ROW_POSITION
     */
    public int getSTARTING_ROW_POSITION() {
        return STARTING_ROW_POSITION;
    }

    /**
     * A kezdő oszlop pozíciója.
     *
     * @return STARTING_COLUMN_POSITION
     */
    public int getSTARTING_COLUMN_POSITION() {
        return STARTING_COLUMN_POSITION;
    }
}
