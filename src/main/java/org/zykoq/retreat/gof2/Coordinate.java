package org.zykoq.retreat.gof2;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class Coordinate {
    private final int horizontal;
    private final int vertical;

    public Coordinate(int horizontal, int vertical) {

        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public Coordinate getNeighbour(Direction direction) {
        return new Coordinate(direction.shiftHorizontal(horizontal), direction.shiftVertical(vertical));
    }
}
