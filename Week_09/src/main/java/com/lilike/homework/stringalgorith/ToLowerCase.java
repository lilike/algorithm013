package com.lilike.homework.stringalgorith;

/**
 * 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 *
 * @Author llk
 * @Date 2020/9/26 10:36
 * @Version 1.0
 */
public class ToLowerCase {

    /**
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') continue;
            if (chars[i] > 'Z' || chars[i] < 'A') {
                continue;
            }
            chars[i] = (char) (chars[i] + 'a' - 'A');
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(new ToLowerCase().toLowerCase("al&phaBET"));

    }
}
