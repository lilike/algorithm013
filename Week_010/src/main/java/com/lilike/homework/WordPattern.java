package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律
 * http://leetcode-cn.com/problems/word-pattern/
 *
 * @Author llk
 * @Date 2020/10/8 10:08
 * @Version 1.0
 */
public class WordPattern {


    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();

        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            String temp = map.get(pattern.charAt(i));
            if (temp == null) {
               if (map.values().contains(sArray[i])) {
                   return false;
               }else {
                   map.put(pattern.charAt(i),sArray[i]);
               }
            } else {
                if (!temp.equals(sArray[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String pattern = "abba";
        String s = "dog cat cat dog";
        //"abba";
        //"dog dog dog dog";

        System.out.println(new WordPattern().wordPattern(pattern,s));

    }


}
