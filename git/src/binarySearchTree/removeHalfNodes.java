package binarySearchTree;

class tnode {
	public int val;
	public tnode left, right;
	
	public tnode(int x) {
		val = x;
		left = right = null;
	}
}

public class removeHalfNodes {
	static tnode root;
	
	public tnode removenodes(tnode root) {
		//base case if tree is null
		if (root == null) {
			return null;
		}
		
		//if this is intermediate node containing two children
		//then traverse down recursivedly
		root.left = removenodes(root.left);
		root.right = removenodes(root.right);
		
		//if this is leaf then return
		if (root.left == null && root.right == null) {
			return root;
		}
		
		//if either left or right child is null then return the non
		//null child
		if (root.left == null || root.right == null) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
		}

		//once all the half nodes are removed, return the root
		return root;
	}
	
	public void preorder(tnode root) {
		if (root != null) {
			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	
	public tnode insert(tnode root, int x) {
		//base case when tree is empty, create the first node
		if (root == null) {
			return new tnode(x);
		}
		
		if (x < root.val) {
			root.left = insert(root.left, x);
		} else {
			root.right = insert(root.right, x);
		}
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeHalfNodes t = new removeHalfNodes();
		tnode newroot = null;
		t.root = new tnode(12);
		t.root.left = new tnode(7);
		t.root.left.right = new tnode(9);
		t.root.left.right.left = new tnode(8);
		t.root.left.right.right = new tnode( 10);
		t.root.right = new tnode( 13);
		t.root.right.right = new tnode(17);
		t.root.right.right.left = new tnode(15);
		
		newroot = t.removenodes(root);
		t.preorder(newroot);
	}

}
