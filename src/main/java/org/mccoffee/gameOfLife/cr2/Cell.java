package org.mccoffee.gameOfLife.cr2;

/**
 *
 */
public class Cell {

    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }
}
