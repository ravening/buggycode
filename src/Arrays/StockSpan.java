package src.Arrays;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public void solution(int[] array) {
        if (array == null)
            return;

        int[] solution = new int[array.length];
        solution[0] = 1;
        if (array.length == 1) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] <= array[i]) {
                stack.pop();
            }
            solution[i] = (stack.isEmpty()) ? (i + 1) : i - stack.peek();

            stack.push(i);
        }

        Arrays.stream(solution)
                .forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        stockSpan.solution(new int[]{100, 80, 60, 70, 60, 75, 85});
    }
}
