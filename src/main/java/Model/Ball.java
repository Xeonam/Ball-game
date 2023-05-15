package Model;

public class Ball {
    private final int STARTING_ROW_POSITION = 1;
    private final int STARTING_COLUMN_POSITION = 4;
    private int posRow = STARTING_ROW_POSITION;
    private int posColumn = STARTING_COLUMN_POSITION;

    public int getPosRow() {
        return posRow;
    }

    public void setPosRow(int posRow) {
        this.posRow = posRow;
    }

    public int getPosColumn() {
        return posColumn;
    }

    public void setPosColumn(int posColumn) {
        this.posColumn = posColumn;
    }

    public int getSTARTING_ROW_POSITION() {
        return STARTING_ROW_POSITION;
    }

    public int getSTARTING_COLUMN_POSITION() {
        return STARTING_COLUMN_POSITION;
    }
}
