package com.satvik.fundamentals.basics;

/**
 * Primality test by trial division.
 *
 * <p>A composite {@code n} always has a factor at or below {@code sqrt(n)}, so the loop
 * stops there. Written as {@code i * i <= n} to avoid a floating-point square root.
 *
 * <p>Time: O(sqrt n) &nbsp;|&nbsp; Space: O(1)
 */
public final class PrimeNumber {

    private PrimeNumber() {
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
