package src.Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSizeSubMatrix {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        solution(M);
    }
    public static void solution(int[][] array) {
        int[][] dp = new int[array.length][array[0].length];

        for (var arr : dp) {
            Arrays.fill(arr, 0);
        }
        for (var i = 0; i < array.length; i++) {
            dp[i][0] = array[i][0];
        }

        for (var i = 0 ; i < array[0].length; i++) {
            dp[0][i] = array[0][i];
        }

        int max = 0, maxI = 0, maxJ = 0;

        for (var i = 1; i < array.length; i++) {
            for (var j = 1; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }

        for (var i = 0; i < array.length; i++) {
            for (var j = 0; j < array[0].length; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println(max);

        for (var i = maxI; i > maxI - max; i--) {
            for (var j = maxJ; j > maxJ - max; j--) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
