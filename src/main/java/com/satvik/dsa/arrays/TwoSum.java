package com.satvik.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Two Sum</h2>
 *
 * <p>Given an array of integers and a target, return the indices of the two values that
 * add up to the target, or {@code null} when no such pair exists.
 *
 * <p><b>Brute force:</b> test every pair. Time O(n^2), space O(1).
 * <p><b>Hash map:</b> for each value, look up its complement in a map of values already
 * seen. Time O(n), space O(n).
 */
public final class TwoSum {

    private TwoSum() {
    }

    /**
     * @return a two-element array {@code {i, j}} with {@code i < j}, or {@code null}
     */
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Single-pass hash map solution. Same contract as {@link #bruteForce(int[], int)}.
     */
    public static int[] usingHashMap(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer previous = seen.get(target - nums[i]);
            if (previous != null) {
                return new int[]{previous, i};
            }
            seen.put(nums[i], i);
        }
        return null;
    }
}
