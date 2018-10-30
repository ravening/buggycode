// Given a binary tree, connect the nodes at the same level

// Using level order traversal, we connect the current node to next node
// in the queue
package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNodes {
    public void solution(Node root) {
        Queue<Node> queue = new LinkedList<>();
        // add root and null initially
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            //get the first element from the queue
            // if its null then it means we are done with
            // current level. so add null again
            // else point next of current node to the first element in queue
            Node tmp = queue.poll();
            if (tmp != null) {
                // point next to first element in queue
                tmp.right = queue.peek();

                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            } else if (!queue.isEmpty()) {
                // if we encounter null, it means we are done with current level
                // else queue will never be emtpy
                queue.add(null);
            }
        }
    }
}
