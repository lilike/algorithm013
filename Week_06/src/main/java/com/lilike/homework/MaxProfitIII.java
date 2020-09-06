package com.lilike.homework;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 买卖股票的最佳时机
 *
 * @Author llk
 * @Date 2020/9/5 10:32
 * @Version 1.0
 */
public class MaxProfitIII {


    /**
     * 使用动态规划
     *      使用一个数组 dp[i][j] 表示第i天j状态下的最大利润
     *          j = 0 : 初始状态
     *          j = 1 : 第一次买入
     *          j = 2 : 第一次卖出
     *          j = 3 : 第二次买入
     *          j = 4 : 第二次卖出
     *
     *      DP方程:
     *          dp[i][0] = dp[i-1][0] 某一天的初始状态等于上一天的初始状态
     *          dp[i][1] = max { dp[i-1][1], dp[i-1][0] - prices[i] } 第i天第一次买入的利润等于 第 i-1 天买入的利润 , 或是上一天是初始化状态下买入的利润取最大值
     *          dp[i][2] = max { dp[i-1][2], dp[i-1][1] + prices[i] }
     *          dp[i][3] = max { dp[i-1][3], dp[i-1][2] - prices[i] }
     *          dp[i][4] = max { dp[i-1][4], dp[i-1][3] + prices[i] }
     *
     *
     *
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][5];

        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        dp[0][3] = - prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }

        return Math.max(Math.max(Math.max(dp[n-1][4],dp[n-1][3]),Math.max(dp[n-1][1],dp[n-1][2])),dp[n-1][0]);
    }


    /**
     * 最简单的思路是使用递归
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        return dg(prices, 0, 0, 0);
    }


    /**
     * @param prices 价格列表
     * @param index  当前是多少天
     * @param count  目前的仓位
     * @param k      第几次交易
     */
    private int dg(int[] prices, int index, int count, int k) {

        // terminator
        if (k == 2 || index > prices.length - 1) {
            return 0;
        }

        int a = 0, b = 0, c = 0;
        // process current logic
        // 保持当前仓位
        a = dg(prices, index + 1, count, k);

        // 如果当前是有仓位的,那么可以卖
        if (count == 1) {
            b = dg(prices, index + 1, 0, k + 1) + prices[index];
        } else {
            c = dg(prices, index + 1, 1, k) - prices[index];
        }
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitIII().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
