package com.theodor.app.grid;

public class GridCell<E> {
    private final CellPosition pos;
    private final E value;

    public GridCell(CellPosition pos, E value) {
        this.pos = pos;
        this.value = value;
    }

    public CellPosition getPos() {
        return pos;
    }

    public E getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridCell<?> gridCell = (GridCell<?>) o;

        if (!pos.equals(gridCell.pos)) return false;
        return value.equals(gridCell.value);
    }

    @Override
    public int hashCode() {
        int result = pos.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GridCell{" +
                "pos=" + pos +
                ", value=" + value +
                '}';
    }
}
