package git.src.binarySearchTree;//Given a binary tree, fill all the rightNextPointers with the
//adjacent nodes in the same level



//tree node with extra nextRight field
class BSTNode {
    public int data;
	BSTNode left, right, nextRight;

	public BSTNode(int x) {
		// TODO Auto-generated constructor stub
		this.data = x;
		this.left = this.right = this.nextRight = null;
	}
}

public class NextRightPointer {
	public void solution(BSTNode root) {
		//base case if root is null
		if (root == null) {
			return;
		}

		BSTNode head = root;
		BSTNode tmp = null;

		//assign nextRight of each node level by level
		//the outer while loop traverses level by level and
		//the inner while loop assigns nextRight of each node
		//in that level

		//initialize root's nextRight to null
		root.nextRight = null;

		while (head != null) {
			tmp = head;

			while (tmp != null) {
				//if left child is not null then nextRight of the left
				//child is the right child of the node
				if (tmp.left != null) {
					if (tmp.right != null) {
						tmp.left.nextRight = tmp.right;
					} else {
						//if right child is null then nextRight of left child
						//is left child of parents nextRight
						tmp.left.nextRight = getParentNextRight(tmp);
					}
				}

				//if right child is not null then nextRight of right child
				//is left child of parents nextRight
				if (tmp.right != null) {
					tmp.right.nextRight = getParentNextRight(tmp);
				}

				//move the current node to its neighbour
				tmp = tmp.nextRight;
			}

			//after assigning the nextRIght of each node in a level, move down
			//either left or right child
			if (head.left != null) {
				head = head.left;
			} else if (head.right != null) {
				head = head.right;
			} else {
				head = getParentNextRight(head);
			}
		}
	}

	public BSTNode getParentNextRight(BSTNode node) {
		BSTNode tmp = node.nextRight;

		while (tmp != null) {
			if (tmp.left != null) {
				return tmp.left;
			} else if (tmp.right != null) {
				return tmp.right;
			} else {
				tmp = tmp.nextRight;
			}
		}
		return null;
	}
}

