package src.Strings;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 */
public class NextGreaterNumber {
    public static String solution(char[] number) {
        int i = 0;

        for (i = number.length - 1; i > 0; i--) {
            if (number[i] > number[i-1]) {
                break;
            }
        }

        if (i == 0)
            return "No solution";

        int x = number[i-1];
        int min = i;

        // find the smallest number on the right side of x
        for (var j = min + 1; j < number.length; j++) {
            if (number[j] > x && number[j] < number[min]) {
                min = j;
            }
        }

        swap(number, i-1, min);

        Arrays.sort(number, i, number.length);

        return Arrays.toString(number);
    }

    private static void swap(char[] number, int x, int y) {
        char tmp = number[x];
        number[x] = number[y];
        number[y] = tmp;
    }
}
