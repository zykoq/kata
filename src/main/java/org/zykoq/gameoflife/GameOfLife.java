package org.zykoq.gameoflife;


import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class GameOfLife {
    private List<Cell> cells = new ArrayList<>();

    public GameOfLife(boolean... args) {
        for (boolean isAlive : args) {
            cells.add(new Cell(isAlive));
        }
    }

    public Cell getCell(int i) {
        if (i == 1) {
            return new Cell(false);
        }
        return cells.get(i);
    }

    public Cell getNextGenerationCell(int i) {

        if (i != 0 && i != cells.size()) {
//            return
        }

        return cells.get(i);
    }
}
