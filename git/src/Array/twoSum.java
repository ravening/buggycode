import java.util.*;
public class twoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,5,7,9,11,13};
		int[] result = twosumsorted(array,9);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] twosum(int[] array, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i=0; i< array.length; i++) {
			if (map.containsKey(array[i])) {
				int index = map.get(array[i]);
				result[0] = array[index];
				result[1] = array[i];
			} else {
				map.put(target - array[i], i);
			}
		}
		return result;
	}
	
	public static int[] twosumsorted(int[] array, int target) {
		int[] result = new int[2];
		int i = 0, j = array.length - 1;
		
		while (i <= j) {
			if (array[i] + array[j] == target) {
				result[0] = array[i];
				result[1] = array[j];
				break;
			} else if (array[i] + array[j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}
}
