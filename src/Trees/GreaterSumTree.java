// Given a bst convert it into greater sum tree
// https://algorithms.tutorialhorizon.com/convert-bst-to-greater-sum-tree/

package Trees;

public class GreaterSumTree {
    public static int sum = 0;
    public void solution(Node root) {
        if (root != null) {
            solution(root.right);

            int tmp = root.val;
            root.val = sum;
            sum = sum + root.val;

            solution(root.left);
        }
    }
}
