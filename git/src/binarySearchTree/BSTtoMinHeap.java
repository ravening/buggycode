//Given binary search tree, convert it to min heap such that all values
//in the left subtree should be less than all values in right subtree

//algo:
//do inorder traversal and copy values to array.
//do preorder traversal and copy values from array to tree nodes.

package binarySearchTree;

public class BSTtoMinHeap {
	public int[] arr = new int[100];
	BSTnode root;
	public int i = 0;
	
	//store the tree into array by doing inorder traversal
	public void inOrder(BSTnode root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		arr[i++] = root.getdata();
		inOrder(root.right);
	}
	
	//copy the values from array to tree by doing preorder traversal
	public void preOrder(BSTnode root) {
		if (root == null) {
			return;
		}
		
		root.setData(arr[i++]);
		preOrder(root.left);
		preOrder(root.right);
	}
	
}
