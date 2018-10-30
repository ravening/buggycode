// Program to find the inorder successor in a binary tree

package Trees;

class Previous {
    public Node prev;
    Previous() {
        prev = null;
    }
}

public class InorderSuccessor {
    Previous previous = new Previous();

    // Do a reverse inorder traversal. whenever you go to right subtree, dont change the
    // prev value. whenever you go to left subtee, change the prev to the current node
    // So that prev will be the inorder successor.
    public void inorderSuccessor(Node root, Previous prev, int data) {
        if (root.right != null) {
            inorderSuccessor(root.right, prev, data);
        }

        if (root.val == data) {
            if (prev.prev != null)
                System.out.println(prev.prev.val);
        }

        prev.prev = root;

        if (root.left != null) {
            inorderSuccessor(root.left, prev, data);
        }
    }
}
