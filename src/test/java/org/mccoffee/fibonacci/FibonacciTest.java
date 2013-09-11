package org.mccoffee.fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FibonacciTest {
    public static final int FIBONACCI_OF_46 = 1836311903;
    public static final int FORTY_SIX = 46;

    @Test
    public void testFibonacciZero() {
        assertEquals(0, Fibonacci.fibonacciOf(0));
    }

    @Test
    public void testFibonacciOne() {
        assertEquals(1, Fibonacci.fibonacciOf(1));
    }

    @Test
    public void testFibonacciTwo() {
        assertEquals(1, Fibonacci.fibonacciOf(2));
    }

    @Test
    public void testFibonacciThree() {
        assertEquals(2, Fibonacci.fibonacciOf(3));
    }

    @Test
    public void testFibonacci46() {
        assertEquals(FIBONACCI_OF_46, Fibonacci.fibonacciOf(FORTY_SIX));
    }

}
