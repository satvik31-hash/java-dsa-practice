package com.satvik.dsa.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TwoSumTest {

    @Test
    @DisplayName("finds a pair including negative numbers")
    void findsPair() {
        int[] nums = {1, 3, -3, 5, 4};
        assertArrayEquals(new int[]{1, 2}, TwoSum.bruteForce(nums, 0));
        assertArrayEquals(new int[]{1, 2}, TwoSum.usingHashMap(nums, 0));
    }

    @Test
    @DisplayName("both approaches agree on a classic case")
    void approachesAgree() {
        int[] nums = {2, 7, 11, 15};
        assertArrayEquals(new int[]{0, 1}, TwoSum.bruteForce(nums, 9));
        assertArrayEquals(new int[]{0, 1}, TwoSum.usingHashMap(nums, 9));
    }

    @Test
    @DisplayName("returns null when no pair adds to the target")
    void returnsNullWhenNoPair() {
        int[] nums = {1, 2, 3};
        assertNull(TwoSum.bruteForce(nums, 100));
        assertNull(TwoSum.usingHashMap(nums, 100));
    }

    @Test
    @DisplayName("does not pair an element with itself")
    void doesNotReuseSameIndex() {
        int[] nums = {3, 1, 9};
        assertNull(TwoSum.bruteForce(nums, 6));
        assertNull(TwoSum.usingHashMap(nums, 6));
    }
}
