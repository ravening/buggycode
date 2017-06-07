import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

//program to find the max number of overalps between intervals
public class intervalOverlap {
	public void findCountOverlap(int[] arr1, int[] arr2) {
		if (arr1 == null || arr1.length == 0) {
			return;
		}
		
		if (arr2 == null || arr2.length == 0) {
			return;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int m = arr1.length;
		int n = arr2.length;
		
		int i = 0, j = 0;
		int count = 0, result = 0;
		
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				count++;
				i++;
				result = Math.max(result, count);
			} else {
				count--;
				j++;
			}
		}
	}
}
