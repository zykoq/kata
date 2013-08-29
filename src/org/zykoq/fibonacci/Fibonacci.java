package org.zykoq.fibonacci;

/**
 * @author <a href="mailto:mr@mobi4friends.de">Maarten Roowaan</a>
 */
public class Fibonacci {

    public static int retrieveFibonacciResult(int depth) {
        if (depth == 0) {
            return 0;
        } else if (depth <= 2) {
            return 1;
        }
        return retrieveFibonacciResult(depth - 1) + retrieveFibonacciResult(depth - 2);
    }
}
