// given an array of integers and a target value, check if there is a
// subset of elements which sums upto the number

package Arrays;

import java.util.List;

public class SubsequentSum {
    public void solution(List<Integer> list, int target, int index, int sum, boolean[] visited) {
        if (sum == target) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == true) {
                    System.out.print(list.get(i) + " ");
                }
            }
        } else if (index < list.size()) {
            // consider the current element and recurse
            sum = sum + list.get(index);
            visited[index] = true;
            solution(list, target, index+1, sum, visited);

            // after backtracking dont consider the element
            sum = sum - list.get(index);
            visited[index] = false;
            solution(list, target, index+1, sum, visited);
        }

        // solution(list, 5, 0, 0, visited);
    }
}
