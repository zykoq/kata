package org.zykoq.retreat.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class BoardTest {

    @Test
    public void boardCreated() {
        Board board = new Board(Status.DEAD);
        assertTrue(board.isNotEmpty());
    }

    @Test
    public void boardCellIsAlive() {
        Board board = new Board(Status.ALIVE);
//        assertEquals(Status.ALIVE, board.getCell(0).getStatus());
    }

    @Test
    public void boardCellIsDead() {
        Board board = new Board(Status.DEAD);
        assertEquals(Status.DEAD, board.getCell(0).getStatus());
    }

    @Test
    public void getNeighbours() {
        Board board = new Board(Status.DEAD, Status.ALIVE);
        assertEquals(Status.DEAD, board.getCell(0).getStatus());
        assertEquals(Status.ALIVE, board.getCell(1).getStatus());

    }
}
