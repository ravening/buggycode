// given a graph check if cycle exists or not
//https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-undirected-graph-using-dfs/

package Graphs;

import java.util.LinkedList;

public class DetectCycle {
    public int vertices;
    public LinkedList<Integer>[] adjList;

    public DetectCycle(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    public boolean DFS() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            // if the node is not visited then visit all its adjacent vertices
            if (!visited[i]) {
                // check if cycle exists for this vertex by passing parent
                // as -1. so if we encounter an already visited node
                // and its not the parent then there is a loop else there
                // is no loop
                if (cycleUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility function to find the cycle
    public boolean cycleUtil(int current, boolean[] visitied, int parent) {
        // mark current node as visited
        visitied[current] = true;

        //traverse all adjacent nodes for current node
        for (int i = 0; i < adjList[i].size(); i ++) {
            int vertex = adjList[current].get(i);
            // if this node is not parent then see if its already
            //visited or not
            if (vertex != parent) {
                // if this node is not parent and if its already visited
                // then we have a loop
                if (visitied[vertex] == true) {
                    return true;
                } else {
                    //traverse adjacent nodes of the current node
                    if (cycleUtil(vertex, visitied, current)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
