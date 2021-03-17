package src.Arrays;

/*
https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
public class RotateMatrixAntiClockWise {
    static void rotateMatrix(int[][] matrix) {
        int N = matrix.length;

        for (var x = 0; x < N / 2; x++) {
            for (var y = x; y < (N - x - 1); y++) {
                var temp = matrix[x][y];

                matrix[x][y] = matrix[y][N - x - 1];

                matrix[y][N - x - 1] = matrix[N -x - 1][N - y - 1];

                matrix[N - x - 1][N - y - 1] = matrix[N - 1 - y][x];

                matrix[N - 1 - y][x] = temp;
            }
        }
    }
}
