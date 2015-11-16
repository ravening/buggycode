package binarySearchTree;

public class pathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST root = new BST(5);
		root.insert(3);
		root.insert(4);
		root.insert(2);
		root.insert(1);
		root.insert(7);
		root.insert(6);
		root.insert(8);
		root.insert(9);
		root.insert(10);
		
		System.out.println(root.pathSum(5));
	}

}
