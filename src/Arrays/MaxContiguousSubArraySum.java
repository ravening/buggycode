package Arrays;

public class MaxContiguousSubArraySum {
    public void solution(int[] array) {
        int start = 0, end = 0, s = 0;
        int maxEndHere = Integer.MIN_VALUE, maxSoFar = 0;

        for (int i = 0 ; i < array.length; i++) {
            maxEndHere += array[i];
            if (maxEndHere > maxSoFar) {
                maxSoFar = maxEndHere;
                start = s;
                end = i;
            }
            if (maxEndHere < 0) {
                maxEndHere = 0;
                s = i + 1;
            }
        }

        for (int i = start; i < end; i++) {
            System.out.println(array[i]);
        }
    }
}
