package com.satvik.dsa.matrix;

/**
 * <h2>Sliding Puzzle board</h2>
 *
 * <p>An n x n board holding the values {@code 0..n*n-1}, where {@code 0} is the blank
 * tile. A move slides the blank one square in the given direction, which is the same as
 * swapping the blank with its neighbour.
 *
 * <p><b>Approach:</b> locate the blank, compute the target square, reject it if it falls
 * outside the board, otherwise swap.
 *
 * <p>Time: O(n^2) to locate the blank &nbsp;|&nbsp; Space: O(1)
 */
public final class SlidingPuzzle {

    /** The value representing the blank square. */
    public static final int BLANK = 0;

    private SlidingPuzzle() {
    }

    /**
     * Slides the blank tile one square in {@code direction}, mutating {@code board}.
     *
     * @param direction one of {@code U}, {@code D}, {@code L}, {@code R} (case-insensitive)
     * @return {@code true} if the move was applied, {@code false} if it would leave the board
     * @throws IllegalArgumentException if the board has no blank or the direction is unknown
     */
    public static boolean move(int[][] board, char direction) {
        int[] blank = findBlank(board);
        int row = blank[0];
        int column = blank[1];

        int targetRow = row;
        int targetColumn = column;

        switch (Character.toUpperCase(direction)) {
            case 'U' -> targetRow--;
            case 'D' -> targetRow++;
            case 'L' -> targetColumn--;
            case 'R' -> targetColumn++;
            default -> throw new IllegalArgumentException("Direction must be U, D, L or R");
        }

        if (targetRow < 0 || targetRow >= board.length
                || targetColumn < 0 || targetColumn >= board[targetRow].length) {
            return false;
        }

        board[row][column] = board[targetRow][targetColumn];
        board[targetRow][targetColumn] = BLANK;
        return true;
    }

    /** @return the {@code {row, column}} of the blank square */
    public static int[] findBlank(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == BLANK) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Board has no blank square");
    }

    /** @return the board rendered as rows of space-separated values */
    public static String render(int[][] board) {
        StringBuilder out = new StringBuilder();
        for (int[] row : board) {
            for (int j = 0; j < row.length; j++) {
                if (j > 0) {
                    out.append(' ');
                }
                out.append(row[j]);
            }
            out.append(System.lineSeparator());
        }
        return out.toString();
    }
}
