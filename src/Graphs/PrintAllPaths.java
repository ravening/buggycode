package src.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/print-paths-given-source-destination-using-bfs/
 */
public class PrintAllPaths {
    public static void printPath(List<Integer> path) {
        path.forEach(System.out::print);
    }

    public static boolean isvisited(List<Integer> path, int vertex) {
        Optional<Integer> optional = path.stream()
        .filter(x -> x == vertex)
        .findFirst()
        ;

        return optional.isPresent();
    }

    public static void findPaths(List<List<Integer>> adjList, int src, int dest) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();

        path.add(src);
        queue.add(path);

        while (!queue.isEmpty()) {
            path = queue.remove();

            int last = path.get(path.size() - 1);
            if (last == dest) {
                printPath(path);
            }

            List<Integer> adjacent = adjList.get(last);
            for (var i = 0; i < adjacent.size(); i++) {
                if (!isvisited(path, i)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(i);
                    queue.add(newPath);
                }
            }
        }
    }
}
