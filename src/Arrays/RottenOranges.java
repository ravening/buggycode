package src.Arrays;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://medium.com/trick-the-interviwer/rotting-oranges-e09ca22f6e24
 */
public class RottenOranges {
    private int[] X = new int[]{-1,1,0,0};
    private int[] Y = new int[]{0,0, -1,1};

    private boolean isValidGrid(int x, int y, int row, int col) {
        return (x >=0 && y >= 0 && x < row && y < col);
    }

    public int solution(int[][] grid) {
        if (grid == null)
            return 0;

        int freshOranges = 0;
        int time = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * grid[0].length + j);
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        if (queue.isEmpty())
            return -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int top = queue.poll();
                int x = top / grid[0].length;
                int y = top % grid[0].length;

                // verify the neighbour oranges
                for (var i = 0; i < 4; i++) {
                    int newR = x + X[i];
                    int newC = y + Y[i];

                    if (isValidGrid(newR, newC, grid.length, grid[0].length) && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        freshOranges--;
                        queue.add(newR * grid[0].length + newC);
                    }
                }
            }

            if (queue.size() > 0)
                time++;
        }

        return freshOranges == 0 ? time : -1;
    }
}
