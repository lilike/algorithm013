package com.lilike.homework.stringalgorith;

/**
 * 字符串转换为整数
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @Author llk
 * @Date 2020/9/26 20:52
 * @Version 1.0
 */
public class MyAtoi {


    public int myAtoi(String str) {
        // 判空
        if (str == null || str.length() == 0) return 0;

        // 定义好结果 索引 余数
        int total = 0, index = 0, sign = 1;

        // 首先去掉空格
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        // 然后判断符号
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }

        // 然后开始进行加法
        while (index < str.length()) {
            int c = str.charAt(index) - '0';
            // 如果遇到的不在0:9之间就直接调处来
            if (c > 9 || c < 0) {
                break;
            }

            // 然后判断是否溢出了
            if (Integer.MAX_VALUE / 10 < total ||
                    ((Integer.MAX_VALUE / 10) == total && Integer.MAX_VALUE % 10 < c)
            ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 然后开始相加
            total = total * 10 + c;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi(" "));
    }

}
