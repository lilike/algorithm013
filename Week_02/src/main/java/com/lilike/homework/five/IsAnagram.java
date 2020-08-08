package com.lilike.homework.five;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *  有效字母异位词
 *
 *  示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @file IsAnagram.java
 * @author lyric
 * @date 2020/8/3
 */
public class IsAnagram {

    public static void main(String[] args) {

    }

    /**
     * 异位词 : 长度相同,字母相同.位置不同
     *  方法1: hashTable 实现
     *  方法2: 字母排序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length() ) {
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        return Arrays.toString(sChars).equals(Arrays.toString(tChars));
    }



}
