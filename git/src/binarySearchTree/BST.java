
package binarySearchTree;

import java.util.*;
class BSTnode {
	private int data;
	BSTnode left;
	BSTnode right;
	
	public BSTnode(int val) {
		this.data = val;
		this.left = this.right = null;
	}
	
	public int getdata() {
		return this.data;
	}
	
	public void setData(int x) {
		this.data = x;
	}
}

public class BST {
	private BSTnode root;
	static int index = 0;
	public BST() {
		root = null;
	}
	
	public BST(int val) {
		root = new BSTnode(val);
	}
	
	public void insert(int val) {
		root = insert(root, val);
	}
	
	private BSTnode insert(BSTnode root, int val) {
		if (root == null) {
			root = new BSTnode(val);
		} else {
			if (val < root.getdata()) {
				if (root.left == null) {
					root.left = new BSTnode(val);
				} else {
					root.left = insert(root.left, val);
				}
			} else {
				if (root.right == null) {
					root.right = new BSTnode(val);
				} else {
					root.right = insert(root.right, val);
				}
			}
		}
		return root;
	}
	
	public void inorder () {
		inorder(root);
	}
	
	private void inorder(BSTnode root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.getdata());
			inorder(root.right);
		}
	}
	
	public void preorder() {
		preorder(root);
	}
	
	private ArrayList<Integer> inorderIterative(BSTnode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<BSTnode> stack = new Stack<BSTnode>();
		
		BSTnode tmp = root;
		
		while (!stack.isEmpty() || tmp != null) {
			if (tmp != null) {
				stack.add(tmp);
				tmp = tmp.left;
				
			} else {
				BSTnode t = stack.pop();
				list.add(t.getdata());
				tmp = t.right;
			}
		}
		
		return list;
	}
	
	public ArrayList<Integer> inorderIter() {
		return inorderIterative(root);
	}
	
	private void preorder(BSTnode root) {
		if (root != null) {
			System.out.println(root.getdata());
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder() {
		postorder(root);
	}
	
	private void postorder (BSTnode root) {
		if (root!= null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.getdata());
		}
	}
	
	private void levelOrderTraversal(BSTnode root) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nodeval = new ArrayList<>();
		
		Queue<BSTnode> queue = new LinkedList<>();
		
		if (root == null) {
			return;
		}
		
		queue.add(root);

		BSTnode right = root;
		BSTnode tmp = null;
		
		while (!queue.isEmpty()) {
			BSTnode t = queue.remove();
			nodeval.add(t.getdata());
			
			if (t == right) {
				result.add(nodeval);
				nodeval = new ArrayList<>();
				if (t.right != null) {
					right = t.right;
				} else if (t.left != null) {
					right = t.left;
				} else {
					right = tmp;
				}
				
			}
			
			if (t.left != null) {
				queue.add(t.left);
				tmp = t.left;
			}
			
			if (t.right != null) {
				queue.add(t.right);
				tmp = t.right;
			}
		}
		
		for (List<Integer> list1 : result) {
			for (int i : list1) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
	
	public void levelOrder() {
		levelOrderTraversal(root);
	}
	
	private boolean pathToLeafSum(BSTnode root, int sum) {
		if (root == null) {
			return false;
		}
		
		if ((root.getdata() == sum) && (root.left == null) && root.right == null) {
			return true;
		}
		
		return pathToLeafSum(root.left, sum - root.getdata()) ||
				pathToLeafSum(root.right, sum - root.getdata());
	}
	public boolean pathSum(int sum) {
		return pathToLeafSum(root, sum);
	}
	
	private BSTnode inorderPostorderToBST(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
		if (inorder == null || postorder == null) {
			return null;
		}
		
		int rootval = postorder[pend];
		BSTnode root = new BSTnode(rootval);
		int k =0;
		for (int i =0; i < inorder.length; i++) {
			if (inorder[i] == rootval) {
				k = i;
				break;
			}
		}
		
		root.left = inorderPostorderToBST(inorder, istart, k-1,postorder,pstart, pstart + k - istart - 1);
		root.right = inorderPostorderToBST(inorder, k +1, iend, postorder, pstart + k - istart, pstart -1);
		return root;
	}
	public void inorderPostorder(int[] inorder, int[] postorder) {
		int instart =0; int poststart = 0;
		int inend = inorder.length;
		int postend = postorder.length;
		
		root = inorderPostorderToBST(inorder, instart, inend, postorder, poststart, postend);
	}
	
	private BSTnode sortedArrayToTree(int[]array, int start, int end) {
		if (array == null) {
			return null;
		}
		
		if (start > end) {
			return null;
		}
		
		int mid = start + (end - start) / 2;
		
		BSTnode root = new BSTnode(array[mid]);
		
		root.left = sortedArrayToTree(array, start, mid - 1);
		root.right = sortedArrayToTree(array, mid + 1, end);
		
		return root;
	}
	public void sortedToTree(int[] array) {
		root = sortedArrayToTree(array, 0, array.length-1);
	}
	
	private int balanced(BSTnode root) {
		if (root == null) {
			return 0;
		}
		
		int left = balanced(root.left);
		int right = balanced(root.right);
		
		if (left == -1 || right == -1) {
			return -1;
		}
		
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
	public int isBalanced() {
		return balanced(root);
	}
	
	private boolean symmetricRecursive(BSTnode left, BSTnode right) {
		if (left == null && right == null) {
			return true;
		}
		
		if (left == null || right == null) {
			return false;
		}
		
		if (left.getdata() != right.getdata()) {
			return false;
		}
		
		if (!symmetricRecursive(left.left, right.right)) {
			return false;
		}
		
		if (!symmetricRecursive(left.right, right.left)) {
			return false;
		}
		
		return true;
	}
	public boolean isSymmetricRecursive() {
		if (root == null) {
			return true;
		}
		
		if (root.left == null || root.right == null) {
			return false;
		}
		return symmetricRecursive(root.left, root.right);
	}
	
	private boolean symmetricIterative(BSTnode left, BSTnode right) {
		if (left.getdata() != right.getdata()) {
			return false;
		}
		
		Queue<BSTnode> leftqueue = new LinkedList<BSTnode>();
		Queue<BSTnode> rightqueue = new LinkedList<BSTnode>();
		
		leftqueue.add(left.left);
		rightqueue.add(right.right);
		
		while (!leftqueue.isEmpty() && !rightqueue.isEmpty()) {
			BSTnode leftchild = leftqueue.remove();
			BSTnode rightchild = rightqueue.remove();
			
			if (leftchild == null && rightchild == null) {
				return true;
			}
			
			if (leftchild == null || rightchild == null) {
				return false;
			}
			
			if (leftchild.getdata() != rightchild.getdata()) {
				return false;
			}
			
			leftqueue.add(leftchild.left);
			leftqueue.add(leftchild.right);
			rightqueue.add(rightchild.right);
			rightqueue.add(rightchild.left);
		}
		return true;
	}
	
	public boolean isSymmetricIterative() {
		if (root == null) {
			return true;
		}
		
		if (root.left == null || root.right == null) {
			return false;
		}
		
		return symmetricIterative(root.left, root.right);
	}
	
	private BSTnode preorderToBST(int[] preorder, int min, int max) {
		BSTnode newroot = null;
		if (preorder.length == 0) {
			return null;
		}
		
		if (index > preorder.length) {
			return null;
		}
		
		int current = preorder[index];
		//System.out.println(current);
		if (current > min && current < max) {
			newroot = new BSTnode(current);
			
			index = index + 1;
			
			if (index < preorder.length) {
				newroot.left = preorderToBST(preorder, min, current);
			}
			
			if (index < preorder.length) {
				newroot.right = preorderToBST(preorder, current, max);
			}
		}
		return newroot;
	}
	
	public void preorderToBst(int[] preorder) {
		root = preorderToBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
