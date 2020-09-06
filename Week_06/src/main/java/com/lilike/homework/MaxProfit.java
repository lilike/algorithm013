package com.lilike.homework;

/**
 *  买卖股票的最佳时机
 *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 *
 * @Author llk
 * @Date 2020/9/5 10:02
 * @Version 1.0
 */
public class MaxProfit {

    /**
     * 只能交易一次
     * 两个指针,一个指向当前遇到的最小值,一个指向当前遇到的最大值
     * 然后卖出即可
     *
     *  DP(n) = max( prices[i] - minPrices[i] )
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 ) return 0;
        int minPirces = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPirces) minPirces = prices[i];
            maxProfit = Math.max(maxProfit,prices[i] - minPirces);
        }
        return maxProfit;
    }






    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit(nums));
    }


}
