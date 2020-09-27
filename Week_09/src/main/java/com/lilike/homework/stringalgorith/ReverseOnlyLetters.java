package com.lilike.homework.stringalgorith;

/**
 *
 *  仅仅反转字母
 *  https://leetcode-cn.com/problems/reverse-only-letters/
 * @Author llk
 * @Date 2020/9/26 22:05
 * @Version 1.0
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;

        char[] chars = S.toCharArray();
        for (int i = 0,j=chars.length-1; i < j; i++,j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        int index = 0;
        char[] sChars = S.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if ((sChars[i] >= 'a' && sChars[i] <= 'z') || ( sChars[i] >= 'A' && sChars[i] <= 'Z' )) {
                while ((chars[index] < 'a' || chars[index] > 'z') && ( chars[index] < 'A' || chars[index] > 'Z' )) {
                    index++;
                }
                sChars[i] = chars[index];
                index++;
            }
        }
        return new String(sChars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }

}
