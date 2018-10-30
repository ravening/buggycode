// Given a binary tree, print the left most and the right most nodes of each level
package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBorderNodes {
    // Do a level order traversal and maintain a variable isFirst set to true initially to print
    // the first node when we enter a new level. after printing the first node, set it to false
    // reduce the node count of each level. when it reaches 0, it means we are at the extreme
    // right of that level. so print the last node
    public void solution(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;

        // Add root to the queue
        queue.add(root);

        // do a level order traversal
        while (!queue.isEmpty()) {
            // get the number of nodes at each level
            int count = queue.size();
            boolean isFirst = true;
            while (count > 0) {
                Node tmp = queue.poll();
                // if this is the first node in the level then print it
                if (isFirst) {
                    System.out.println(tmp.val);
                }

                // add its childrent to the queue
                if (tmp.left != null)
                    queue.add(tmp.left);

                if (tmp.right != null)
                    queue.add(tmp.right);

                // decrement the node count of the level
                count--;

                // if count is 0 and isFirst is false then we are at the last node of the level
                if (count == 0 && isFirst == false)
                    System.out.println(tmp.val);

                // set to false so that first node is not printed twice
                isFirst = false;
            }
        }
    }
}
