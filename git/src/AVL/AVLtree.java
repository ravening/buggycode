package AVL;

//class defining AVl tree node
//fields are data, height, left and right child links
class AVLtreeNode {
	private int data;
	private int height;
	AVLtreeNode left, right;
	
	//default constructor
	public AVLtreeNode() {
		setData(0);
		setHeight(0);
		left = right = null;
	}

	//contructor with one argument
	public AVLtreeNode(int x) {
		setData(x);
		setHeight(0);
		left = right = null;
	}
	
	//getters for data
	public int getData() {
		return data;
	}

	//setter for data
	public void setData(int data) {
		this.data = data;
	}

	//getter for height
	public int getHeight() {
		return height;
	}

	//setter for height
	public void setHeight(int height) {
		this.height = height;
	}
}

public class AVLtree {
	//rointer to root of avl tree;
	public AVLtreeNode root;
	
	private AVLtreeNode insert(AVLtreeNode root, int x) {
		//base case if tree is empty
		if (root == null) {
			return new AVLtreeNode(x);
		}
		
		//if data is less than node values
		if (x < root.getData()) {
			root.left = insert(root.left, x);
			if (Math.abs(height(root.left)- height(root.right)) > 1) {
				if (x < root.left.getData()) {
					root = rotateLeft(root);
				} else {
					root = doubleLeftRotate(root);
				}
			}
		} else {
			root.right = insert(root.right, x);
			if (Math.abs(height(root.left) - height(root.right)) > 1) {
				if (x > root.right.getData()) {
					root = rotateRight(root);
				} else {
					root = doubleRightRotate(root);
				}
			}
		}
		
		int h = Math.max(height(root.left), height(root.right)) +1;
		root.setHeight(h);
		return root;
	}
	
	public void insert(int x) {
		root = insert(root, x);
	}

	//function to do the single left rotation on a node to balance the
	//left height
	public AVLtreeNode rotateLeft(AVLtreeNode root) {
		//base case when tree is null
		if (root == null) {
			return null;
		}
		
		//get a pointer to the left child
		AVLtreeNode l1 = root.left;
		
		//make the right subtree of the left child as the left
		//subtree for the root
		root.left = l1.right;
		
		//make the root as the right child of the left node
		l1.right = root;
		
		//calculate the left and right height of the root
		int l = Math.max(height(root.left), height(root.right)) + 1;
		root.setHeight(l);
		
		//set the height of the new root obtained
		l = (Math.max(height(l1.left), root.getHeight())) + 1;
		l1.setHeight(l);
		
		//return the new root which is the first left child of the 
		//original root passed to this function
		return l1;
	}
	
	//function to do the single right rotation on a node to balance the
	//right height
	public AVLtreeNode rotateRight(AVLtreeNode root) {
		//base case when tree is null
		if (root == null) {
			return null;
		}

		//get a pointer to the right child
		AVLtreeNode r1 = root.right;

		//make the left subtree of the right child as the right
		//subtree for the root
		root.right = r1.left;

		//make the root as the left child of the right node
		r1.left = root;

		//calculate the left and right height of the root
		int l = Math.max(height(root.left), height(root.right)) + 1;
		root.setHeight(l);

		//set the height of the new root obtained
		l = (Math.max(height(r1.right), root.getHeight())) + 1;
		r1.setHeight(l);

		//return the new root which is the first right child of the 
		//original root passed to this function
		return r1;
	}
	
	//function to the double rotation. First do the right rotate
	//on the middle node and do the left rotation
	public AVLtreeNode doubleLeftRotate(AVLtreeNode root) {
		//base case when tree is null
		if (root == null) {
			return null;
		}
		
		root.left = rotateRight(root.left);
		return rotateLeft(root);
	}
	
	//function to do the double right rotation. First do the left
	//rotate on the right node and then do the right rotation
	public AVLtreeNode doubleRightRotate(AVLtreeNode root) {
		//base case when tree is empty
		if (root == null) {
			return null;
		}
		
		root.right = rotateLeft(root.right);
		return rotateRight(root);
	}
	
	//function to calculate the height of the subtree rooted at "node"
	public int height(AVLtreeNode node) {
		//base case if tree is empty
		if (node == null) {
			return 0;
		} else {
			return node.getHeight();
		}
	}
}
