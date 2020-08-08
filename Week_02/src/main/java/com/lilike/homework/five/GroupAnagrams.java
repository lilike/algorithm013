package com.lilike.homework.five;

import java.util.*;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * @file GroupAnagrams.java
 * @author lyric
 * @date 2020/8/3
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(lists);


    }

    /**
     *  方法1 : 遍历每个字符串,然后进行排序转换,存入hash表
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            String sxStr = transferStr(str);
            if (map.keySet().contains(sxStr)) {
                List<String> strings = map.get(sxStr);
                strings.add(str);
            }else {
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(sxStr,temp);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    private String transferStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }


}
