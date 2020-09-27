package com.lilike.homework.dynamicprogram;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 股票买卖的最大利润III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @Author llk
 * @Date 2020/9/23 21:30
 * @Version 1.0
 */
public class MaxProfitIII {

    /**
     *  k = 2 ,最多只能有2笔交易
     *
     *  一种思路就是穷举,另外一种思路就是双重循环
     *
     *   dp[i][k][0] = Math.max{ dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
     *   dp[i][k][1] = Math.max{ dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
     *
     *   dp[i][2][0] = Math.max{dp[i-1][2][0], dp[i-1][2][1] + prices[i]}
     *   dp[i][2][1] = Math.max{ dp[i-1][2][1], dp[i-1][1][0] - prices[i]}
     *
     *   dp[i][1][0] = Math.max{dp[i-1][1][0], dp[i-1][1][1] + prices[i]}
     *   dp[i][1][1] = Math.max{ dp[i-1][1][1],  - prices[i]}
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];


        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2 ; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // 由于k=0的时候,一定也是0,所以不用管
                dp[i][k][1] = Math.max( dp[i-1][k][1],  dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][2][0];
    }


    public static void main(String[] args) {

    }

}
