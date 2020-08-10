package git.src;

import java.util.*;
public class Quadraplets {

	public static void quads(int[] arr) {
		if (arr == null || arr.length ==0) {
			return;
		}

		HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();

		for (int i =0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];

				if (!map.containsKey(sum)) {
					map.put(sum, new Pair(i,j));
				} else {
					if (sum == arr[i] + arr[j]) {
						Pair tmp = map.get(sum);
					System.out.println("(" + arr[i] + "," + arr[j] + ")" + " " + "(" + arr[tmp.first] + "," + arr[tmp.second] + ")");
				}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,7,1,2,9,8};
		quads(arr);
	}

}

class Pair {
	public int first;
	public int second;

	Pair(int f, int s) {
		this.first = f;
		this.second = s;
	}
}
