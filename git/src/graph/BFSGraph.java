package git.src.graph;

import java.util.*;
public class BFSGraph {

	public void levelorder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node n = q.remove();
			System.out.println(n.getdata());
			if (n.left != null) {
				q.add(n.left);
			}

			if (n.right != null) {
				q.add(n.right);
			}
		}
	}

	public void displayFirstAndLast (Node root) {
		Queue<Node> q = new LinkedList<Node>();
		int height = 1;
		q.add(root);

		while (!q.isEmpty()) {
			if (height == 1) {
				Node n = q.remove();
				System.out.println(n.getdata());
				if (n.left != null) {
					q.add(n.left);
				}

				if (n.right != null) {
					q.add(n.right);
				}

				height = height + 1;
			} else {
				Node n = q.remove();
				if (n.left != null) {
					q.add(n.left);
				}
				System.out.println(n.getdata());
				n = q.remove();
				if (n.right != null) {
					q.add(n.right);
				}
				System.out.println(n.getdata());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		BFSGraph bfs = new BFSGraph();
		bfs.displayFirstAndLast(root);
	}

}

class Node {
	private int data;
	Node left;
	Node right;

	Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}

	int getdata() {
		return this.data;
	}
}
