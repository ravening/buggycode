package graph;
import java.util.*;

class Vertex {
	private int node;
	private boolean isVisited;
	public Vertex(int x) {
		node = x;
		isVisited = false;
	}
	
	public int getNode() {
		return node;
	}
	
	public void setNotVisited() {
		isVisited = false;
	}
	
	public void setVisited() {
		isVisited = true;
	}
	
	public boolean visited() {
		return isVisited == true;
	}
}

public class Graph {
	private Vertex vertexList[]; //list containing vertices of graph
	private int MAXVERTEX=5;
	private int count;
	private int[][] adjMatrix;
	
	public Graph() {
		vertexList = new Vertex[MAXVERTEX];
		count = 0;
		adjMatrix = new int[MAXVERTEX][MAXVERTEX];
	}
	
	public void addVertex(int x) {
		vertexList[count++] = new Vertex(x);
	}
	
	public void addEdge(int start, int end) {
		if (start < MAXVERTEX && end < MAXVERTEX) {
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
	}
	
	public void displayNode(int v) {
		System.out.println(vertexList[v].getNode());
	}
	
	public int getNotVisitedNode(int node) {
		for (int i =0; i<MAXVERTEX; i++) {
			if (adjMatrix[node][i] == 1 && !vertexList[i].visited()) {
				return i;
			}
			
		}
		return -1;
	}
	public void DFS(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		if ( v > MAXVERTEX) {
			return;
		}
		//mark the start node as visited
		vertexList[v].setVisited();
		displayNode(v);
		//push the first node to stack
		stack.push(v);
		
		//iterate while the stakc is not empty
		while (!stack.isEmpty()) {
			int node = getNotVisitedNode(stack.peek());
			
			if (node == -1) {
				stack.pop();
			} else {
				vertexList[node].setVisited();
				stack.push(node);
				displayNode(node);
			}
		}
		
		for (int j =0; j < MAXVERTEX; j++) {
			vertexList[j].setNotVisited();
		}
	}
	
	public void displayGraph() {
		for (int i =0; i< MAXVERTEX; i++) {
			System.out.print(vertexList[i].getNode() + "=>");
			for (int j =0; j<MAXVERTEX; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int noSuccessor() {
		//function to check if a node has successor or not
		//if there is no successor then we return that node.
		//if there is a successor we return -1 to indicate it has cycle
		
		boolean hasSuccessor = false;
		for (int i=0; i < MAXVERTEX; i++) {
			hasSuccessor = false;
			for (int j = 0; j<MAXVERTEX; j++) {
				if (adjMatrix[i][j] > 1) {
					hasSuccessor = true;
					break;
				}
				if (!hasSuccessor) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public void deleteNode(int node) {
		//function to delete a node which has no successors
		//base case
		
		if (node > MAXVERTEX) {
			return;
		}
		
		if (node != MAXVERTEX-1) {
			for (int i=node; i<MAXVERTEX-1; i++) {
				vertexList[i] = vertexList[i+1];
			}
			
			for (int i=node; i< MAXVERTEX-1;i++) {
				moveRowUp(i);
			}
			
			for (int i =node;i<MAXVERTEX-1;i++) {
				moveColumnLeft(i);
			}
		}
		count--;
	}
	
	public void moveRowUp(int node) {
		for (int i=node;i<MAXVERTEX-1;i++) {
			adjMatrix[node][i] = adjMatrix[node+1][i];
		}
	}
	
	public void moveColumnLeft(int node) {
		for (int i=0;i<MAXVERTEX;i++) {
			adjMatrix[i][node] = adjMatrix[i][node+1];
		}
	}
	public void topoSort() {
		int origVert = count;
		int[] sortedList = new int[MAXVERTEX];
		while (count > 0) {
			//get the node with no successor
			int node = noSuccessor();
			
			//if no such node exists, then graph has cycle
			if (node == -1) {
				System.out.println("graph has cycle");
				return;
			} else {
				sortedList[count-1] = node;
				deleteNode(node);
			}
		}
		
		count = origVert;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph theGraph = new Graph();
		theGraph.addVertex(0);
		theGraph.addVertex(1);
		theGraph.addVertex(2);
		theGraph.addVertex(3);
		theGraph.addVertex(4);
		
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		theGraph.DFS(0);
	}

}
