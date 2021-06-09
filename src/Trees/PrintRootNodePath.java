package src.Trees;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
 */
public class PrintRootNodePath {
    public void solution(TreeNode<Integer> root, int x) {
        List<Integer> array = new ArrayList<>();
        hasPath(root, x, array);

        array.forEach(y -> System.out.print(y + " "));
    }

    public boolean hasPath(TreeNode<Integer> root, int x, List<Integer> array) {
        if (root == null)
            return false;

        array.add(root.getData());

        if (root.getData() == x) {
            return true;
        }

        if (hasPath(root.getLeft(), x, array) || hasPath(root.getRight(), x, array))
            return true;

        array.remove(array.size() - 1);

        return false;
    }
}
