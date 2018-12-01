package Strings;

import java.util.ArrayList;
import java.util.List;

public class ReversePolishNotation {
    static int calExpression(String word) {
        return calExpression(word.split(" "));
    }

    static int index = 0;
    static int calExpression(String[] words) {
        String currOps = null;
        List<Integer> nums = new ArrayList<Integer>();
        for (; index < words.length; index++) {
            switch (words[index]) {
                case "(":
                    ++index;
                    int res = calExpression(words);
                    nums.add(res);
                    break;
                case ")":
                    return calNums(nums, currOps);
                default:
                    if (isOperator(words[index])) {
                        currOps = words[index];
                    } else {
                        nums.add(Integer.valueOf(words[index]));
                    }
                    break;
            }
        }

        return calNums(nums, currOps);
    }

    static int calNums(List<Integer> nums, String expression) {
        int res = 0;
        if (expression == null)
            expression = "*";
        switch (expression) {
            case "+":
                for (Integer num : nums)
                    res += num;
                break;
            case "-":
                for (Integer num : nums)
                    res -= num;
                break;
            case "/":
                res = nums.get(0);
                for (int index = 1; index < nums.size(); index++)
                    res /= nums.get(index);
                break;
            default:
                res = 1;
                for (Integer num : nums)
                    res *= num;
                break;
        }
        return res;
    }

    static boolean isOperator(String input) {
        switch (input) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                return false;
        }
    }
}
