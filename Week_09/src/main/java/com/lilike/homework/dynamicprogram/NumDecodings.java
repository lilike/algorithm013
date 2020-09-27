package com.lilike.homework.dynamicprogram;

/**
 *  解码方法
 *  https://leetcode-cn.com/problems/decode-ways/
 * @Author llk
 * @Date 2020/9/25 9:01
 * @Version 1.0
 */
public class NumDecodings {

    /**
     *  使用动态规划来求解
     *      dp[i] : 表示的是字符串 s[0:i] 的解码方法数量
     *             如果 s[i] >= 1 && s[i] <= 9
     *             其实他自己可以自成一体
     *
     *             dp[i] += dp[i-1]
     *
     *             如果 s[i-1]s[i] >= 10 && s[i-1]s[i] <= 26
     *             那么这个组合又可以自成一体
     *              dp[i] += dp[i-2]
     *
     *
     *
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1 ;

        for (int i = 2; i < n + 1; i++) {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));

            if (first != 0) {
                dp[i] += dp[i-1];
            }

            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }

        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("10"));
    }

}
