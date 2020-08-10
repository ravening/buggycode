package git.src.binarySearchTree;//given a binary tree, do a vertical order traversal

import git.src.binarySearchTree.BTNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;


//Object containing tree node and depth which is stored in queue
class Nodes {
	BSTNode node;
	int level;

	public Nodes(BSTNode tmp, int x) {
		// TODO Auto-generated constructor stub
		this.node = tmp;
		this.level = x;
	}
}

public class VerticalOrderTraversal {
	public void solution(BSTNode root) {
		if (root == null) {
			return;
		}

		//Queue to store level order traversal of the tree
		//Each entry contains tree node and its depth
		Queue<Nodes> queue = new LinkedList<Nodes>();

		//HashMap to store the level and the tree nodes
		HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();

		Nodes tmp = new Nodes(root, 0);
		queue.add(tmp);

		//do a level order traversal while the root is not null
		//add each node and its level info to the hash
		//This ensures that the node appearing in the lower levels of
		//the tree are printed before the node appearing in the
		//highest level which are at same vertical distance.
		//If we dont do level order traversal and just use hashmap
		//to store nodes using their distance from root, then nodes
		//at highest level are printed first before the nodes at
		//lower level which are at same veritcal distance
		while (!queue.isEmpty()) {
			Nodes cur = (Nodes) queue.poll();
			int depth = cur.level;
			BSTNode tmp1 = cur.node;

			if (tmp1.left != null) {
				queue.add(new Nodes(tmp1.left, depth-1));
			}
			if (tmp1.right != null) {
				queue.add(new Nodes(tmp1.right, depth+1));
			}

			if (hash.containsKey(depth)) {
				hash.get(depth).add(tmp1.data);
			} else {
				ArrayList<Integer> arrayList = new ArrayList<>();
				arrayList.add(tmp1.data);
				hash.put(depth, arrayList);
			}

		}

		for (Entry<Integer, ArrayList<Integer>> entry : hash.entrySet()) {
			ArrayList<Integer> array = entry.getValue();
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i));
			}
		}
	}
}
