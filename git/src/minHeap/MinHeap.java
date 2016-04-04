package minHeap;

public class MinHeap {
	private int size = 0;
	private int maxsize;
	private int[] Heap;
	
	public MinHeap(int val) {
		this.maxsize = val;
		Heap = new int[maxsize];
	}
	
	public int getsize() {
		return this.size;
	}
	
	public int getmaxsize() {
		return this.maxsize;
	}
	
	public void setelement(int index, int val) {
		Heap[index] = val;
	}
	
	public int gettopelement() {
		return Heap[0];
	}
	
	public void insert(int val) {
		Heap[size++] = val;
	}
	
	public boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos < size) {
			return true;
		}
		return false;
	}
	
	public int parent(int pos) {
		return (pos / 2);
	}
	
	public int leftchild(int pos) {
		return (pos * 2) + 1;
	}
	
	public int rightchild(int pos) {
		return (pos *2) + 2;
	}
	
	public boolean hasleftchild(int pos) {
		return ((pos * 2) + 1 < size);
	}
	
	public boolean hasrightchild(int pos) {
		return ((pos * 2) + 2 < size);
	}
	
	public void swap(int start, int end) {
		int tmp = Heap[start];
		Heap[start] = Heap[end];
		Heap[end] = tmp;
	}
	
	public void minheapify(int pos) {
		if (!isLeaf(pos)) {
			if (hasleftchild(pos) && hasrightchild(pos)) {
				if (Heap[pos] > Heap[leftchild(pos)] ||
					Heap[pos] > Heap[rightchild(pos)]) {
					if (Heap[leftchild(pos)] < Heap[rightchild(pos)]) {
						swap(leftchild(pos), pos);
						minheapify(leftchild(pos));
					} else {
						swap(rightchild(pos), pos);
						minheapify(rightchild(pos));
					}
				}
			} else if (hasleftchild(pos)) {
				if (Heap[pos] > Heap[leftchild(pos)]) {
					swap(leftchild(pos), pos);
					minheapify(leftchild(pos));
				}
			}
		}
	}
	
	public void minheap() {
		for (int pos=size/2; pos>=0;pos--) {
			minheapify(pos);
		}
	}
	
	public void display() {
		for (int pos=0; pos< (size); pos++) {
			System.out.println(Heap[pos]);

		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap minheap = new MinHeap(7);
		minheap.insert(4);
		minheap.insert(5);
		minheap.insert(6);
		minheap.insert(7);
		minheap.insert(1);
		minheap.insert(2);
		minheap.insert(3);
		//System.out.println(minheap.size);
		minheap.minheap();
		minheap.display();
		//System.out.println(minheap.size);
	}

}
