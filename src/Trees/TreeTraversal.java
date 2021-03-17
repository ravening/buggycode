package src.Trees;

import java.util.Stack;

public class TreeTraversal {

    public <T> void iterativePreOrderTraversal(Trees.TreeNode<T> root) {
        if (root == null)
            return;

        Stack<Trees.TreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Trees.TreeNode<T> node = stack.pop();
            System.out.println(node.getData());

            if (node.getRight() != null)
                stack.push(node.getRight());

            if (node.getLeft() != null)
                stack.push(node.getLeft());
        }
    }

    public <T> void iterativeInorderTraversal(Trees.TreeNode<T> root) {
        if (root == null)
            return;

        Stack<Trees.TreeNode<T>> stack = new Stack<>();
        Trees.TreeNode<T> current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            System.out.println(current.getData());

            current = current.getRight();
        }

    }

    public <T> void iterativePostorderTraversal(Trees.TreeNode<T> root) {
        if (root == null)
            return;

        Stack<Trees.TreeNode<T>> stack1 = new Stack<>();
        Stack<Trees.TreeNode<T>> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty()) {
            Trees.TreeNode<T> node = stack1.pop();

            if (node.getLeft() != null)
                stack1.push(node.getLeft());

            if (node.getRight() != null)
                stack1.push(node.getRight());

            stack2.push(node);
        }

        while (!stack2.isEmpty()) {
            Trees.TreeNode<T> node = stack2.pop();
            System.out.println(node.getData());
        }
    }
}
