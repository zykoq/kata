package org.zykoq.factorial;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class FactorialTest {

    private static final int[] RESULTS = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};


    @Test
    public void calcTill10() throws Exception {
        for (int i = 0; i < 11; i++) {
            assertEquals(RESULTS[i], Factorial.calculate(i));
        }
    }

    @Test
    public void calculate0() throws Exception {
        long expected = 1;
        assertEquals(expected, Factorial.calculate(0));
    }

    @Test
    public void calculate1() throws Exception {
        long expected = 1;
        assertEquals(expected, Factorial.calculate(1));
    }

    @Test
    public void calculate2() throws Exception {
        long expected = 2;
        assertEquals(expected, Factorial.calculate(2));
    }

    @Test
    public void calculate3() throws Exception {
        long expected = 6;
        assertEquals(expected, Factorial.calculate(3));
    }

    @Test
    public void calculate4() throws Exception {
        long expected = 24;
        assertEquals(expected, Factorial.calculate(4));
    }
}
