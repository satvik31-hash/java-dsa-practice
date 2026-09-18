package com.satvik.dsa.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateArrayTest {

    @Test
    @DisplayName("rotates left by k")
    void rotatesLeft() {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray.rotateLeft(arr, 2);
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, arr);
    }

    @Test
    @DisplayName("a rotation of the full length leaves the array unchanged")
    void fullRotationIsIdentity() {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray.rotateLeft(arr, 5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("k larger than the length wraps round")
    void wrapsLargeK() {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray.rotateLeft(arr, 7);
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, arr);
    }

    @Test
    @DisplayName("a negative k rotates the other way")
    void handlesNegativeK() {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray.rotateLeft(arr, -1);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, arr);
    }

    @Test
    @DisplayName("empty and single-element arrays are left alone")
    void handlesTinyArrays() {
        int[] empty = {};
        RotateArray.rotateLeft(empty, 3);
        assertArrayEquals(new int[]{}, empty);

        int[] single = {9};
        RotateArray.rotateLeft(single, 3);
        assertArrayEquals(new int[]{9}, single);
    }
}
