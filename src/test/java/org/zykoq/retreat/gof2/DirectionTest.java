package org.zykoq.retreat.gof2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class DirectionTest {

    @Test
    public void testShiftVertical() {
        testShiftVertical(Direction.UPPER, 5, 4);
        testShiftVertical(Direction.LOWER_LEFT, 5, 6);
    }

    private void testShiftVertical(Direction direction, int input, int expectation) {
        assertEquals(expectation, direction.shiftVertical(input));
    }

    @Test
    public void testShiftHorizontal() {
        testShiftHorizontal(Direction.UPPER, 5, 5);
        testShiftHorizontal(Direction.LOWER_LEFT, 5, 4);
    }

    private void testShiftHorizontal(Direction direction, int input, int expectation) {
        assertEquals(expectation, direction.shiftHorizontal(input));
    }
}
