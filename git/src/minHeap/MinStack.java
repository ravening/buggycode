package git.src.minHeap;

import java.util.*;
public class MinStack {
	public static void main(String[] args) {
		Stack mystack = new Stack();
		int[] arr = {5,2,7,8,4,1,3,6};

		for (int item : arr) {
			mystack.push(item);
		}

		System.out.println(mystack.min());
	}
}

class Stack {
	public java.util.Stack<Integer> main = new java.util.Stack<Integer>();
	public java.util.Stack<Integer> min = new java.util.Stack<Integer>();

	public void push(int item) {
		main.push(item);

		if (min.isEmpty()) {
			min.push(item);
		}

		if (!min.isEmpty() && (item < min.peek())) {
			min.push(item);
		}
	}

	public void pop() {
		int item = 0;
		if (!main.isEmpty()) {
			item = main.pop();
		}

		if (item == min.peek()) {
			item = min.pop();
		}
	}

	public int min() {
		if (min.isEmpty()) {
			return 0;
		} else {
			return min.peek();
		}
	}
}
