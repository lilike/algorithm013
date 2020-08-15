package com.lilike.homework.eight;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * pow(x,n)
 *
 * @Author llk
 * @Date 2020/8/14 14:44
 * @Version 1.0
 */
public class MyPow {


    /***
     * 暴力循环的时间复杂度是O(n)的
     *
     * 但是这个题目的解法可以是O(logN)就是使用分治算法
     *
     * x^10 可以转换为 x^5 * x^5
     * x^5 又可以转换为 x^2 * x^2 * x
     *
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0 ) return fastMyPow(1.0/x, -n);

        return fastMyPow(x,n);

    }

    private double fastMyPow(double x, int n) {

        // terminator
        if (n == 0) return 1;


        // split task and drill down
        double self = fastMyPow(x,n/2);

        if (n %2 == 0) {
            return self * self;
        }else {
            return self * self * x;
        }

    }


    public static void main(String[] args) {

        System.out.println(new MyPow().myPow(2, 10));

    }

}
