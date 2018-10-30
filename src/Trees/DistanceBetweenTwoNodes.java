// Given a binary tree, find the distance between the two nodes
// Idead is to find the lca for the two nodes. Find the distance from
// lca to each of the node and sum the two distances

package Trees;

public class DistanceBetweenTwoNodes {
    LCABinaryTree lcaBinaryTree = new LCABinaryTree();
    public void solution(Node root, int val1, int val2) {
        // find the lca for the two nodes
        root = lcaBinaryTree.lcaUtil(root, val1, val2);

        if (root == null)
            return;

        // now find the distance from the lca to the two nodes
        int d1 = lcaDistance(root, val1, 0);
        int d2 = lcaDistance(root, val2, 0);

        System.out.println(d1 + d2);
    }

    public int lcaDistance(Node root, int val1, int k) {
        if (root == null)
            return  -1;

        if (root.val == val1)
            return k;

        int left = lcaDistance(root.left, val1, k+1);
        if (left != -1) {
            return left;
        }
        return lcaDistance(root.right, val1, k+1);
    }
}
