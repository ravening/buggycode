package src.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around: for example, we can turn '9' to be '0', or '0' to be '9'. Each move consists
of turning one wheel in one slot. The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will
stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns
required to open the lock, or -1 if it is impossible.
 */
public class LockOpener {
    public static void main(String[] args) {
        List<String> deadends = List.of("0201", "0101", "0102", "1212", "2002");
        String target = "0202";
        int count = openLock(deadends, target);
        System.out.println(count);

        deadends = List.of("8888");
        target = "0009";
        System.out.println(openLock(deadends, target));

        deadends = List.of("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888");
        target = "8888";

        System.out.println(openLock(deadends, target));

        System.out.println(openLock(List.of("0000"), "8888"));
    }

    public static int openLock(List<String> deadEnds, String target) {
        int ans = 0;
        int size = 0;
        Set<String> deadEndsSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        deadEndsSet.addAll(deadEnds);
        visited.add("0000");
        queue.add("0000");

        while (!queue.isEmpty()) {
            size = queue.size();

            while (size > 0) {
                String current = queue.poll();

                if (deadEndsSet.contains(current)) {
                    size--;
                    continue;
                }

                if (current != null && current.equalsIgnoreCase(target)) {
                    return ans;
                }

                for (int i = 0; i < 4; i++) {
                    char currentChar = current.charAt(i);

                    String clockwise = current.substring(0, i) + (currentChar == '9' ? 0 : currentChar - '0' + 1) +
                            current.substring(i + 1);
                    if (clockwise.equals(target)) {
                        return ans +1;
                    }
                    if (!visited.contains(clockwise) && !deadEndsSet.contains(clockwise)) {
                        queue.add(clockwise);
                        visited.add(clockwise);
                    }

                    String antiClockwise = current.substring(0, i) + (currentChar == '0' ? 9 : currentChar - '0' - 1) +
                            current.substring(i + 1);

                    if (antiClockwise.equals(target))
                        return ans + 1;
                    if (!visited.contains(antiClockwise) && !deadEndsSet.contains(antiClockwise)) {
                        queue.add(antiClockwise);
                        visited.add(antiClockwise);
                    }
                }
                size--;
            }

            ans++;
        }

        return -1;
    }
}
