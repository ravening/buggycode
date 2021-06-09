package src.Trees;

public class DiameterOfTree {
    static int diameter = 0;
    public int diameter(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int leftHeight = diameter(root.getLeft());
        int rightHeight = diameter(root.getRight());

        if (diameter < 1 + leftHeight + rightHeight) {
            diameter = 1 + leftHeight + rightHeight;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
