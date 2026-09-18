package com.satvik.dsa.arrays;

/**
 * <h2>Rotate Array (reversal algorithm)</h2>
 *
 * <p>Rotate an array left by {@code k} positions, in place and without extra storage.
 *
 * <p><b>Approach:</b> reverse the whole array, then reverse the first {@code n - k}
 * elements, then reverse the last {@code k}. Each element lands in its final slot after
 * exactly two swaps.
 *
 * <p>Time: O(n) &nbsp;|&nbsp; Space: O(1)
 */
public final class RotateArray {

    private RotateArray() {
    }

    /**
     * Rotates {@code arr} left by {@code k} positions, mutating it in place.
     * {@code k} is reduced modulo the array length, so values larger than the length
     * and negative values are both handled.
     */
    public static void rotateLeft(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        int shift = ((k % n) + n) % n;
        if (shift == 0) {
            return;
        }
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - shift - 1);
        reverse(arr, n - shift, n - 1);
    }

    private static void reverse(int[] arr, int from, int to) {
        while (from < to) {
            int temp = arr[from];
            arr[from++] = arr[to];
            arr[to--] = temp;
        }
    }
}
