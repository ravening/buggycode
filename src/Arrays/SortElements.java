//


package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class SortElements {
    // given an array, rearrange the elements such that
    // all elements at even index positions are sorted in increasing
    // order and elements at odd index are in descending order
    public void solution(int[] arr) {
        int n = arr.length;
        // idea is to swap all odd index elements in the left side
        // with even index elements on the right side and then sort

        // start with odd index on left and even index from right
        int i = 1;
        int j = n-1;

        // if last index is not even then reduce by one
        if (j % 2 != 0)
            j--;

        while (i < j) {
            // swap arr[i] arr[j]
            i += 2;
            j -= 2;
        }

        // sort first half ascending
        Arrays.sort(arr, 0, j-1);
        //Arrays.sort(arr, j, n-1, Collections.reverseOrder());
    }


    // given an array, sort the elements in wave form such that
    // all elements in even index are greater than the previous
    // and next odd index number
    // arr[o] > arr[1] < arr[2] > arr[3] < arr[4] > arr[5] ..
    public void sortWave(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i += 2) {
            // if current even index element is smaller than the
            // previous odd index element then swap them
            if ( i > 0 && arr[i] < arr[i-1]) {
                //swap arr[i] arr[i-1]
            }

            // if current even index element smaller than next
            // odd index element then swap them
            if (i < n-1 && arr[i] < arr[i+1]) {
                //swap arr[i] arr[i+1]
            }
        }
    }

    // do the resvere sort the above wave sort
    public void reverseWaveSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i+1]) {
                //swap arr[i] arr[i+1]
            }

            if (i % 2 != 0 && arr[i] < arr[i+1]) {
                //swap arr[i] arr[i+1]
            }
        }
    }
}
