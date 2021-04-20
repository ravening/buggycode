package src.Arrays;

/*
https://www.techiedelight.com/find-maximum-profit-that-can-be-earned-by-selling-stocks/
 */
public class MaxProfit {
    public int solution(int[] x, int[] y) {
        int[] tmp = new int[x.length + 1];

        tmp[0] = 0;
        tmp[1] = Math.max(x[0], y[0]);

        for (var i = 2; i<=x.length; i++) {
            tmp[i] = Math.max(x[i-1] + tmp[i-1], y[i-1] + tmp[i-2]);
        }

        return tmp[x.length];
    }
}
