package com.lilike.homework.dynamicprogram;

/**
 *
 *  打家劫舍II
 *  https://leetcode-cn.com/problems/house-robber-ii/description/
 * @Author llk
 * @Date 2020/9/22 16:49
 * @Version 1.0
 */
public class RobII {

    /**
     *  和打家劫舍I的区别就是首尾相连
     *      如果偷了第一家,就不能偷最后一家
     *      如果偷了最后一家,就不能偷第一家
     *
     *      n表示家数
     *
     *      结果取 n-1和 n-1的较大值
     *      result = max { dp[n-2], dp[n-1] }
     *
     *      两个区间
     *          [0,n-2]
     *          [1,n-1]
     *
     *      在这两个区间进行打家劫舍
     *
     *      就是把围城一圈的房子变成没有围成一圈的房子
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums == null || nums.length == 1) return nums[0];
        if (nums == null || nums.length == 2) return Math.max(nums[0],nums[1]);
        int one = robI(nums,0,nums.length-2);
        int two = robI(nums,1,nums.length-1);
        return Math.max(one,two);
    }

    /**
     *  dp[i] = max { dp[i-1],dp[i-2] + nums[i] }
     * @param nums
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int robI(int[] nums, int startIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        if (length == 1) return nums[startIndex];
        if (length == 2) return Math.max(nums[startIndex],nums[startIndex + 1]);
        int[] dp = new int[endIndex-startIndex+1];
        dp[0] = nums[startIndex];
        dp[1] = Math.max(nums[startIndex],nums[startIndex + 1]);
        int idx = 2;
        for (int i = startIndex + 2; i < endIndex+1; i++) {
            dp[idx] = Math.max(dp[idx-1],dp[idx-2]+nums[i]);
            idx++;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

        System.out.println(new RobII().rob(new int[]{1,2,1,1}));

    }

}
