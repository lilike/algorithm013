package com.lilike.homework.dynamicprogram;

/**
 * 最佳股票买卖时机包含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @Author llk
 * @Date 2020/9/24 8:42
 * @Version 1.0
 */
public class MaxProfitVI {

    /**
     * 最佳股票买卖时机包含冷冻期
     * 卖出股票之后,无法第二天继续买入股票,需要冷冻一天
     * 需要在第三天才可以买入股票
     * 尽可能的多次交易,那么 k 是无限大的,我们
     * <p>
     * dp[i][k][0] = Math.max( dp[i-1][k][0], dp[i-1][k][1]+ prices[i] )
     * dp[i][k][1] = Math.max( dp[i-1][k][1], dp[i-2][k-1][0] - prices[i] )
     * 解释:
     * 第i天最多可以交易k次,并且是满仓的
     * 要么就是第i-1天已经是满仓的
     * 要么就是i-2天是空仓状态,并且i-2天最大交易次数是k-1,因为今天要交易
     * 因为有冷冻期,所以不能是 i-1
     * 因为k无限大,所以k可以省略
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0,dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1],-prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {

    }


}
