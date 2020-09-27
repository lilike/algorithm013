package com.lilike.homework.dynamicprogram;

/**
 * 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @Author llk
 * @Date 2020/9/24 16:56
 * @Version 1.0
 */
public class LengthOfLIS {

    /**
     * 定义一个dp[i]
     * 表示以nums[i]结尾的最长的上升子序列的长度
     * max = Math.max{dp[j]}
     * for( 0 ... i)
     * for ( i ... j)
     * if(nums[j]  > nums[i]) {
     * dp[j] = Math.max {dp[i] + 1 ..... };
     * }
     * 时间复杂度是N^2的
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{ 10,9,2,5,3,4}));

    }


}
