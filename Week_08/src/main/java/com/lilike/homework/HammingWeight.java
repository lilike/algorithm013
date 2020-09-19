package com.lilike.homework;

/**
 *  https://leetcode-cn.com/problems/number-of-1-bits/
 *  位1的个数
 * @Author llk
 * @Date 2020/9/15 8:45
 * @Version 1.0
 */
public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;
        // 把n二进制位的最后一个1变成0
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;

    }

    public static void main(String[] args) {



    }

}
