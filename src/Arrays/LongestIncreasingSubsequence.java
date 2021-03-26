package src.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {3,2,4,5,1};
        solution(arr);
    }
    public static void solution(int[] array) {
        List<ArrayList<Integer>> lis = new ArrayList<>();
        for (var i =0; i < array.length; i++) {
            lis.add(new ArrayList<>());
        }

        lis.get(0).add(array[0]);
        for (var i = 1; i < array.length; i++) {
            for (var j = 0; j < i; j++) {
                if (array[i] > array[j] && lis.get(i).size() < lis.get(j).size() + 1) {
                    lis.get(i).clear();
                    lis.get(i).addAll(lis.get(j));
                }
            }

            lis.get(i).add(array[i]);
        }

        int max = lis.get(0).size();
        for (var i = 1; i < lis.size(); i++) {
            max = Math.max(max, lis.get(i).size());
        }

        List<Integer> list = lis.get(max);

        list.forEach(x -> System.out.print(x + " "));
    }
}
