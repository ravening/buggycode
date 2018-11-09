// https://www.geeksforgeeks.org/even-numbers-even-index-odd-numbers-odd-index/
// given an array, rearrange the elements such that even number elements
// are at even position and odd numbers are at odd positions
package Arrays;

public class EvenOddPositions {
    public void solution(int[] arr, int n) {
        int i = 0;
        int j = 1;

        while (true) {
            while (i < n && arr[i] % 2 == 0)
                i += 2;

            while (j < n && arr[j] % 2 == 1)
                j += 2;

            if (i < n && j < n) {
                //swap arr[i] and arr[j]
            } else {
                break;
            }
        }
    }
}
