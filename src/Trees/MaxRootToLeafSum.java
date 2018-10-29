// Program to find the path from root to leaf containing the max sum
package Trees;

class Maximum {
    int val;
    String path;
}

public class MaxRootToLeafSum {
    Maximum max = new Maximum();

    public void solution(Node root, int sum, String str) {
        if (root == null)
            return;

        sum += root.val;
        str = str + " " + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            if (sum > max.val) {
                max.val = sum;
                max.path = str;
            }
        }

        solution(root.left, sum, str);
        solution(root.right, sum, str);
    }
}
