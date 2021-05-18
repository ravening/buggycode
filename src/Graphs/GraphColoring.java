package src.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/?ref=rp
 */
public class GraphColoring {

    public static void main(String[] args) {
        int n = 4;
        int [][] graph = {{ 0, 1, 1, 1 },{ 1, 0, 1, 0 },
                { 1, 1, 0, 1 },{ 1, 0, 1, 0 }};

        int max = 3;

        List<GraphEntry> nodes = new ArrayList<>();

        for (var i = 0; i < n; i++) {
            nodes.add(new GraphEntry());
        }

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                if (graph[i][j] > 0) {
                    nodes.get(i).edges.add(j);
                    nodes.get(j).edges.add(i);
                }
            }
        }

        System.out.println(solution(nodes, n, max));
    }

    public static boolean solution(List<GraphEntry> nodes, int n, int max) {
        for (var i = 0; i < n; i++) {
            nodes.get(i).visited = false;
            nodes.get(i).color = 1;
        }

        int maxColor = 1;
        for (var i = 0; i < n; i++) {
            if (nodes.get(i).visited) {
                continue;
            }
            Queue<GraphEntry> queue = new LinkedList<>();
            nodes.get(i).visited = true;
            queue.add(nodes.get(i));
            while (!queue.isEmpty()) {
                GraphEntry top = queue.poll();

                for (var j : top.edges) {
                    if (nodes.get(j).color == top.color) {
                        nodes.get(j).color += 1;
                    }

                    maxColor = Math.max(maxColor, Math.max(top.color, nodes.get(j).color));
                    if (maxColor > max) {
                        return false;
                    }

                    if (!nodes.get(j).visited) {
                        nodes.get(j).visited = true;
                        queue.add(nodes.get(j));
                    }

                }
            }
        }

        return true;
    }
}

class GraphEntry {
    int color;
    boolean visited;
    Set<Integer> edges = new HashSet<>();
}
