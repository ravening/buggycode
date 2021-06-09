package src.Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/print-root-leaf-path-without-using-recursion/
 */
public class PrintRootLeafPath {
    public void solution(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        Map<TreeNode<Integer>, TreeNode<Integer>> map = new HashMap<>();

        map.put(root, null);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> tmp = stack.pop();

            if (tmp.isLeafNode()) {
                printPath(tmp, map);
            }
            if (tmp.getRight() != null) {
                map.put(tmp.getRight(), tmp);
                stack.push(tmp.getRight());
            }
            if (tmp.getLeft() != null) {
                map.put(tmp.getLeft(), tmp);
                stack.push(tmp.getLeft());
            }
        }
    }

    public void printPath(TreeNode<Integer> node, Map<TreeNode<Integer>, TreeNode<Integer>> map) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.getData());
            node = map.get(node);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
