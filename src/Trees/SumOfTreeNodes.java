package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SumOfTreeNodes {
    ArrayList<Integer> queue = new ArrayList<>();
    static int sum = 0;

    public int solution(Trees.Node root) {
        queue.add(root.val);

        if (root.left != null) {
            sum = solution(root.left);
        }

        if (root.right != null) {
            sum = solution(root.right);
        }

        int t = 1;
        int num = 0;

        int size = queue.size();

        while (size >= 0) {
            num += queue.get(size-1) * t;
            t = t * 10;
        }

        sum = sum + num;
        queue.remove(size-1);
        return  sum;
    }
}
