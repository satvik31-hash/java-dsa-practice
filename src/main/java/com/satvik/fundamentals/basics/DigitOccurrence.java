package com.satvik.fundamentals.basics;

/** Counts how many times a digit appears in the decimal form of a number. */
public final class DigitOccurrence {

    private DigitOccurrence() {
    }

    /**
     * @param number the number to scan; the sign is ignored
     * @param digit  the digit to count, {@code 0..9}
     */
    public static int count(int number, int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Digit must be between 0 and 9");
        }
        int remaining = Math.abs(number);
        if (remaining == 0) {
            return digit == 0 ? 1 : 0;
        }
        int count = 0;
        while (remaining != 0) {
            if (remaining % 10 == digit) {
                count++;
            }
            remaining /= 10;
        }
        return count;
    }
}
