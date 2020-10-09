package com.lilike.homework.stringalgorith;

import java.util.Arrays;

/**
 *  有效的字母异位词
 *   https://leetcode-cn.com/problems/valid-anagram/
 * @Author llk
 * @Date 2020/9/28 16:07
 * @Version 1.0
 */
public class IsAnagram {

    /**
     * 判断两个词是否是有效的已为此
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        return sortStr(s).equals(sortStr(t));
    }

    private String sortStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    public static void main(String[] args) {

    }


}
