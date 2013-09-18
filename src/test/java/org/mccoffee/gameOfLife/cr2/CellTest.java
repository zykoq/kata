package org.mccoffee.gameOfLife.cr2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class CellTest {

    @Test
    public void testIsLivingCell() {
        Cell cell = new Cell(CellState.ALIVE);
        assertEquals(CellState.ALIVE, cell.getState());
    }

    @Test
    public void testIsDeadCell() {
        Cell cell = new Cell(CellState.DEAD);
        assertEquals(CellState.DEAD, cell.getState());
    }

    //@Test
    //public void knowMyBoard(){}
}
