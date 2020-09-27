package com.lilike.homework.dynamicprogram;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票的最佳时机
 *
 * @Author llk
 * @Date 2020/9/22 16:10
 * @Version 1.0
 */
public class MaxProfit {


    /**
     * 这个是股票问题中最简单的
     * <p>
     * 股票问题,我们通常使用三位DP来进行解决
     * dp[i][k][0/1]
     * 表示第 i 天, 还可以交易 k 次, 0 表示空仓  1 表示满仓
     * 是的,leetCode里面的题目就是没有半仓.
     * <p>
     * 我们写出dp方程
     * dp[i][k][0] = Math.max{ dp[i-1][k][0], dp[i-1][k][1] + prices[i]  }
     * 解释:
     * 第i天,还可以交易k次,并且是空仓的,要么就是昨天是空仓的,要么就是昨天满仓,并且今天卖出了
     * <p>
     * dp[i][k][1] = Math.max { dp[i-1][k][1] , dp[i-1][k-1][0] - prices[i] }
     * 解释:
     * 第 i 天, 最多可以交易k次,并且是满仓的状态
     * 要么昨天就已经满仓了,并且昨天最多可以交易k次
     * 要么就是昨天空仓,那么昨天就只能允许交易 k - 1次,因为今天要交易,所以是 dp[i-1][k-1][0] - prices
     * <p>
     * 初始值:
     * dp[-1][1][0] = 0 初始肯定利润是0
     * dp[-1]][1][1] = 0 不可能出现
     * <p>
     * 如果k = 0 那么直接就是 等于0
     * <p>
     * 如果 k = 1 呢
     * <p>
     * dp[i][0][0] = dp[i][0][1] = 0;
     * <p>
     * dp[i][1][0] = Math.max{ dp[i-1][1][0], dp[i-1][1][1] + prices[i] }
     * dp[i][1][1] = Math.max{ dp[i-1][1][1], dp[i-1][0][1] - prices[i]}
     * = Math.max{ dp[i-1][1][1] - prices[i]}
     * <p>
     * 所以k可以忽略,简化为二维的Dp
     * <p>
     * dp[i][0] = Math.max{ dp[i-1][0] , dp[i-1][1] + prices[i] }
     * dp[i][1] = Math.max{ dp[i-1][1], -prices[i] }
     *
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; // 一开始空仓也是0
        dp[0][1] = -prices[0]; // 一开始不可能买了
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }


    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dp_i_1_0 = 0, dp_i_1_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
            dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
        }
        return dp_i_1_0;
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minValue = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (i > 0) {
                minValue = Math.max(minValue, -minPrice + prices[i]);
            }
        }
        return minValue < 0 ? 0 : minValue;
    }

    public static void main(String[] args) {

    }
}
