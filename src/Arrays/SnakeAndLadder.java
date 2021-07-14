package src.Arrays;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/snake-ladder-problem-2/
 */
public class SnakeAndLadder {
    public int solution(int[] moves, int target) {
        Queue<Entry> queue = new LinkedList<>();
        boolean[] visited = new boolean[target];

        visited[0] = true;

        Entry entry = new Entry(0, 0);
        queue.add(entry);

        while (!queue.isEmpty()) {
            entry = queue.poll();
            int v = entry.vertex;

            if (v == target - 1) {
                break;
            }
            for (var j = v + 1; j <= (v + 6) && j < target; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    int n = moves[j] != -1 ? moves[j] : j;
                    Entry next = new Entry(n, entry.distance + 1);
                    queue.add(next);
                }
            }
        }

        return entry.distance;
    }
}

class Entry {
    int vertex;
    int distance;

    public Entry(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}
