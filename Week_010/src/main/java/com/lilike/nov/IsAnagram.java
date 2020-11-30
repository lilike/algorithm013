package com.lilike.nov;

import java.util.Arrays;

/**
 *  有效的字母一异位置词
 *   https://leetcode-cn.com/problems/valid-anagram/
 * @Author llk
 * @Date 2020/11/22 15:04
 * @Version 1.0
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);


        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        return new String(sChars).equals(new String(tChars));

    }


}
