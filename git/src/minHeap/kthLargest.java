package minHeap;

public class kthLargest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MinHeap heap = new MinHeap(2);
		
		int[] arr = {3,1,2,5,6,4, 7};
		
		for( int i=0; i < arr.length; i++) {
			
			if (heap.getsize() < heap.getmaxsize()) {
				heap.insert(arr[i]);
				
			} else {
				heap.minheap();
				if (heap.gettopelement() < arr[i]) {
					heap.setelement(0, arr[i]);
					heap.minheap();
				}
			}
		}
		
		System.out.println(heap.gettopelement());
	}

}
