package org.mccoffee.fibonacci;

/**
 * This class calculates the nth fibonacci number
 */
public class Fibonacci {

    public static int fibonacciOf(final int number) {
        final int result;
        if(number == 0)
        {
            result = 0;
        } else if (number == 1) {
            result = 1;
        } else {
            result = fibonacciOf(number - 1) + fibonacciOf(number - 2);
        }
        return result;
    }
}
