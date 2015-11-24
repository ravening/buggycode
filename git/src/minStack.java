import java.util.*;
public class minStack {
	public static void main(String[] args) {
		stack mystack = new stack();
		int[] arr = {5,2,7,8,4,1,3,6};
		
		for (int item : arr) {
			mystack.push(item);
		}
		
		System.out.println(mystack.min());
	}
}

class stack {
	public Stack<Integer> main = new Stack<Integer>();
	public Stack<Integer> min = new Stack<Integer>();
	
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