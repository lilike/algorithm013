package com.lilike.homework.eleven;

/**
 * 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @Author llk
 * @Date 2020/8/19 15:38
 * @Version 1.0
 */
public class IsPerfectSquare {

    /**
     * 二分查找,找到一个数的平方等于目标值
     * 注意: 题目说了是正整数
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(9));
    }

}
