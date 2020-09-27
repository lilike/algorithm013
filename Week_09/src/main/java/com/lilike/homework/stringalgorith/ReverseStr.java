package com.lilike.homework.stringalgorith;

/**
 * 反转字符串II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @Author llk
 * @Date 2020/9/26 21:37
 * @Version 1.0
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return s;

        char[] chars = s.toCharArray();

        int slow = 0, fast = 2 * k;
        while (fast < s.length()) {
            reverseStr(chars, slow, slow + k-1);
            slow = fast;
            fast = fast + 2 * k;
        }

        reverseStr(chars, slow, slow + k > s.length()  ? s.length() - 1 : slow + k-1);
        return new String(chars);
    }

    private void reverseStr(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }


    }


    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg",2));
    }
}
