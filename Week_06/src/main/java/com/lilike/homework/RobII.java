package com.lilike.homework;

import java.util.Arrays;

/**
 *  打家劫舍II
 *  https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 * @Author llk
 * @Date 2020/9/5 9:54
 * @Version 1.0
 */
public class RobII {

    /**
     * 和打家劫舍不同的是,首位相连,就是如果偷了第一家,就不能偷最后一家
     *  两种选择,偷第一家,不偷第一家
     *      result = max{ DP(0~n-1),DP(1~n}}
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob1(nums1),rob1(nums2));
    }

    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }


    public static void main(String[] args) {

    }

}
