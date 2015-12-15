// node for a binary tree
class Node {
	public int data;
	public Node left, right;
	Node(int val) {
		this.left = this.right = null;
		this.data = val;
	}
}

public class balancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//construct a binary tree and call isBalanced(root, 0)
	}
	
	private class Result {
		boolean balanced;
		int depth;
		Result(boolean ans, int h) {
			this.balanced = ans;
			this.depth = h;
		}
	}
	public static Result isBalanced(Node node, int depth) {
		// if leaf node or only one node then return true
		if (node == null) {
			return new Result(true, depth);
		}
		
		//get the depth of left and right subtree
		Result left = isBalanced(node.left, depth + 1);
		Result right = isBalanced(node.right, depth + 1);
		
		//if either left or right subtree isnt balancede return false
		if (!left.balanced || !right.balanced) {
			return new Result(false, 0);
		}
		
		//if the height of the left and right subtree differs by more than 1
		//then return false
		if (Math.abs(left.depth - right.depth) > 1) {
			return new Result(false, 0);
		}
		
		return new Result(true, Math.max(left.depth, right.depth));
	}
}
