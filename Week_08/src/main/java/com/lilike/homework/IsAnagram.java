package com.lilike.homework;



import java.util.Arrays;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @Author llk
 * @Date 2020/9/18 22:03
 * @Version 1.0
 */
public class IsAnagram {

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }


}
