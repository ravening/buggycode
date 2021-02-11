package Strings;

import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public static void main(String[] args) {
        RemoveAdjacentDuplicate removeAdjacentDuplicate = new RemoveAdjacentDuplicate();

        String s = "abbaca";
        System.out.println(removeAdjacentDuplicate.removeAdjacentDuplicate(s));
    }

    public String removeAdjacentDuplicate(String s) {
        if (s == null || s == "")
            return "";

        Stack<Character> stack = new Stack<>();

        for (var i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder("");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return reverseString(sb.toString());
    }

    public String reverseString(String s) {
        char[] array = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char ch = array[left];
            array[left] = array[right];
            array[right] = ch;
            left++;
            right--;
        }

        return new String(array);
    }
}
