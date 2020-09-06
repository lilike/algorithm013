package com.lilike.homework;

/**
 *  买卖股票的最佳时机II
 *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author llk
 * @Date 2020/9/5 10:17
 * @Version 1.0
 */
public class MaxProfitII {

    /**
     * 找到多个波峰波谷.或是采用贪心算法也可以实现
     *
     * DP(n) = sum{peek(i) + valley(i) ....}
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sum = 0;
        int peek = prices[0];
        int valley = prices[0];

        int i = 0;
        while (i < prices.length-1) {
            while (i < prices.length-1 && prices[i] >= prices[i+1]) i++;
            valley = prices[i];
            while (i < prices.length -1 && prices[i] <= prices[i+1]) i++;
            peek = prices[i];
            sum += peek-valley;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
