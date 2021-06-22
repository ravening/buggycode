package src.Arrays;

/*
https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-stock-at-most-twice-set-2/?ref=rp
 */
public class MaxProfitSellingStocks {
    public void solution(int[] array) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int j : array) {
            buy1 = Math.min(buy1, j);

            profit1 = Math.max(profit1, j - buy1);

            buy2 = Math.min(buy2, j - profit1);

            profit2 = Math.max(profit2, j - buy2);
        }
    }
}
