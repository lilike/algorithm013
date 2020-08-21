package com.lilike.homework.ten;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @Author llk
 * @Date 2020/8/18 22:51
 * @Version 1.0
 */
public class MaxProfit {

    /**
     * 贪心算法,只要是第二天的价格高于前一天的,就在前一天买,第二天卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }


    public static void main(String[] args) {

    }

}
