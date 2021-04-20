package src.Arrays;

import java.util.Stack;

/*
https://www.techiedelight.com/previous-smaller-element/
 */
public class PreviousSmallerElement {
    public static void solution(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (var i = 0; i < array.length; i++) {
            while (!stack.isEmpty()) {
                if (array[i] > stack.peek()) {
                    System.out.print(" " + stack.peek() + " ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                System.out.print(" -1 ");
            }

            stack.push(array[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 5, 3, 7, 8, 1, 9 };
        solution(arr);
    }
}
