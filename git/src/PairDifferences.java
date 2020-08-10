package git.src;

import java.util.HashSet;

//given an array and a number k, find pairs of numbers whose difference is k
public class PairDifferences {
	public int solution(int[] array, int k) {
		//base case if array is null
		if (array == null || array.length < 2) {
			return 0;
		}

		HashSet<Integer> set = new HashSet<>();
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			if (set.contains(array[i] + k)) {
				count++;
			}
		}

		return count;
	}
}
