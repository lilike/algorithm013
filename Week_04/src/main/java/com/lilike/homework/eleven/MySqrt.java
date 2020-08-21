package com.lilike.homework.eleven;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * x的平方根
 *
 * @Author llk
 * @Date 2020/8/19 15:20
 * @Version 1.0
 */
public class MySqrt {

    /**
     * 单调递增 有上下界 可以用二分查找法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        int left = 1;
        int right = x;
        int mid;
        int result = -1;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if ((long)mid*mid <= x) {
                result = mid; // 可以接受小一点
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(3));
    }


}
