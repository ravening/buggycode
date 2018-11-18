// https://www.geeksforgeeks.org/trapping-rain-water/

package Arrays;

public class TrapRainWater {
    public void solution(int[] array) {
        int n = array.length;

        if (n == 0)
            return;

        int leftMax = 0, rightMax = 0;
        int low = 0, high = n -1;

        int result = 0;

        while (low < high) {
            if (array[low] < array[high]) {
                if (array[low] > leftMax) {
                    leftMax = array[low];
                } else {
                    result += leftMax - array[low];
                    low++;
                }
            } else {
                if (array[high] > rightMax) {
                    rightMax = array[high];
                } else {
                    result += rightMax - array[high];
                    high--;
                }
            }
        }

        System.out.println(result);
    }
}
