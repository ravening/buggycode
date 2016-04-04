package binarySearchTree;

//Class for tree node
class TreeNodes {
	public int data;
	
	//parent pointer
	public TreeNodes parent;
	
	public TreeNodes left, right;
	
	//constructor
	public TreeNodes(int x) {
		data = x;
		parent = left = right = null;
	}
}

public class treeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// function to get the depth of a node in a tree
	public static int depth(TreeNode root) {
		//base case when tree is empty
		if (root == null) {
			return 0;
		}
		
		int d = 0;
		
		//traverse from the node till the root of the tree
		while(root != null) {
			root = root.parent;
			d = d + 1;
		}
		
		return d;
	}
	
	//function to insert nodes in a binary search tree
	public static TreeNode insert(TreeNode node, int x) {
		//create a node if tree is empty
		if (node == null) {
			return new TreeNode(x);
		}
		
		//if the value to be inserted is less than the root,
		//insert it into the left child else right child
		if (x < node.data) {
			node.left = insert(node.left, x);
			node.left.parent = node;
		} else {
			node.right = insert(node.right, x);
			node.right.parent = node;
		}
		return node;
	}
	
	//function to traverse the tree without using stack or recursion
	public static void traverse(TreeNode root) {
		//if tree is empty, return
		if (root == null) {
			return;
		}
		
		//maintain a variable to indicate if we have traversed
		//left subtree of a particular node
		boolean leftDone = false;
		
		while (root != null) {
			//if we have not traversed the left subtree of the current
			//node traverse it first
			if (!leftDone) {
				while (root.left != null) {
					root = root.left;
				}
			}
			
			System.out.print(root.data + " ");
			
			//we visited the left most subtree
			leftDone = true;
			
			//visit the right subtree of the current node if exists
			if (root.right != null) {
				root = root.right;
				
				//indicate that we have to visit the left subtree again
				leftDone = false;
			}
			
			//we are done with the current node. visit its parent
			if (root.parent != null) {
				//if this node was the right child, then visit parent's parent
				//as parent is already visited
				while (root != null && (root.parent.right == root)) {
					root = root.parent;
				}
				
				//if we are at the root, break
				if (root == null) break;
				
				//visit its parent
				root = root.parent;
			} else {
				break;
			}
		}
	}
}
