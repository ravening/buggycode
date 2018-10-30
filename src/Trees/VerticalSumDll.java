// Given a tree find the vertical sum of it using the doubly linked list
package Trees;

class DllNode {
    int data;
    DllNode prev;
    DllNode next;

    public DllNode(int data) {
        this.data = data;
    }
}

public class VerticalSumDll {
    // Instead of using the hash table to store the level and its corresponding sum,
    // use doubly linked list to store the result. this will consume less memory

    public void verticalSum(Node root) {
        DllNode head = new DllNode(0);

        verticalSumutil(root, head);

        // go to the first node
        while (head.prev != null)
            head = head.prev;

        // now display all the node values
        while (head.next != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public void verticalSumutil(Node root, DllNode head) {
        // store the root data in the current linked list node
        head.data = head.data + root.val;

        // if left node in tree is not null, then check if left node in dll exists or not
        // if not created it and traverse left in the list.
        if (root.left != null) {
            if (head.prev != null) {
                head.prev = new DllNode(0);
                head.prev.next = head;
            }
            // go to left node in tree
            verticalSumutil(root.left, head.prev);
        }

        if (root.right != null) {
            if (head.next != null) {
                head.next = new DllNode(0);
                head.next.prev = head;
            }
            // go to right node
            verticalSumutil(root.right, head.next);
        }
    }
}
