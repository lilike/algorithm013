package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/9/1 20:57
 * @Version 1.0
 */
public class ClimbStairs {


    /**
     * 递推公式
     * F(n) = F(n-1) + F(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) return n;

        int[] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;


        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        return nums[n];
    }

    public static void main(String[] args) {


    }
}
