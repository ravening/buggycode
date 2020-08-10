package src.Trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class NewNode {
    int data;
    int hd;
    NewNode left;
    NewNode right;

}
public class BottomViewTree {
    public void bottomViewIterative(NewNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<NewNode> queue = new LinkedList<>();

        root.hd = 0;
        int hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            NewNode tmp = queue.remove();
            map.put(tmp.hd, tmp.data);

            if (tmp.left != null) {
                tmp.left.hd = tmp.hd -1;
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                tmp.right.hd = tmp.hd + 1;
                queue.add(tmp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry1 = iterator.next();
            System.out.print(entry1.getValue());
        }
    }

    TreeMap<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
    // bottomViewRecursion(root, 0, 0);
    public void bottomViewRecursion(NewNode root, int hd, int height) {
        if (root == null)
            return;

        if (map.containsKey(hd)) {
            Pair<Integer, Integer> pair = map.get(hd);
            if (height <= pair.getValue()) {

                map.put(hd, new Pair<>(root.data, height));
            }
        }

        bottomViewRecursion(root.left, hd - 1, height + 1);
        bottomViewRecursion(root.right, hd + 1, height + 1);
    }
}

class Pair<I extends Number, I1 extends Number> {
    public Integer first;
    public Integer second;

    Pair(Integer f, Integer s) {
        this.first = f;
        this.second = s;
    }

    public Integer getValue() {
        return second;
    }
}
