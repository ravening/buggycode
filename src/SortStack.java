import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        Stack<Integer> sorted = sortStack(stack);
        while (!sorted.isEmpty()) {
            System.out.println(sorted.pop());
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmp = new Stack<Integer>();

        while (!input.isEmpty()) {
            int var = input.pop();
            while (!tmp.isEmpty() && tmp.peek() > var) {
                input.push(tmp.pop());
            }

            tmp.push(var);
        }

        return tmp;
    }
}
