package git.src.binarySearchTree;//given a binary tree, print the top view of it


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


//class to contain a node and its depth in the tree which is used
//to push into queue while doing level order traversal
class QItem {
	BSTNode node;
	int depth;

	public QItem(BSTNode tmp, int x) {
		// TODO Auto-generated constructor stub
		this.node = tmp;
		this.depth = x;
	}
}

public class TopViewBT {
	public void solution(BSTNode root) {
		//do a level order traversal maintaining the degree info.
		//root is at degree 0, left child is at -1 and right child is at +1
		//use hashset to indicate if a node at a particular depth is
		//already seen or not. use queue to push node along with its depth
		if (root == null) {
			return;
		}

		Queue<QItem> queue = new LinkedList<QItem>();
		HashSet<Integer> set = new HashSet<>();

		//add root to queue along with its depth
		queue.add(new QItem(root, 0));

		while (!queue.isEmpty()) {
			//pop the first node, get its depth and push left and right child
			//check if the depth is already seen. if not add to set else dont
			QItem tmp = (QItem) queue.poll();
			BSTNode cur = tmp.node;
			int depth = tmp.depth;

			if (!set.contains(depth)) {
				set.add(depth);
				System.out.println(cur.data);
			}

			//add left and right child to queue
			if (cur.left != null) {
				queue.add(new QItem(cur.left, depth-1));
			}
			if (cur.right != null) {
				queue.add(new QItem(cur.right, depth+1));
			}
		}
	}
}
