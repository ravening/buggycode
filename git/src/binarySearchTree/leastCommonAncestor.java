class BTNode {
	public int data;
	public BTNode left;
	public BTNode right;
	
	public BTNode() {
		this.data = 0;
		this.left = this.right = null;
	}
	
	public BTNode(int val) {
		this.data = val;
		this.left = this.right = null;
	}
}

public class leastCommonAncestor {
	public BTNode LCA(BTNode root, BTNode a, BTNode b) {
		// base case if tree is empty
		if (root == null) {
			return null;
		}
		
		// if root matches one of the node, return root
		if (root == a || root == b) {
			return root;
		}
		
		// recursively traverse the trees
		BTNode left = LCA(root.left, a, b);
		BTNode right = LCA(root.right, a, b);
		
		if (left != null && right != null) {
			return root;
		}
		
		return (left == null) ? right: left;
	}
}
