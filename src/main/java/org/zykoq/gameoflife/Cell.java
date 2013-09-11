package org.zykoq.gameoflife;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class Cell {
    private boolean alive;

    public Cell(boolean isAlive) {
        alive = isAlive;
    }

    public boolean isAlive() {
        return alive;
    }
}
