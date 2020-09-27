package com.lilike.homework.dynamicprogram;

/**
 * 使用最小花费去爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @Author llk
 * @Date 2020/9/24 16:17
 * @Version 1.0
 */
public class MinCostClimbingStairs {

    /**
     * 使用最小的花费爬楼梯
     *  dp[n][0] : 到第 n 层 ,并且没有爬 n 层 消费的体力数
     *      这个n肯定是表示楼梯层数
     *      0 和 1 表示 爬 或是 不爬
     *
     *
     *  dp[n][0] = dp[n-1][1]
     *
     *      当前这层楼不爬,一定是前面那层楼落下了,并且后面一层楼也落下了
     *
     *  dp[n][1] = Math.min ( dp[n-1][1] + costs[i], dp[n-2][1] + costs[i])
     *
     *      当前这层楼爬了,那么前面可以爬,也可以不爬
     *
     *  dp[0][0] = 0; // 第0层没爬
     *  dp[0][1] = costs[1];
     *
     *   最终求解的是
     *      Math.min (dp[n][0],dp[n][1])
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost ==null || cost.length == 0) return 0;

        int n = cost.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = cost[0];
        dp[1][0] = dp[0][1];
        dp[1][1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.min(dp[i-1][1] + cost[i] ,dp[i-2][1] + cost[i]);
        }
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }

    public static void main(String[] args) {

    }


}
