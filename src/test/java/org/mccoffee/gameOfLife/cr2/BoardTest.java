package org.mccoffee.gameOfLife.cr2;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {


    @Test
    public void testNextGeneration() {
        Board board0 = initialBoard();
        Board board1 = board0.nextGeneration();
        assertTrue(isValidSuccessor(board0, board1));
    }

    private boolean isValidSuccessor(Board predecessor, Board actual) {
        for(int x = 0; x < predecessor.getWidth(); ++x)
            for(int y = 0; y < predecessor.getHeight(); ++y)
                if(!isValidSuccessor(predecessor.getCell(x, y), actual.getCell(x, y)))
                    return false;
        return true;
    }

    private Board initialBoard() {
        return new Board();
    }
}
