package com.satvik.dsa.arrays;

/**
 * <h2>Elementary array traversals</h2>
 *
 * <p>Single-pass warm-up operations: element-wise sum and product of two equal-length
 * arrays, the product of one array, and its minimum.
 *
 * <p>Time: O(n) each &nbsp;|&nbsp; Space: O(1), or O(n) where a new array is returned.
 */
public final class ArrayOperations {

    private ArrayOperations() {
    }

    /** @return a new array where index {@code i} holds {@code a[i] + b[i]} */
    public static int[] elementWiseSum(int[] a, int[] b) {
        requireSameLength(a, b);
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    /** @return a new array where index {@code i} holds {@code a[i] * b[i]} */
    public static int[] elementWiseProduct(int[] a, int[] b) {
        requireSameLength(a, b);
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * b[i];
        }
        return result;
    }

    /**
     * @return the product of every element, as a {@code long} so that moderately sized
     *         inputs do not silently overflow. The product of an empty array is 1.
     */
    public static long product(int[] arr) {
        long product = 1;
        for (int value : arr) {
            product *= value;
        }
        return product;
    }

    /** @return the smallest element */
    public static int min(int[] arr) {
        requireNonEmpty(arr);
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /** @return the largest element */
    public static int max(int[] arr) {
        requireNonEmpty(arr);
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void requireSameLength(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            throw new IllegalArgumentException("Arrays must be non-null and the same length");
        }
    }

    private static void requireNonEmpty(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must be non-empty");
        }
    }
}
