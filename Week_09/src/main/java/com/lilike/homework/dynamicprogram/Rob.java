package com.lilike.homework.dynamicprogram;

/**
 *
 *  打家劫舍
 *  https://leetcode-cn.com/problems/house-robber/
 * @Author llk
 * @Date 2020/9/22 15:18
 * @Version 1.0
 */
public class Rob {

    /**
     *  连续的房子不能偷
     *      dp[n] = max{ dp[n-1] , dp[n-2] + nums[n] }
     *
     *  dp[n] 表示的第n家的最大收益
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        nums[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1] , nums[i-2] + nums[i]);
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {

    }


}
