import java.util.Stack;

class Nodes {
	public int data;
	public Nodes left;
	public Nodes right;
	
	public Nodes() {
		this.data = 0;
		this.right = this.left = null;
	}
	
	public Nodes(int val) {
		this.data = val;
		this.left = this.right = null;
	}
}

public class displayBoundary {
	public void displayCircumference(Nodes root) {
		if (root == null) {
			return;
		}
		
		Stack<Nodes> stack = new Stack<Nodes>();
		Stack<Nodes> rightside = new Stack<Nodes>();
		boolean printleaf = false;
		
		Nodes node = root;
		
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
