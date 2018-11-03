// Given a linked list with right and down where each right and down lists
// are sorted, return a single sorted linked list

// 5 -> 10 -> 19 -> 28
// |     |    |     |
// V     V    V     V
// |     |    |     |
// 7     20   22    35
// and so on
// return 5 -> 7 -> 10 -> 19 -> 20 -> 22 -> 28 -> 35

// Idea is similar to merging two sorted linked lists
// Use merge sort. Recursively go to the right most list.
// sort the rightmost and the previous of it and return
// back the sorted list

package SingleLinkedList;

class FlatListNode {
    int data;
    FlatListNode right;
    FlatListNode down;

    public FlatListNode(int data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

public class FlattenLinkedList {

    public FlatListNode merge(FlatListNode a,  FlatListNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        FlatListNode result = null;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        return result;
    }

    public FlatListNode mergeSort(FlatListNode root) {
        if (root == null || root.right == null) {
            return root;
        }

        // recursively sort the right list
        root.right = mergeSort(root.right);

        // now merge the current down list and the returned right list
        root = merge(root, root.right);

        return root;
    }

}
