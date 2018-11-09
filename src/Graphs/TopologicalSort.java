package Graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    public int vertex;
    public LinkedList<Integer> [] adjList;

    public TopologicalSort(int vertex) {
        this.vertex = vertex;
        adjList = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                toppologicalSortUtil(i, visited, stack);
            }
        }
    }

    public void toppologicalSortUtil(int current, boolean[] visited, Stack<Integer> stack) {
        visited[current] = true;

        for (int i = 0; i < adjList[current].size(); i++) {
            int adj = adjList[current].get(i);
            if (!visited[adj]) {
                toppologicalSortUtil(adj, visited, stack);
            }
        }

        stack.push(current);
    }
}
