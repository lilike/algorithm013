package com.lilike.homework.stringalgorith;

import java.util.Arrays;
import java.util.Collections;

/**
 *  反转字符串
 *  https://leetcode-cn.com/problems/reverse-string/
 *
 * @Author llk
 * @Date 2020/9/26 21:32
 * @Version 1.0
 */
public class ReverseString {


    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        for (int i = 0,j = s.length - 1; i < j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }


    public static void main(String[] args) {

    }
}
