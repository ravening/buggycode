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

    // given an array of only positive integers, find the contiguous array
    // with maximum sum
    public void solution2(int[] array) {
        if (array.length ==0 || array.length == 1)
            return;

        int result = 0;
        if (array.length == 2)
            result = array[0] > array[1] ? array[0] : array[1];

        int currentSum = 0;

        for (int i =0; i < array.length; i++) {
            currentSum = array[i];

            while (i+1 < array.length &&
                    array[i] < array[i+1]) {
                i++;
                currentSum += array[i];
            }

            if (currentSum > result)
                result = currentSum;
        }

        System.out.println(result);
    }
}
