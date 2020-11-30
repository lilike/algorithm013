package com.lilike.nov;

import java.util.Arrays;

/**
 *  上升下降 字符串
 *  https://leetcode-cn.com/problems/increasing-decreasing-string/
 * @Author llk
 * @Date 2020/11/25 8:48
 * @Version 1.0
 */
public class SortString {

    public String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        StringBuffer sb = new StringBuffer("");
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)(i+'a'));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0 ; i--) {
                if (count[i] > 0) {
                    sb.append((char)(i+'a'));
                    count[i]--;
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortString().sortString("aaaabbbbcccc"));
    }

}
