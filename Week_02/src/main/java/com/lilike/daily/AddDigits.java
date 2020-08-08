package com.lilike.daily;

/**
 * https://leetcode-cn.com/problems/add-digits/
 * 各位相加
 *
 * @Author l
 * lk
 * @Date 2020/8/7 16:32
 * @Version 1.0
 */
public class AddDigits {

    public static void main(String[] args) {

        System.out.println(addDigits(38));

    }

    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }


    /*
        直觉: 判断是否 > 10,如果大于10,那么就转为字符串,然后toCharArray,然后字符转为数字相加,知道> 10 不成立


     */
    public static int addDigits(int num) {

        while (num >= 10) {
            String numStr = num + "";
            char[] chars = numStr.toCharArray();
            int newNum = 0;
            for (char aChar : chars) {
                newNum += Integer.valueOf(String.valueOf(aChar));
            }
            num = newNum;
        }

        return num;
    }
}
