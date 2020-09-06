package com.lilike.daily;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/9/1 10:47
 * @Version 1.0
 */
public class CoinChange {


    /**
     * 依然是典型的动态规划问题
     * 零钱兑换的递推公式:
     * <p>
     * F(S) = min{F(S-C)+1,..}
     * 其中C是包含在coins里面的
     * 并且F(0) = 0;
     * <p>
     * 自底向上的递推
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        if (amount <= 0) return 0;
        int[] memory = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            Integer min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memory[i - coins[j]] < min) {
                    min = Math.min(min, memory[i - coins[j]] + 1);
                }
            }
            memory[i] = min;
        }
        return memory[amount] == Integer.MAX_VALUE ? -1 : memory[amount];
    }


    public static void main(String[] args) {

        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }
}

