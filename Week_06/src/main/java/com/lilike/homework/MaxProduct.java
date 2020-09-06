package com.lilike.homework;

/**
 *  乘积最大子数组
 *  https://leetcode-cn.com/problems/maximum-product-subarray/description/
 * @Author llk
 * @Date 2020/9/2 14:20
 * @Version 1.0
 */
public class MaxProduct {


    /**
     *  定义dp[i] 为以 nums[i] 结尾的乘积结果
     *  记录dp[i]的最小值和最大值
     *  dpmax[i] = max{ dp[i-1] * nums[i], nums[i] }
     *  dpmin[i] = min{ dp[i-1] * nums[i], nums[i] }
     *
     *  如果遇到负数,可以交换max和min ,然后相乘
     *
     *  最后拿结果与ans进行比较
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int ans = Integer.MIN_VALUE;
        int dpMax  = 1; int dpMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = dpMax;
                dpMax = dpMin;
                dpMin = temp;
            }

            dpMax = Math.max(nums[i] * dpMax, nums[i]);
            dpMin = Math.min(nums[i] * dpMin,nums[i]);

            ans = Math.max(dpMax,ans);
        }
        return ans;

    }


}
