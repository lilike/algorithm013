package com.lilike.homework;

/**
 * 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @Author llk
 * @Date 2020/9/2 13:35
 * @Version 1.0
 */
public class MaxSubArray {


    /**
     *
     * 这是一道典型的动态规划问题:
     *
     *  我们设dp[i] 以 index = i 的值为结尾的最大子序和
     *  那么dp[i] 和 dp[i-1] 之间有什么关系呢? 如果dp[i-1] > 0 , 那么一定有 dp[i] = dp[i-1] + nums[i], 因为正数加上任何数都会变大
     *  如果 dp[i-1] < 0 呢,由于负数加上任何数都会变小,所以我加上你我还不如另起炉灶,所以 dp[i] = nums[i]
     *  从 dp[0] 开始, dp[0] 一定是等于 nums[0]的
     *
     *  总结:
     *      dp[0] = nums[0]
     *      dp[n] = dp[n-1] > 0 ? dp[n-1] + nums[n] : nums[n]
     *
     *  就可以通过for循环线性解决问题
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxDp = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            }else {
                dp = nums[i];
            }
            maxDp = Math.max(dp,maxDp);
        }
        return maxDp;
    }


    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int su = nums[i];
            sum = Math.max(su, sum);
            for (int j = i + 1; j < nums.length; j++) {
                su += nums[j];
                sum = Math.max(su, sum);
            }
        }
        return sum;
    }

}
