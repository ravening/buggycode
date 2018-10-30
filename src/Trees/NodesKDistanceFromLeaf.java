// Given a binary tree print all the nodes which are at a distance k from the leaf
// Idea is to use a static variable and recursion. while the recursion is rolling
// back. keep incrementing the counter. when counter == k print the node
// No nodes are displayed twice
package Trees;

public class NodesKDistanceFromLeaf {
    public static int count = 0;

    public void solution(Node root, int k) {
        if (root == null)
            return;

        solution(root.left, k);
        solution(root.right, k);

        // If we encounter a leaf node, reset the counter so that
        // it will be incremented while going back up to the root
        if (root.left == null && root.right == null) {
            count = 0;
        }

        // If count == k we found the node
        if (count == k)
            System.out.println(root.val);

        //increment the count
        count++;
    }
}
