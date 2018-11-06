// given two sorted arrays, sort them without using extra space

// https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

// idea is to start from the last element of the second array
// search that element in the first array and using the insertion sort
// put it in the right position.

package Arrays;

public class MergeSort {
    public void mergeSort(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int j = m-2;
        // start from the last element of the second array
        for (int i = n-1; i >= 0; i--) {
            // store the last element of the first array
            int last = arr1[m-1];
            // keep comparing with elements of the first array
            // starting from the last position. whenever the element
            // of the first array is greater than second array then shift them
            // one position
            while (arr1[j] > arr1[i]) {
                arr1[j+1] = arr1[j];
                j--;
            }

            // if we have shifted some elements in arr1 to right
            // or the last element is greater then swap
            if (j != m-2 || last > arr2[i]) {
                arr1[j+1] = arr1[i];
                arr1[i] = last;
            }
        }
    }
}
