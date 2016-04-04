package binarySearchTree;

class TreeNode {
	public int data;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) {
		data = x;
		parent = left = right = null;
	}
}

public class LcaParentPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the root for the tree
		
	}
	
	public static int depth(TreeNode node) {
		int d = 0;
		
		while (node != null) {
			node = node.parent;
			d = d + 1;
		}
		return d;
	}
	
	public static TreeNode insert(TreeNode root, int x) {
		//if the tree is empty, create new node and return
		if (root == null) {
			return new TreeNode(x);
		}
		
		//if inserting value is less than root, insert it at left side
		if (x < root.data) {
			root.left = insert(root.left, x);
			root.left.parent = root;
		} else {
			root.right = insert(root.right, x);
			root.right.parent = root;
		}
		
		return root;
	}
	
	public static int LCA(TreeNode node1, TreeNode node2) {
		//base case. if either of the node doesnt exist, then
		//there is no LCA
		
		if (node1 == null || node2 == null) {
			return 0;
		}
		
		//get the depth diff between two nodes
		int d1, d2, diff;
		
		d1 = depth(node1);
		d2 = depth(node2);
		
		diff = d1 - d2;
		
		//swap the nodes if the diff is < 0
		if (diff < 0) {
			diff = -diff;
			TreeNode tmp = node1;
			node1 = node2;
			node2 = tmp;
		}
		
		//bring the two nodes to the same level by moving
		//the node at the deeper level up
		while (diff > 0) {
			node1 = node1.parent;
			diff = diff - 1;
		}
		
		//now check for the LCA. if the value of the two nodes is
		//same, then its the LCA
		while (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				return node1.data;
			} else {
				node1= node1.parent;
				node2 = node2.parent;
			}
			
		}
		return 0;
	}
}
