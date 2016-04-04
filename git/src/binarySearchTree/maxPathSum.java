package binarySearchTree;

class Node {
	public int data;
	public Node left, right;
	
	public Node(int x) {
		data = x;
		left = right = null;
	}
}

class Res {
	public int val;
}
class BinaryTree {
	Node root;
	
	public int findPathSum() {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		return findPathSum(root,res);
	}
	
	public int findPathSum(Node root, Res res) {
		//base case. if null return 0
		if (root == null) {
			return 0;
		}
		
		int l = findPathSum(root.left, res);
		int r = findPathSum(root.right, res);
		
		//get the maximum value of (root + leftchild, root+rightchild),(root)
		int max_single = Math.max(Math.max(l, r) + root.data, root.data);
		
		//get the maximum value between (root + max child) and 
		//(root + left child + right child)
		int max_top = Math.max(max_single, l + r + root.data);
		
		//store the max result
		res.val = Math.max(res.val, max_top); 
		
		//return the max value of root data + max child value
		return max_single;
	}
}
public class maxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
