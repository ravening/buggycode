package src.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class LongestSubarraySumK {
    public int solution(int[] array, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (var i = 0; i < array.length; i++) {
            sum += array[i];

            // update the max length
            if (sum == K) {
                maxLen = i + 1;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - K)) {
                if (maxLen < i - map.get(sum - K)) {
                    maxLen = i - map.get(sum - K);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarraySumK longest = new LongestSubarraySumK();
        int[] arr = {10, 5, 2, 7, 1, 9};
        System.out.println(longest.solution(arr, 15));
    }
}
