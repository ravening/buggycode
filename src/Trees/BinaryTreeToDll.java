// given a binary tree, convert it into doubly linked list
package Trees;

public class BinaryTreeToDll {
    public Node head;

    public Node solution(Node root) {
        if (root == null)
            return null;

        solution(root.right);

        root.right = head;
        if (head != null)
            head.left = root;

        head = root;

        solution(root.left);

        return head;
    }

    // given a binary tree, return the leaves of the tree as a dobuly linked list
    Node temp = head;
    public Node returnLeaves(Node root) {
        if (root.left == null && root.right == null)
            return null;

        root.right = returnLeaves(root.left);
        if (temp == null) {
            temp = root;
        } else {
            temp.right = root;
            root.left = temp;
            temp = root;
        }

        root.left = returnLeaves(root.right);

        return temp;
    }
}
