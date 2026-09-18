package com.satvik.fundamentals.basics;

/**
 * Reverses the decimal digits of an integer.
 *
 * <p>Repeatedly peel the last digit with {@code % 10} and push it onto the accumulator
 * with {@code result * 10 + digit}. Negative inputs keep their sign.
 *
 * <p>Time: O(log n) in the value, i.e. one step per digit.
 */
public final class ReverseNumber {

    private ReverseNumber() {
    }

    public static int reverse(int number) {
        int sign = number < 0 ? -1 : 1;
        int remaining = Math.abs(number);
        int reversed = 0;
        while (remaining != 0) {
            reversed = reversed * 10 + remaining % 10;
            remaining /= 10;
        }
        return sign * reversed;
    }
}
