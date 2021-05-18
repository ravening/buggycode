package src.Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/count-total-ways-to-reach-destination-from-source-in-an-undirected-graph/?ref=rp
 */
public class TotalPaths {
    public static int totalPaths(int[][] matrix, int src, int dest, int totalVertex) {
        int[] visited = new int[totalVertex];
        Arrays.fill(visited, -1);
        return dfs(matrix, src, dest, visited, totalVertex);
    }

    public static int dfs(int[][] matrix, int src, int dest, int[] visited, int totalVertex) {
        if (src == dest)
            return 1;

        int total = 0;

        for (int j = 0; j < totalVertex; j++) {
            if (matrix[src][j] == 1 && visited[j] != 1) {
                visited[j] = 1;
                total += dfs(matrix, j, dest, visited, totalVertex);
                visited[j] = 0;
            }
        }

        return total;
    }
}
