package git.src;

public class MaxSumSubArray {
	public int kadaneAlgo(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		if (arr.length == 1) {
			return arr[0];
		}

		int max_end_here = arr[0];
		int max_so_far = arr[0];

		for (int i = 1; i < arr.length; i++) {
			max_end_here = Math.max(arr[i], max_end_here + arr[i]);
			max_so_far = Math.max(max_so_far, max_end_here);
		}

		return max_so_far;
	}

	public void maxSubArrWithKElem(int[] arr, int k) {
		//we need to find the maximum subarry sum with atleast
		//k elements
		int max_end_here = arr[0];
		int max_so_far = arr[0];
		int[] maxSum = new int[arr.length];
		maxSum[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			max_end_here = Math.max(arr[i], arr[i] + max_end_here);
			max_so_far = Math.max(max_end_here, max_so_far);
			maxSum[i] = max_so_far;
		}

		int result = 0, sum = 0;

		//use the sliding window concept
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		result = sum;
		for (int i = k; i < arr.length;i ++) {
			sum = sum + arr[i] - arr[i-k];

			result = Math.max(result, sum);
			result = Math.max(result, sum + maxSum[i]);
		}
	}
}
