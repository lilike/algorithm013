package com.lilike.homework;

/**
 * 最佳股票购买时间包含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @Author llk
 * @Date 2020/9/7 21:42
 * @Version 1.0
 */
public class MaxProfitIIII {

    /**
     *  关键在于要写出状态转移方程.
     *
     *         首先定义dp[i][j]
     *              i 表示的是第i天结束, j的取值分别是 0 , 1 , 2
     *              dp[i][0] : 第 i 天结束后,手上拥有股票的最大利润
     *                      dp[i][0] = max { dp[i-1][0], dp[i-1][2] - prices[i] }
     *
     *              dp[i][1] : 第 i 天结束后,手上不拥有股票,并且处于冷冻期, 说明当天卖出了股票,那么前一天就一定是有股票的状态
     *                      dp[i][1] = dp[i-1][0] + prices[i]
     *
     *
     *              dp[i][2] : 第 i 天结束,手上不拥有股票,并且不处于冷冻期 , 说明今天没有操作(没有买和卖)
     *                      dp[i][2] = max{ dp[i-1][2], dp[i-1][1]}
     *
     *
     *          最终结果就是 max{ dp[n-1][1], dp[n-1][2]} , 因为最后一天手上有股票没意义啊
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        /**  初始化 */
        int[][] dp = new int[prices.length][3];

        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }


    public static void main(String[] args) {

    }


}
