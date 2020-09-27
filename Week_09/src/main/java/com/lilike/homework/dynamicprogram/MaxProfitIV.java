package com.lilike.homework.dynamicprogram;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @Author llk
 * @Date 2020/9/24 10:24
 * @Version 1.0
 */
public class MaxProfitIV {


    /**
     * 手续费在卖出的时候支付就可以了
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }

        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {


    }
}
