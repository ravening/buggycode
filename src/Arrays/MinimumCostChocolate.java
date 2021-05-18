package src.Arrays;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-cost-of-purchasing-at-least-x-chocolates/
 */
public class MinimumCostChocolate {

    public static void main(String[] args) {
        Pair[] pairs = new Pair[]{
                new Pair(4,3), new Pair(3,2),
                new Pair(2,4), new Pair(1,3),
                new Pair(4,2)
        };
        int X = 7;
        System.out.println(getCost(pairs, X));
    }
    public static int getCost(Pair[] pairs, int X) {
        int[][] dp = new int[pairs.length + 1][X + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        int result = getMinCost(pairs, dp, X, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int getMinCost(Pair[] pairs, int[][] dp, int X, int i) {
        if (X <= 0) {
            return 0;
        }

        if (i >= pairs.length) {
            return Integer.MAX_VALUE;
        }

        // either include it or exclude it
        int include = getMinCost(pairs, dp, X - pairs[i].count, i+1);
        if (include != Integer.MAX_VALUE) {
            include += pairs[i].cost;
        }

        int exclude = getMinCost(pairs, dp, X, i+1);
        dp[i][X] = Math.min(include, exclude);

        return dp[i][X];
    }
}

class Pair {
    int count;
    int cost;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Pair(int count, int cost) {
        this.count = count;
        this.cost = cost;
    }
}
