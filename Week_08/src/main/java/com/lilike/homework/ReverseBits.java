package com.lilike.homework;

/**
 *  颠倒二进制位
 *  https://leetcode-cn.com/problems/reverse-bits/
 * @Author llk
 * @Date 2020/9/15 17:30
 * @Version 1.0
 */
public class ReverseBits {

    public int reverseBits(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {


    }

}
