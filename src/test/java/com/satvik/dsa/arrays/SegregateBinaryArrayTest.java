package com.satvik.dsa.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SegregateBinaryArrayTest {

    @Test
    @DisplayName("moves every zero ahead of every one")
    void segregatesMixedArray() {
        int[] byCounting = {0, 0, 1, 0, 1, 1, 0};
        SegregateBinaryArray.byCounting(byCounting);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 1, 1}, byCounting);

        int[] byPointers = {0, 0, 1, 0, 1, 1, 0};
        SegregateBinaryArray.byTwoPointers(byPointers);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 1, 1}, byPointers);
    }

    @Test
    @DisplayName("an already sorted array is unchanged")
    void handlesSortedInput() {
        int[] arr = {0, 0, 1, 1};
        SegregateBinaryArray.byTwoPointers(arr);
        assertArrayEquals(new int[]{0, 0, 1, 1}, arr);
    }

    @Test
    @DisplayName("handles all-zero, all-one and empty arrays")
    void handlesUniformArrays() {
        int[] zeroes = {0, 0, 0};
        SegregateBinaryArray.byCounting(zeroes);
        assertArrayEquals(new int[]{0, 0, 0}, zeroes);

        int[] ones = {1, 1, 1};
        SegregateBinaryArray.byCounting(ones);
        assertArrayEquals(new int[]{1, 1, 1}, ones);

        int[] empty = {};
        SegregateBinaryArray.byCounting(empty);
        assertArrayEquals(new int[]{}, empty);
    }

    @Test
    @DisplayName("rejects values other than 0 and 1")
    void rejectsNonBinaryValues() {
        assertThrows(IllegalArgumentException.class,
                () -> SegregateBinaryArray.byCounting(new int[]{0, 2, 1}));
    }
}
