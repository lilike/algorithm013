package com.lilike.homework;

/**
 *  找不同
 *  https://leetcode-cn.com/problems/find-the-difference/
 * @Author llk
 * @Date 2020/10/8 9:52
 * @Version 1.0
 */
public class FindTheDifference {

    /**
     *   a ^ 0  = a
     *   a ^ a = 0
     *   a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.charAt(t.length() - 1 ));
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }


}
