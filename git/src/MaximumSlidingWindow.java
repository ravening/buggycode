import java.util.Comparator;
import java.util.PriorityQueue;

//given an array of size n and window size k, find the maximum element in each window
public class MaximumSlidingWindow {
	public void solution(int[] array, int k) {
		//create a max heap priority queue of size k 
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int i = 0;
		
		//add the first k elements to the priority queue
		for (i = 0; i < k; i++) {
			pq.offer(array[i]);
			
		}

		//continue adding elements to priority queue for the remaining of the array
		for (i = k;i < array.length; i++) {
			
			//display the current max value in the sliding window
			System.out.print(pq.peek() + " ");
			
			//add the current element
			pq.offer(array[i]);
		}
		
		//display the max in the last window
		System.out.println(pq.peek());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		MaximumSlidingWindow max = new MaximumSlidingWindow();
		max.solution(array, k);
	}

}
