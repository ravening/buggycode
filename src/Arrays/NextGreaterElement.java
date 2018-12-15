// given an array of elements, print the next greater element to the right of it
package Arrays;

import java.util.Stack;

public class NextGreaterElement {
    public void solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[array.length];

        for (int i = array.length -1; i>= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < array[i])
                    stack.pop();
            }

            output[i] = stack.empty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
    }
}
