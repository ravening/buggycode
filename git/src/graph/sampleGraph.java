package graph;
import java.util.*;

public class sampleGraph {

	public HashMap<Integer, LinkedList<Integer>> adjacency;
	public int nodes;
	public sampleGraph(int x) {
		nodes = x;
		adjacency = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 1; i<= nodes; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			adjacency.put(i, list);
		}
	}
	
	public void insertEdge(int source, int dest) {
		if (source > nodes || dest > nodes) {
			return;
		}
		LinkedList<Integer> slist = adjacency.get(source);
		slist.add(dest);
		
		LinkedList<Integer> dlist = adjacency.get(dest);
		dlist.add(source);
	}
	
	public void displayGraph() {
		for (int i = 1; i<= nodes; i++) {
			System.out.print(i + "-> ");
			LinkedList<Integer> list = adjacency.get(i);
			for(int j: list) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sampleGraph graph = new sampleGraph(5);
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(1, 4);
		graph.insertEdge(1, 5);
		graph.insertEdge(2, 3);
		graph.insertEdge(2, 4);
		graph.insertEdge(3, 5);
		graph.insertEdge(4, 5);
		graph.displayGraph();
	}

}
