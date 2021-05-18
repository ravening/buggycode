// Program to swap the nodes in alternate levels of a binary tree

package Trees;

public class ReverseAlternateLevels {
    public void solution(Trees.Node root) {
        reverseAlternate(root.left, root.right, 0);
    }

    public void reverseAlternate(Trees.Node root1, Trees.Node root2, int lvl) {
        if (root1 == null || root2 == null)
            return;

        if (lvl % 2 == 0) {
            int tmp = root1.val;
            root1.val = root2.val;
            root2.val = tmp;
        }

        // call recursively with left and right nodes
        reverseAlternate(root1.left, root2.right, lvl+1);
        reverseAlternate(root1.right, root2.left, lvl+1);
    }
}
