package src.Arrays;

/**
 * @author rvenkatesh
 *
 *
 * Given a two dimensional array of size m*n filled with non negative values
 * find a path from top left to bottom right which minimizes the sum of all
 * values along the path
 */
public class MinPathSum {

	public static int minPath(int[][] grid) {
		if (grid.length == 0 || grid[0].length ==0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] matrix = new int[m][n];

		matrix[0][0]=grid[0][0];

		//initialize the top row
		for (int i = 1; i<m;i++) {
			matrix[i][0] = matrix[i-1][0] + grid[i][0];
		}

		//initialize the left column
		for (int i =1;i<n;i++) {
			matrix[0][i] = matrix[0][i-1] + grid[0][i];
		}

		for (int i=1;i<m;i++) {
			for (int j=1; j<n;j++) {
				matrix[i][j] = grid[i][j] + Math.min(matrix[i-1][j], matrix[i][j-1]);
			}
		}

		//return the last element
		return matrix[m-1][n-1];
	}
}
