package com.lilike.homework;

import java.util.Map;

/**
 *  打家劫舍
 *  https://leetcode-cn.com/problems/house-robber/
 * @Author llk
 * @Date 2020/9/5 9:46
 * @Version 1.0
 */
public class Rob {

    /**
     *  DP方程
     *
     *  如果只有一家,那么直接偷就可以了,那么DP(0) = nums[0]
     *  如果有两家,那么就偷两家之间的最大的,DP(1) = max{nums[0],nums[1]}
     *  如果有N家,那么在偷第 n 家的时候
     *      有两种选择,一种是选择偷n家,一种是选择不偷n家
     *          如果偷n家,那么就是DP(n-2) + nums[n]
     *          如果不偷 n 家,那么就是 DP(n-1)
     *      DP(n) = max { DP(n-1)  , DP(n-2) + nums[n] }
     *
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1],nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }


    public static void main(String[] args) {

    }

}
