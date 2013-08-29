package org.zykoq.fibonacci;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class FibonacciTest {

    private static final int[] RESULTS = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};

    @Test
    public void depthTill15() {
        for (int i = 0; i <= 15; i++) {
            testDepth(RESULTS[i], i);
        }
    }

    @Test
    public void depth0() throws Exception {
        testDepth(0, 0);
    }

    @Test
    public void depth1() throws Exception {
        testDepth(1, 1);
    }

    @Test
    public void depth2() throws Exception {
        testDepth(1, 2);
    }

    @Test
    public void depth3() throws Exception {
        testDepth(2, 3);
    }

    @Test
    public void depth4() throws Exception {
        testDepth(3, 4);
    }

    @Test
    public void depth5() throws Exception {
        testDepth(5, 5);
    }

    @Test
    public void depth6() throws Exception {
        testDepth(8, 6);
    }

    @Test
    public void depth7() throws Exception {
        testDepth(13, 7);
    }

    @Test
    public void depth8() throws Exception {
        testDepth(21, 8);
    }

    @Test
    public void depth9() throws Exception {
        testDepth(34, 9);
    }

    private void testDepth(int expected, int depth) {
        int result = Fibonacci.retrieveFibonacciResult(depth);
        assertEquals(expected, result);
    }
}
