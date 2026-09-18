package com.satvik.fundamentals.basics;

/** Largest of three numbers, by running comparison rather than a chain of conditions. */
public final class MaxOfThree {

    private MaxOfThree() {
    }

    public static int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
