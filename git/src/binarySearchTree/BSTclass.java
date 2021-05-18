package git.src.binarySearchTree;
//import java.util.*;
public class BSTclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> list = new ArrayList<Integer>();
 		binarySearchTree.BST root = new binarySearchTree.BST(5);
		root.insert(3);
		root.insert(4);
		root.insert(2);
		root.insert(1);
		root.insert(7);
		root.insert(6);
		root.insert(8);
		root.insert(9);
		root.insert(10);

		//root.preorder();
//		list = root.inorderIter();
//		for(int i : list) {
//			System.out.println(i);
//		}

		//root.levelOrder();

		int[] preorder = {40, 20, 10, 30, 60, 50, 70};

		binarySearchTree.BST newroot = new binarySearchTree.BST();
		newroot.preorderToBst(preorder);
		newroot.inorder();

	}

}
