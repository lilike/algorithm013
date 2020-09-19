package com.lilike.homework;

/**
 * 计算比特位数
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * @Author llk
 * @Date 2020/9/15 21:32
 * @Version 1.0
 */
public class CountBits {


    public int[] countBits(int num) {
        int result[] = new int[num+1];
        for (int i = 0; i <= num; i++) {
            result[i] = getBitCounts(i);
        }
        return result;
    }

    private int getBitCounts(int i) {
        int count = 0;
        while (i != 0 ) {
            i = i & (i-1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {

    }

}
