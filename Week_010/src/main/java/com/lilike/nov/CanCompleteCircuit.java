package com.lilike.nov;

/**
 * 加油站
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @Author llk
 * @Date 2020/11/18 11:17
 * @Version 1.0
 */
public class CanCompleteCircuit {

    /**
     * 比较巧妙的解法.是使用一个折线图划出来
     * 想要跑完全程,满足两个条件
     * 1. 总油量 > 总支出
     * 2. 要把累计损失油量最大的值放到最后一步
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalTank = 0;
        int minTank = Integer.MAX_VALUE;
        int minTankIndex = Integer.MIN_VALUE;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            totalTank = totalTank + gas[i] - cost[i];
            if (totalTank < minTank) {
                minTank = totalTank;
                minTankIndex = i;
            }
        }
        return totalTank < 0 ? -1 : (minTankIndex + 1) % n;
    }

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas,cost));

    }


}
