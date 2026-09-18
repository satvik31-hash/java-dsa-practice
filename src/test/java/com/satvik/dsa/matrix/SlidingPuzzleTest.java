package com.satvik.dsa.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SlidingPuzzleTest {

    private int[][] board() {
        return new int[][]{
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8}};
    }

    @Test
    @DisplayName("sliding up swaps the blank with the tile above it")
    void movesUp() {
        int[][] board = board();
        assertTrue(SlidingPuzzle.move(board, 'U'));
        assertArrayEquals(new int[]{0, 1}, SlidingPuzzle.findBlank(board));
        assertArrayEquals(new int[][]{{1, 0, 3}, {4, 2, 5}, {6, 7, 8}}, board);
    }

    @Test
    @DisplayName("accepts lower-case directions")
    void acceptsLowerCase() {
        int[][] board = board();
        assertTrue(SlidingPuzzle.move(board, 'r'));
        assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 0}, {6, 7, 8}}, board);
    }

    @Test
    @DisplayName("a move off the edge is refused and leaves the board untouched")
    void refusesMoveOffBoard() {
        int[][] board = {{0, 1}, {2, 3}};
        assertFalse(SlidingPuzzle.move(board, 'U'));
        assertArrayEquals(new int[][]{{0, 1}, {2, 3}}, board);
    }

    @Test
    @DisplayName("a move followed by its opposite restores the board")
    void moveAndUndoIsIdentity() {
        int[][] board = board();
        assertTrue(SlidingPuzzle.move(board, 'U'));
        assertTrue(SlidingPuzzle.move(board, 'D'));
        assertArrayEquals(board(), board);
    }

    @Test
    @DisplayName("a four-move loop returns the blank home but rotates the tiles around it")
    void loopReturnsBlankButPermutesTiles() {
        int[][] board = board();
        for (char direction : new char[]{'U', 'L', 'D', 'R'}) {
            assertTrue(SlidingPuzzle.move(board, direction));
        }
        assertArrayEquals(new int[]{1, 1}, SlidingPuzzle.findBlank(board));
        assertArrayEquals(new int[][]{{4, 1, 3}, {2, 0, 5}, {6, 7, 8}}, board);
    }

    @Test
    @DisplayName("rejects an unknown direction and a board with no blank")
    void rejectsBadInput() {
        assertThrows(IllegalArgumentException.class, () -> SlidingPuzzle.move(board(), 'X'));
        assertThrows(IllegalArgumentException.class,
                () -> SlidingPuzzle.move(new int[][]{{1, 2}, {3, 4}}, 'U'));
    }
}
