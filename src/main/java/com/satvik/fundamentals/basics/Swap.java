package com.satvik.fundamentals.basics;

/**
 * Swapping two values.
 *
 * <p>Java passes primitives by value, so a method cannot swap its caller's variables.
 * The pair is returned instead, which is the idiomatic way to express this.
 */
public final class Swap {

    private Swap() {
    }

    /** @return {@code {b, a}} */
    public static double[] swap(double a, double b) {
        return new double[]{b, a};
    }

    /** Swaps two positions of an array in place. */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
