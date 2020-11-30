package com.lilike.nov;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/11/26 17:07
 * @Version 1.0
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if ((nums[i+1] - nums[i]) > max) {
                max = nums[i+1] - nums[i];
            }
        }
        return max;
    }

}
