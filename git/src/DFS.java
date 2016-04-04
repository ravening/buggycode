/**
 Program to do the depth first search traversal of a graph
 * 
 */
import java.util.*;
/**
 * @author rvenkatesh
 *
 */
public class DFS {

	public boolean[] visited;
	public int N;
	public int[][] array;
	int root = 0;

	public DFS(int[][] mat) {
		N = mat.length;
		visited = new boolean[N];
		array = new int[N][N];
		
		for (int i =0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = mat[i][j];
			}
		}
	}
	
	public void clear() {
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
	}
	public void recursiveDfs(int i) {
		visited[i] = true;
		System.out.println(i + " ");
		for (int j =0; j < N; j++) {
			if (visited[j] == false && array[i][j] > 0) {
				visited[j] = true;
				recursiveDfs(j);
			}
		}
	}
	
	public void iterativeDfs(int i) {
		Stack<Integer> mystack = new Stack<Integer>();
		
		mystack.push(i);
		
		while (!mystack.isEmpty()) {
			int top = mystack.pop();
			visited[top] = true;
			System.out.println(top);
			
			for (int j =0; j < N; j++) {
				if (visited[j] == false && array[top][j] > 0) {
					visited[j] = true;
					mystack.push(j);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array = { {0, 1, 1, 0,0},
				{1, 0, 0, 1, 0},
				{1,0,0,1,1},
				{0,1,1,0,1},
				{0,0,1,1,0}
				
		};
		
		DFS root = new DFS(array);
		root.recursiveDfs(0);
		System.out.println();
		root.clear();
		root.iterativeDfs(0);
	}

}
