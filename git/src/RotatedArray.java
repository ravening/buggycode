package git.src;

//given a sorted array which is rotated, perform several actions on it
public class RotatedArray {

	//given a rotated sorted array, find the element in it
	public boolean SearchRotatedSortedArray(int[] arr, int x) {
		if (arr == null || arr.length ==0) {
			return false;
		}

		int low = 0;
		int high = arr.length -1;

		while (low < high) {
			int mid = (low + high) / 2;

			if (arr[mid] == x) {
				return true;
			}

			//check if left part of array is in increasing order
			//if so then the right part of the array is rotated
			if (arr[low] < arr[mid]) {
				if (x < arr[low] && x < arr[mid]) {
					high = mid -1;
				} else {
					low = mid + 1;
				}
			} else {
				if (arr[mid] < x && x < arr[high]) {
					low = mid + 1;
				} else {
					high = mid -1;
				}
			}
		}
		return false;
	}

	//given a rotated sorted array, find the minimum element
	public int MinimumInSortedRotated(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int low = 0;
		int high = arr.length -1;

		while (low < high) {
			int mid = (low + high) / 2;

			//if first element is less than last element then array is not rotated
			//return the first element
			if (arr[low] < arr[high]) {
				return arr[low];
			}

			//if first element is same as the last element then return the element
			if (arr[low] == arr[high]) {
				return arr[low];
			}

			//if right part is not increasing then least element will be in right side
			//else it will be in left side
			if (mid < high && arr[mid] > arr[mid+1]) {
				return arr[mid+1];
			}

			if (mid > low && arr[mid] < arr[mid-1]) {
				return arr[mid];
			}

			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
		}
		return -1;
	}

	//given a rotated sorted array, find pair of elements whose sum is equal to given value
	public boolean PairInRotatedSorted(int[] arr, int sum) {
		if (arr == null || arr.length < 2) {
			return false;
		}

		int low, high;
		int i;
		for (i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				break;
			}
		}

		low = (i + 1) % arr.length;
		high = i;

		while (low < high) {
			if (arr[low] + arr[high] == sum) {
				return true;
			}

			if (arr[low] + arr[high] < sum) {
				low = (low + 1) % arr.length;
			} else {
				high = (arr.length - 1 + high) % arr.length;
			}
		}
		return false;
	}
}
