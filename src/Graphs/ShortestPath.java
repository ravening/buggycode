package src.Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/?ref=rp
 */
public class ShortestPath {
    LinkedList<AdjNode>[] adjList;
    int V;

    ShortestPath(int v) {
        V = v;
        adjList = new LinkedList[V];
        for (var i = 0; i < V; i ++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void shortestPath() {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (var i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            int node = stack.pop();

            Iterator<AdjNode> iterator = adjList[node].iterator();
            while (iterator.hasNext()) {
                AdjNode adjNode = iterator.next();

                if (dist[adjNode.v] > dist[node] + adjNode.weight) {
                    dist[adjNode.v] = dist[node] + adjNode.weight;
                }
            }
        }
    }

    public void topologicalSort(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        Iterator<AdjNode> iterator = adjList[node].iterator();
        while (iterator.hasNext()) {
            AdjNode node1 = iterator.next();
            if (!visited[node1.v]) {
                topologicalSort(node1.v, visited, stack);
            }
        }

        stack.push(node);
    }
}

class AdjNode {
    int v;
    int weight;

    public AdjNode(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}
