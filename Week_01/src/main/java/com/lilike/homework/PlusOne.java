package com.lilike.homework;

import java.util.Arrays;

/***
 *  https://leetcode-cn.com/problems/plus-one/
 *
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 * @file PlusOne.java
 * @author lyric
 * @date 2020/7/28
 */
public class PlusOne {

    public static void main(String[] args) {

    }


    /**
     *  模拟一个进位
     *  从最后一位开始,从后往前进行递进,+1
     *  两种情况:
     *      1. 小于等于9
     *      2. 等于9
     *
     *   如果小于等于9加上1后直接返回
     *   如果是9,那么这位就是9,上一位加上1 以此类推
     *   如果到最前面一位还是没有退出循环,那么就创建一个新的数组,然后第一位设置为1
     *
     *
     *
     * @param digits
     * @return
     */
    public int[] solution1(int[] digits) {

        for (int i = digits.length -1 ; i >= 0 ; i--) {

            digits[i] ++;

            if (digits[i] % 10 != 0) {
                return digits;
            }
            digits[i] = 0;
        }

        // 循环结束了,但是还是没有 例如 999
        int[] result = new int[digits.length + 1];
        result[0] = 1;

       return result;
    }

}
