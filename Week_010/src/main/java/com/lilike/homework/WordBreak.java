package com.lilike.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *  https://leetcode-cn.com/problems/word-break/
 * @Author llk
 * @Date 2020/11/1 9:22
 * @Version 1.0
 */
public class WordBreak {


    /**
     *
     *  使用动态规划的方法来解决这个问题
     *      首先定义dp方程
     *
     *          dp[i] 就表示 s.subStr(0...i)是合法的
     *          那么对于字符串 s[0:i]
     *              一定存在一个坐标j
     *              使得 s[0:j] 和 s[j:i]都是合法的
     *              即使j = 0 也就是一个单词的时候
     *
     *          那么动态规划方程就是:
     *              dp[i] = dp[j] && check(s[j:i])
     *
     *
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordHashTable = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordHashTable.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

        System.out.println(new WordBreak().wordBreak("leetcode",Arrays.asList("leet","code")));

    }


}
