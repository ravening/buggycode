package git.src.Array;

public class SortTwoArrays {
	public void mergeArrays(int[] arr1, int[] arr2) {
		if (arr1.length == 0 || arr2.length == 0) {
			return;
		}

		if (arr1.length == 1 && arr2.length == 1) {
			if (arr1[0] < arr2[0]) {
				arr1[0] = arr1[0] ^ arr2[0];
				arr2[0] = arr2[0] ^ arr1[0];
				arr1[0] = arr1[0] ^ arr2[0];
				return;
			}
		}

		int i = arr1.length;
		int j = arr2.length;

		while (j > 0) {
			if (arr1[i] > arr2[j]) {
				int tmp = arr2[j];
				arr2[j] = arr1[i];
				insertionSort(arr1, tmp);
			}
			j--;
		}
	}

	public void insertionSort(int[] arr, int val) {
		int i = arr.length - 1;

		while (i > 0 && arr[i-1] > val) {
			arr[i] = arr[i-1];
			i--;
		}
		arr[i] = val;
	}
}
