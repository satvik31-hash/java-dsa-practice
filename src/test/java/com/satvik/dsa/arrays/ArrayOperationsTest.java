package com.satvik.dsa.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayOperationsTest {

    @Test
    @DisplayName("adds two arrays element by element")
    void addsElementWise() {
        assertArrayEquals(new int[]{7, 9, 11, 13, 15},
                ArrayOperations.elementWiseSum(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}));
    }

    @Test
    @DisplayName("multiplies two arrays element by element")
    void multipliesElementWise() {
        assertArrayEquals(new int[]{4, 10, 18},
                ArrayOperations.elementWiseProduct(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    @Test
    @DisplayName("the product of all elements does not overflow an int input range")
    void computesProduct() {
        assertEquals(120L, ArrayOperations.product(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1L, ArrayOperations.product(new int[]{}));
        assertEquals(0L, ArrayOperations.product(new int[]{5, 0, 7}));
    }

    @Test
    @DisplayName("finds the minimum and maximum, including negatives")
    void findsExtremes() {
        int[] arr = {4, -2, 9, 0};
        assertEquals(-2, ArrayOperations.min(arr));
        assertEquals(9, ArrayOperations.max(arr));
    }

    @Test
    @DisplayName("rejects mismatched lengths and empty input")
    void rejectsBadInput() {
        assertThrows(IllegalArgumentException.class,
                () -> ArrayOperations.elementWiseSum(new int[]{1}, new int[]{1, 2}));
        assertThrows(IllegalArgumentException.class,
                () -> ArrayOperations.min(new int[]{}));
    }
}
