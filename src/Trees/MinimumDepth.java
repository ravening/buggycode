package src.Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepth {
    public int solution(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(new Entry(root, 1));

        while (!queue.isEmpty()) {
            Entry tmp = queue.poll();
            TreeNode<Integer> node = tmp.getNode();
            int depth = tmp.getDepth();

            if (node.isLeafNode()) {
                return depth;
            }

            if (node.getLeft() != null) {
                queue.add(new Entry(node.getLeft(), depth + 1));
            }
            if (node.getRight() != null) {
                queue.add(new Entry(node.getRight(), depth + 1));
            }
        }

        return 0;
    }
}

class Entry {
    TreeNode<Integer> node;
    int depth;

    public Entry(TreeNode<Integer> node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    public TreeNode<Integer> getNode() {
        return node;
    }

    public int getDepth() {
        return depth;
    }

    public void setNode(TreeNode<Integer> node) {
        this.node = node;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
