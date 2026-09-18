package com.satvik.fundamentals.basics;

/**
 * Fibonacci series, iteratively.
 *
 * <p>Keeps only the previous two terms, so memory does not grow with the series.
 * Returns {@code long} because the sequence passes {@code Integer.MAX_VALUE} at term 47.
 *
 * <p>Time: O(n) &nbsp;|&nbsp; Space: O(n) for the returned array, O(1) working storage.
 */
public final class Fibonacci {

    private Fibonacci() {
    }

    /** @return the first {@code count} terms, starting {@code 0, 1, 1, 2, 3, ...} */
    public static long[] series(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must not be negative");
        }
        long[] series = new long[count];
        long previous = 0;
        long current = 1;
        for (int i = 0; i < count; i++) {
            series[i] = previous;
            long next = previous + current;
            previous = current;
            current = next;
        }
        return series;
    }

    /** @return the {@code n}th term, zero-indexed */
    public static long nth(int n) {
        long[] series = series(n + 1);
        return series[n];
    }
}
