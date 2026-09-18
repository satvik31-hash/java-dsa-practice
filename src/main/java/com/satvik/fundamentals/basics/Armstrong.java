package com.satvik.fundamentals.basics;

/**
 * Armstrong (narcissistic) number check.
 *
 * <p>A number is an Armstrong number when the sum of its digits, each raised to the power
 * of the digit count, equals the number itself. 153 has three digits and
 * {@code 1^3 + 5^3 + 3^3 = 153}.
 *
 * <p>Time: O(d) where {@code d} is the digit count &nbsp;|&nbsp; Space: O(1)
 */
public final class Armstrong {

    private Armstrong() {
    }

    public static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        }
        int digits = digitCount(number);
        int remaining = number;
        long sum = 0;
        while (remaining != 0) {
            sum += power(remaining % 10, digits);
            remaining /= 10;
            if (sum > number) {
                return false;
            }
        }
        return sum == number;
    }

    private static int digitCount(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    private static long power(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
