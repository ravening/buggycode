package src.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://www.geeksforgeeks.org/longest-path-in-a-directed-acyclic-graph-dynamic-programming/?ref=rp
 */
public class LongestPath {
    List<Integer>[] adjList;
    int V;
    LongestPath(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (var i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int y) {
        adjList[v].add(y);
    }

    public int longestPath() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        int[] dp = new int[V + 1];
        Arrays.fill(dp, 0);

        for (var i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, dp);
            }
        }

        int max = 0;

        for (var i = 0; i < V; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public void dfs(int i, boolean[] visited, int[] dp) {
        visited[i] = true;

        for (var j = 0; j < adjList[i].size(); j++) {
            if (!visited[adjList[i].get(j)]) {
                dfs(j, visited, dp);
            }

            dp[i] = Math.max(dp[i], 1 + dp[adjList[i].get(j)]);
        }
    }
}
