// given a linked linst, arrange the odd and even positions node together
package SingleLinkedList;

public class RearrangeEvenOddPositions {
    public Node solution(Node root) {
        Node odd = root;
        Node even = root.next;
        Node evenFirst = root.next;

        while (true) {
            if (odd != null || even != null || even.next != null) {
                odd.next = evenFirst;
                break;
            }

            // point the next of odd to the next of even node
            odd.next = even.next;
            odd = odd.next;

            // if there are no more even nodes then point the next of
            // odd node to the first even node
            if (odd.next == null) {
                odd.next = evenFirst;
                break;
            }

            // point next of even to the next of odd node
            even.next = odd.next;
            even = even.next;
        }

        return root;
    }
}
