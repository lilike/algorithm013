package com.lilike.homework.dynamicprogram;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @Author llk
 * @Date 2020/9/23 21:13
 * @Version 1.0
 */
public class MaxProfitII {


    /**
     *  尽可能多的完成交易,那么其实就是可以交易无限次,那么 k = k -1
     *
     *     dp[i][k][0] = Math.max{ dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
     *     dp[i][k][1] = Math.max{ dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]}
     *     今天我是满仓的,要不就是昨天我是满仓的,要不就是昨天我空仓,今天买了
     *
     *     由于k = k -1 ,所以简化为二维
     *
     *     dp[i][0] = Math.max{ dp[i-1][0], dp[i-1][1] + prices[i] }
     *     dp[i][1] = Math.max{ dp[i-1][1], dp[i-1][0] - prices[i]}
     *
     *     初始值:
     *      dp[0][0] = 0;
     *      dp[0][1] = -prices[i];
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {

    }

}
