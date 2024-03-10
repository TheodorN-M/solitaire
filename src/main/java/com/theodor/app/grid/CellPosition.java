package com.theodor.app.grid;

public class CellPosition {
    private final int row;
    private final int col;

    public CellPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellPosition)) return false;
        CellPosition that = (CellPosition) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "CellPosition{" +
               "row=" + row +
               ", col=" + col +
               '}';
    }
}
