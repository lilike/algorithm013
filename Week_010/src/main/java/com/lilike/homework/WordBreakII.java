package com.lilike.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分II
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 * @Author llk
 * @Date 2020/11/1 10:10
 * @Version 1.0
 */
public class WordBreakII {


    /**
     * 使用深度优先遍历的方式来解决
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<String>(wordDict), new HashMap<String, List<String>>());
    }

    /**
     * @param s        字符串
     * @param wordDict 单词字典
     * @param map      字符串 : 对应的所有的分割结果
     * @return s字符串对应的分割结果
     */
    private List<String> dfs(String s, HashSet<String> wordDict, HashMap<String, List<String>> map) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {

            if (s.startsWith(word)) {
                List<String> dfs = dfs(s.substring(word.length()), wordDict, map);
                for (String df : dfs) {
                    res.add(word + (df.isEmpty() ? "" : " ") + df);
                }
            }
        }

        map.put(s,res);

        return res;
    }

}
