package binarySearchTree;
//program to convert binary search tree to doubly linked list

//class contaning node definition
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		// TODO Auto-generated constructor stub
		this.data = x;
		this.left = this.right = null;
	}
}

public class BSTToDLL {
	//do inorder traversal. Maintain two variables: head and previous.
	//when root is null check if head is null. If head is null we have
	//hit the leftmode node and the starting node of DLL. Make head as
	//root. when it returns, in parent node of left child, head wont be
	// null. then mark left of root as previous and right of previous
	// as root. recursively call for right node.
	public static TreeNode head, prev;
	public TreeNode solution(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		solution(root.left);
		if (head == null) {
			head = root;
			prev = head;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		solution(root.right);
		
		return head;
	}
}
