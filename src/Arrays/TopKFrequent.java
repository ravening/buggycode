package src.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public void solution(int[] array, int k) {
        if (array == null || array.length == 0)
            return;

        if (k > array.length)
            return;

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(array).forEach(x -> {
            map.put(x, map.getOrDefault(x, 0) + 1);
        });

        ArrayList[] bucket = new ArrayList[array.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<Integer>();

            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();

        for (var i = bucket.length - 1; i >=0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                for (var j = 0; j < bucket[i].size(); j++) {
                    result.add((Integer) bucket[i].get(j));
                }
            }
        }

        result.forEach(System.out::println);
    }
}
