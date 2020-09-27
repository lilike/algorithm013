package com.lilike.homework.dynamicprogram;

/**
 *   爬楼梯问题
 *   https://leetcode-cn.com/problems/climbing-stairs/
 * @Author llk
 * @Date 2020/9/22 14:42
 * @Version 1.0
 */
public class ClimbStairs {

    /**
     *  f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) return n;
        int first = 1, second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
