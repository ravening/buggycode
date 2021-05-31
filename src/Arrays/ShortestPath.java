package src.Arrays;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/shortest-path-from-a-source-cell-to-a-destination-cell-of-a-binary-matrix-through-cells-consisting-only-of-1s/?ref=rp
 */
public class ShortestPath {
    static int ROW;
    static int COL;

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static String solution(int[][] matrix, Point src, Point dest) {
        int[][] dist = new int[ROW][COL];
        boolean[][] visited = new boolean[ROW][COL];

        StringBuilder sb = new StringBuilder();
        dist[src.x][src.y] = 0;
        visited[src.x][src.y] = true;

        Queue<MatrixNode> queue = new ArrayDeque<>();
        MatrixNode node = new MatrixNode(src, 0);
        queue.add(node);

        while (!queue.isEmpty()) {
            MatrixNode tmp = queue.remove();
            Point point = tmp.getPoint();

            if (point.x == dest.x || point.y == dest.y) {
                int distance = tmp.distance;
                var xx = point.x;
                var yy = point.y;
                dist[xx][yy] = distance;

                while (xx != src.x || yy != src.y) {
                    if (xx > 0 && dist[xx-1][yy] == distance - 1) {
                        xx--;
                        sb.append("D");
                    }

                    if (xx < ROW && dist[xx+1][yy] == distance - 1) {
                        xx++;
                        sb.append("U");
                    }

                    if (yy > 0 && dist[xx][yy-1] == distance - 1) {
                        yy--;
                        sb.append("R");
                    }
                    if (yy < COL && dist[xx][yy + 1] == distance - 1) {
                        yy++;
                        sb.append("L");
                    }
                    distance--;
                }
                break;
            } else {
                for (var i = 0; i < ROW; i++) {
                    var ii = dRow[i] + point.x;
                    var jj = dCol[i] + point.y;
                    if (isValid(ii, jj) && !visited[ii][jj] && matrix[ii][jj] == 1) {
                        MatrixNode adj = new MatrixNode(new Point(ii, jj), tmp.distance + 1) ;
                        queue.add(adj);
                        dist[ii][jj] = tmp.distance + 1;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }

    public static boolean isValid(int x, int y) {
        return (x > 0) && (y > 0) && (x < ROW) && (y < COL);
    }

    public static void main(String[] args) {

    }
}

class MatrixNode {
    Point point;
    int distance;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public MatrixNode(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
