import java.util.Stack;

class Node {
	public int data;
	public Node left;
	public Node right;
	
	public Node() {
		this.data = 0;
		this.right = this.left = null;
	}
	
	public Node(int val) {
		this.data = val;
		this.left = this.right = null;
	}
}

public class displayBoundary {
	public void displayCircumference(Node root) {
		if (root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> rightside = new Stack<Node>();
		boolean printleaf = false;
		
		Node node = root;
		
		while (node != null) {
			if (stack.isEmpty() && printleaf &&
				(node.left != null || node.right != null)) {
				rightside.push(node);
			}
			
			if (node.left == null && node.right == null) {
				printleaf = true;
				System.out.println(node.data);
				node = stack.isEmpty() ? null : stack.pop();
			} else {
				if (!printleaf) {
					System.out.println(node.data);
				}
				
				if (node.left != null && node.right != null) {
					stack.push(node.right);
				}
				
				node = node.left != null ? node.left : node.right;
			}
		}
		
		while (!rightside.isEmpty()) {
			System.out.println(rightside.pop());
		}
	}
}
