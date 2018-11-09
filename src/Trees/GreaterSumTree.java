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
            sum = sum + tmp;

            solution(root.left);
        }
    }

    // program to convert tree to sum tree
    public int solution2(Node root) {
        if (root != null) {
            int left = solution2(root.left);
            int right = solution2(root.right);

            int sum = root.val + left + right;
            root.val = left + right;
            return sum;
        }
        return 0;
    }
}
