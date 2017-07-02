//given a preorder traversal of a binary search tree, print the inorder traversal
package binarySearchTree;

import java.util.Stack;

public class PreorderToInorder {
	public void solution(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return;
		}
		
		Stack<Integer> stack = new Stack<>();
		int i = 1;
		
		//store the root in the stack
		stack.push(preorder[0]);
		
		//traverse for the remaining elements
		while (i < preorder.length) {
			//if stack top is greater than current element, push current
			//element to stack else keep popping the elements from the
			//stack until stack top is greater than current element.
			if (!stack.isEmpty() && stack.peek() > preorder[i]) {
				stack.push(preorder[i]);
			} else {
				while (!stack.isEmpty() && stack.peek() < preorder[i]) {
					System.out.println(stack.pop());
				}
				stack.push(preorder[i]);
			}
			i++;
		}
	}

}
