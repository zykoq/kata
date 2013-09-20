package org.zykoq.retreat.gof2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class CoordinateTest {

    @Test
    public void testHorizontal() {
        assertEquals(5, new Coordinate(5, 7).getHorizontal());
    }

    @Test
    public void testHorizontal2() {
        assertEquals(8, new Coordinate(8, 7).getHorizontal());
    }

    @Test
    public void testNeighbour() {
        Direction direction = Direction.UPPER;
        Coordinate upper = new Coordinate(6, 287).getNeighbour(direction);
        assertEquals(6, upper.getHorizontal());
        assertEquals(286, upper.getVertical());
    }

    @Test
    public void testNeighbour_001() {
        testNeighbour(Direction.UPPER, 6, 287);
    }

    @Test
    public void testNeighbour_002() {
        testNeighbour(Direction.UPPER, -76, 23);
    }

    @Test
    public void testNeighbour_003() {
        testNeighbour(Direction.LOWER_LEFT, -76, 23);
    }

    private static void testNeighbour(Direction direction, int horizontal, int vertical) {
        Coordinate upper = new Coordinate(horizontal, vertical).getNeighbour(direction);
        assertEquals(direction.shiftHorizontal(horizontal), upper.getHorizontal());
        assertEquals(direction.shiftVertical(vertical), upper.getVertical());
    }

    @Test
    public void testVertical() {
        assertEquals(4, new Coordinate(8, 4).getVertical());
    }
}
