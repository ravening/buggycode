package git.src.Array;

public class RotatedSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(rotatedBinarySearch(array, 0, array.length -1,8));
	}

	public static int rotatedBinarySearch(int[] array, int low, int high, int number) {
		if (array.length == 0) {
			return -1;
		}
		if (low > high) {
			return -1;
		}

		int mid = ( low + high ) / 2;

		// if the middle element is the key, return
		if (array[mid] == number) {
			return mid;
		}

		//check if left half is sorted. If so, then right half is unsorted.
		//Search for the number in the first half first and then right half
		if (array[low] <= array[mid]) {
			if (number >= array[low] && number <= array[mid]) {
				return rotatedBinarySearch(array, low, mid-1,number);
			} else {
				//number lies in right sub half
				return rotatedBinarySearch(array, mid+1, high, number);
			}
		}

		//right half is sorted
		if (array[mid] <= array[high]) {
			if (number >= array[mid] && number <= array[high] ) {
				return rotatedBinarySearch(array, mid +1, high, number);
			} else {
				return rotatedBinarySearch(array, low, mid-1, number);
			}
		}
		return -1;
	}
}
