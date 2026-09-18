package com.satvik.dsa.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MissingNumberTest {

    @Test
    @DisplayName("finds the missing value in an unsorted permutation")
    void findsMissingValue() {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        assertEquals(6, MissingNumber.bySum(arr, 8));
        assertEquals(6, MissingNumber.byXor(arr, 8));
    }

    @Test
    @DisplayName("handles the missing value being the first or last of the range")
    void findsBoundaryValues() {
        assertEquals(1, MissingNumber.bySum(new int[]{2, 3, 4}, 4));
        assertEquals(4, MissingNumber.bySum(new int[]{1, 2, 3}, 4));
        assertEquals(1, MissingNumber.byXor(new int[]{2, 3, 4}, 4));
        assertEquals(4, MissingNumber.byXor(new int[]{1, 2, 3}, 4));
    }

    @Test
    @DisplayName("a single-element range returns the only value")
    void handlesSmallestRange() {
        assertEquals(1, MissingNumber.bySum(new int[]{}, 1));
    }

    @Test
    @DisplayName("rejects an array of the wrong length")
    void rejectsWrongLength() {
        assertThrows(IllegalArgumentException.class,
                () -> MissingNumber.bySum(new int[]{1, 2, 3}, 8));
        assertThrows(IllegalArgumentException.class,
                () -> MissingNumber.byXor(null, 4));
    }
}
