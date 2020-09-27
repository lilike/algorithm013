package com.lilike.homework.stringalgorith;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  反转字符串里面的单词
 *  https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @Author llk
 * @Date 2020/9/26 21:57
 * @Version 1.0
 */
public class ReverseWordsIII {


    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            s1[i] = reverse(s1[i]);
        }
        return Arrays.stream(s1).collect(Collectors.joining(" " ));
    }

    private String reverse(String str) {
        char[] s = str.toCharArray();
        for (int i = 0,j = s.length - 1; i < j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return new String(s);
    }

    public static void main(String[] args) {

    }

}
