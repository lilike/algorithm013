package com.lilike.homework;

/**
 * 计算回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @Author llk
 * @Date 2020/9/6 19:38
 * @Version 1.0
 */
public class CountSubstrings {

    /**
     * 计算回文子串
     *      采用动态规划
     *      二维数组 boolean[i][j]
     *          dp[i][j] 表示 字符串范围 i...j 是不是一个回文子串
     *          如果i== j 那么就是单个字符,就一定是回文子串
     *          如果 j - i == 1 ,那么字符串的长度为2, 那么如果 s[i] == s[j] ,就表示一定是回文子串
     *          如果 j - i > 1 , 只要 s[i] == s[j] 并且 dp[i-1][j-1] 是回文子串,就OK了
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                }else if (j-i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }else if (j-i > 1 && s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }

}
