package com.lilike.homework.dynamicprogram;

/**
 * 买卖股票的最佳时机V
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @Author llk
 * @Date 2020/9/24 9:21
 * @Version 1.0
 */
public class MaxProfitV {

    /**
     * int n = prices.length; n表示交易日
     * 因为买了之后必须卖了之后才可以买
     * 所以最多可以交易的次数是 n/2
     * 最多只能交易K次
     * 分为两种情况,一种情况是K > n /2 , 那么其实可以看成是可以交易无限次,因此可以简化为二维
     * 另外一种情况是 K <= n/2,那么就不能简化为二维
     * <p>
     * 当 K > n/2的时候
     * <p>
     * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
     * dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
     * <p>
     * <p>
     * 当 k <= n/2
     * <p>
     * dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * <p>
     * 当 k == 0
     * dp[i][0][0] = 0  // 当前无法交易,并且空仓
     * dp[i][0][1] = 0; // 都无法交易,怎么会有股票
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        if (k > n / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0) {
                    if (j == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = 0;
                    }else {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[0];
                    }
                }else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }

            }
        }
        return dp[n-1][k][0];
    }

    private int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


    public static void main(String[] args) {

        System.out.println(new MaxProfitV().maxProfit(4,new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
