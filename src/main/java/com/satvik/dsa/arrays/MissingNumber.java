package com.satvik.dsa.arrays;

/**
 * <h2>Missing Number</h2>
 *
 * <p>Given an array {@code arr} of size {@code n - 1} holding distinct integers in the
 * range {@code 1..n}, exactly one value from that range is absent. Return it.
 *
 * <p><b>Approach (sum formula):</b> the sum of {@code 1..n} is {@code n * (n + 1) / 2}.
 * Subtracting the actual array sum leaves the missing value.
 *
 * <p><b>Approach (XOR):</b> XOR of {@code 1..n} XORed with every array element cancels
 * each present value, leaving the missing one. Immune to integer overflow.
 *
 * <p>Time: O(n) &nbsp;|&nbsp; Space: O(1)
 */
public final class MissingNumber {

    private MissingNumber() {
    }

    /**
     * @param arr the {@code n - 1} present values
     * @param n   the upper bound of the range {@code 1..n}
     * @return the missing value
     * @throws IllegalArgumentException if the array length is not {@code n - 1}
     */
    public static int bySum(int[] arr, int n) {
        validate(arr, n);
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int value : arr) {
            actual += value;
        }
        return expected - actual;
    }

    /**
     * Overflow-safe variant. Same contract as {@link #bySum(int[], int)}.
     */
    public static int byXor(int[] arr, int n) {
        validate(arr, n);
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int value : arr) {
            xor ^= value;
        }
        return xor;
    }

    private static void validate(int[] arr, int n) {
        if (arr == null || arr.length != n - 1) {
            throw new IllegalArgumentException("Array must hold exactly n - 1 elements");
        }
    }
}
