package src.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean solution(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                if (!isValid(matrix, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] matrix, int row, int col) {
        return isValidRow(matrix, row) && isValidCol(matrix, col) && isValidBox(matrix, row - row % 3, col - col % 3);
    }

    private boolean isValidRow(int[][] matrix, int row) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (set.contains(matrix[row][i]))
                return false;

            set.add(matrix[row][i]);
        }

        return true;
    }

    private boolean isValidCol(int[][] matrix, int col) {
        Set<Integer> set = new HashSet<>();

        for (var i = 0; i < 9; i++) {
            if (set.contains(matrix[i][col]))
                return false;

            set.add(matrix[i][col]);
        }

        return true;
    }

    private boolean isValidBox(int[][] matrix, int startRow, int startCol) {
        Set<Integer> set = new HashSet<>();

        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                if (set.contains(matrix[i + startRow][j + startCol]))
                    return false;

                set.add(matrix[i + startRow][j + startCol]);
            }
        }

        return true;
    }
}
