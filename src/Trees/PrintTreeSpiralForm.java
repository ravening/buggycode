// Given a binary tre, print it in spiral form
package Trees;

import java.util.Deque;
import java.util.LinkedList;

public class PrintTreeSpiralForm {

    public void solution(Node root) {
        if (root == null)
            return;

        Deque<Node> deque = new LinkedList<>();
        int size = 0;
        int level = 0;

        deque.addLast(root);

        while (!deque.isEmpty()) {
            size = deque.size();
            if (level == 0) {
                while (size-- > 0) {
                    Node tmp = deque.removeLast();
                    System.out.println(tmp.val);
                    if (tmp.right != null)
                        deque.addFirst(tmp.right);
                    if (tmp.left != null)
                        deque.addFirst(tmp.left);
                }
                level = 1;
            } else {
                while (size-- > 0) {
                    Node tmp = deque.removeFirst();
                    System.out.println(tmp.val);
                    if (tmp.left != null)
                        deque.addLast(tmp.left);
                    if (tmp.right != null)
                        deque.addLast(tmp.right);
                }
                level = 0;
            }
        }
    }
}
