package com.lilike.homework.stringalgorith;

import java.util.*;

/**
 *  字母异位词分组
 *  https://leetcode-cn.com/problems/group-anagrams/
 * @Author llk
 * @Date 2020/9/28 16:35
 * @Version 1.0
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0 ) return new ArrayList<>();
        Map<String,List<String>> res = new HashMap<>();
        for (String str : strs) {
            String tmp = transfer(str);
            List<String> list = res.getOrDefault(tmp, new ArrayList<>());
            list.add(str);
            res.put(tmp,list);
        }
        return new ArrayList<>(res.values());
    }

    private String transfer(String str) {
        char[] tempChar = str.toCharArray();
        Arrays.sort(tempChar);
        return new String(tempChar);
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }


}
