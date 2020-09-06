package com.lilike.homework;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @Author llk
 * @Date 2020/9/2 14:01
 * @Version 1.0
 */
public class CoinChange {

    /**
     *  DP(n) = min{ DP(n-c)....} + 1
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {

        int[] coinCount = new int[amount+1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && coinCount[i-coins[j]] >= 0) {
                    min = Math.min(coinCount[i-coins[j]] + 1, min);
                }
            }
            coinCount[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return coinCount[amount];
    }


    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},11));

    }

}
