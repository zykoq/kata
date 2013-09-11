package org.zykoq.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class GameOfLifeTest {

    @Test
    public void getCellTest() {
        Cell cell = new GameOfLife(true).getCell(0);
        assertTrue(cell.isAlive());

    }

    @Test
    public void getDeadCellTest() {
        Cell cell = new GameOfLife(false).getCell(1);
        assertFalse(cell.isAlive());
    }

    @Test
    public void isNextGenerationNotAlive() {
        GameOfLife game = new GameOfLife(false, false);
        Cell cell = game.getNextGenerationCell(0);
        assertFalse(cell.isAlive());
        cell = game.getNextGenerationCell(1);
        assertFalse(cell.isAlive());
    }

    @Test
    public void isNextGenerationAlive() {
        GameOfLife game = new GameOfLife(true, true, true);
        Cell cell1 = game.getNextGenerationCell(0);
        Cell cell2 = game.getNextGenerationCell(1);
        Cell cell3 = game.getNextGenerationCell(2);
        assertTrue(cell1.isAlive());
        assertTrue(cell2.isAlive());
        assertTrue(cell3.isAlive());

    }

    @Test
    public void isNextGenerationDead() {
        GameOfLife game = new GameOfLife(true, true, false);
        Cell cell1 = game.getNextGenerationCell(0);
        Cell cell2 = game.getNextGenerationCell(1);
        Cell cell3 = game.getNextGenerationCell(2);
//        assertFalse(cell1.isAlive());
//        assertFalse(cell2.isAlive());
        assertFalse(cell3.isAlive());

    }

}
