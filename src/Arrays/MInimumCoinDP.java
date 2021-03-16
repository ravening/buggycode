// https://algorithms.tutorialhorizon.com//dynamic-programming-minimum-coin-change-problem/

// minimum coins required to form an amount
package Arrays;

import java.util.Arrays;

public class MInimumCoinDP {
    public void solution(int[] coins, int amount) {
        int[] minReq = new int[amount+1];

        // iterate for all amount
        for (int i = 0; i <= amount; i++) {
            minReq[i] = Integer.MAX_VALUE;

            // iterate for all coins if its value is less that the amount
            for (int j = 0; j <= coins.length; j++) {
                if (coins[j] < amount) {
                    minReq[i] = Math.min(minReq[i - coins[j]] + 1, minReq[i]);
                }
            }
        }

        System.out.print(minReq[amount]);
    }

    // https://trykv.medium.com/how-to-solve-minimum-coin-change-f96a758ccade
    public int optimalSolution(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        Arrays.fill(array, Integer.MAX_VALUE);

        array[0] = 0;

        for (Integer coin : coins) {
            for (var i = coin ; i <= amount; i++) {
                if (i - coin >= 0) {
                    array[i] = Math.min(array[i], array[i - coin] + 1);
                }
            }
        }

        return array[amount] != Integer.MAX_VALUE ? array[amount] : -1;
    }
}
