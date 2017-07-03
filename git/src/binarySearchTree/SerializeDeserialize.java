//serialize and desrialize a given tree
//do a preorder traversal and store into linked list
//use the linked list stored in the previous step to create the tree back
package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserialize {
	//Function to serialize the tree into linked list
	public List<Integer> serialize(BTNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		helperSerialize(root, list);
		return list;
	}
	
	public static void helperSerialize(BTNode root, ArrayList<Integer> list) {
		if (root == null) {
			list.add(null);
			return;
		}
		
		list.add(root.data);
		helperSerialize(root.left, list);
		helperSerialize(root.right, list);
	}
	
	public static BTNode deserialize(ArrayList<Integer> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		BTNode root = helperDeserialize(list);
		return root;
	}
	
	public static BTNode helperDeserialize(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		
		Integer tmp = list.remove(0);
		
		if (tmp == null) {
			return null;
		}
		
		BTNode node = new BTNode(tmp);
		node.left = helperDeserialize(list);
		node.right = helperDeserialize(list);
		
		return node;
	}
}
