package com.satvik.dsa.arrays;

/**
 * <h2>Segregate 0s and 1s</h2>
 *
 * <p>Rearrange a binary array so that every 0 precedes every 1.
 *
 * <p><b>Counting:</b> count the zeroes in one pass, then overwrite the array with that
 * many zeroes followed by ones. Two passes, no extra storage.
 * <p><b>Two pointers:</b> walk a pointer in from each end and swap a misplaced pair.
 * One pass, and it preserves the "move elements, don't overwrite them" property that
 * matters when the array holds objects rather than plain 0/1 values.
 *
 * <p>Time: O(n) &nbsp;|&nbsp; Space: O(1)
 */
public final class SegregateBinaryArray {

    private SegregateBinaryArray() {
    }

    /** Counting approach, in place. */
    public static void byCounting(int[] arr) {
        int zeroes = 0;
        for (int value : arr) {
            requireBinary(value);
            if (value == 0) {
                zeroes++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < zeroes ? 0 : 1;
        }
    }

    /** Two-pointer approach, in place, single pass. */
    public static void byTwoPointers(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            requireBinary(arr[left]);
            requireBinary(arr[right]);
            if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            } else {
                arr[left++] = 0;
                arr[right--] = 1;
            }
        }
    }

    private static void requireBinary(int value) {
        if (value != 0 && value != 1) {
            throw new IllegalArgumentException("Array must contain only 0 and 1, found " + value);
        }
    }
}
