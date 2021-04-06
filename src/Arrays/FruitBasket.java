package src.Arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitBasket {
    public int solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int maxSize = 1;
        int startIndex = 0;
        Set<Integer> set = new HashSet<>();

        for (var i = 0; i < array.length; i++) {
            if (set.size() < 2 || set.contains(array[i])) {
                set.add(array[i]);
            } else {
                int lastOne = array[i-1];
                for (var j = i-2; j>=0; j--) {
                    if (array[j] != lastOne) {
                        set.remove(array[j]);
                        startIndex = j + 1;
                        break;
                    }
                }

            }
            maxSize = Math.max(maxSize, i - startIndex + 1);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        FruitBasket basket = new FruitBasket();
        System.out.println(basket.solution(array));
        array = new int[]{1,2,3,2,2};
        System.out.println(basket.solution(array));
    }
}
