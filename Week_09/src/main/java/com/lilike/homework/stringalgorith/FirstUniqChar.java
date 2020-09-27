package com.lilike.homework.stringalgorith;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  字符串中的唯一字符
 *  https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @Author llk
 * @Date 2020/9/26 11:04
 * @Version 1.0
 */
public class FirstUniqChar {

    /**
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        Map<Character,Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            cache.put(c,cache.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (cache.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }


}
