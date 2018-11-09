// given an array, segregate all the even and odd numbers together

// idea is to keep a pointer to the last encountered even number
// keep scanning till you find the next even number
// when you find the next even number, swap the encountered even
// number with the first odd number next to the previous even number

package Arrays;

public class SegregateEvenOddNumbers {
    public static void solution(int[] arr) {
        int n = arr.length;

        int i = -1;
        int j = 0;

        while (j < n) {
            if (arr[j] % 2 == 0) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            j++;
        }

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void solution2(int[] arr) {
        int n = arr.length;

        int i = 0;
        int j = n-1;

        while (i < j) {
            while (i < n && arr[i] % 2 == 0)
                i++;
            while (j > 0 && arr[j] % 2 ==1)
                j--;

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        solution2(arr);

        System.out.println("=====");

        solution(arr);
    }
}
