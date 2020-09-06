package com.lilike.homework;

/**
 *  解码方法
 *  https://leetcode-cn.com/problems/decode-ways/
 * @Author llk
 * @Date 2020/9/2 17:07
 * @Version 1.0
 */
public class NumDecodings {


    /**
     *  使用 dp[i] 表示以i结尾的单词的解码方法总数
     *      如果s[i] == 0 && s[i-1] == 1 || s[i-1] == 2
     *             那么s[i] 和 s[i-1] 的接码就无法分割. dp[i] = dp[i-2] , 否则就是 0
     *
     *      如果 s[i] != 0 && s[i-1] == 1 的时候.那么 s[i] 和 s[i-1] 就可以合并或是分开接码
     *          dp[i] = dp[i-1] + dp[i-2]
     *
     *      如果 s[i] != 0 && s[i-1] == 2 && s[i] >> {1..6} 的时候,那么 s[i] 和 s[i-1] 就可以合并或是分开接码
     *          dp[i] = dp[i-1] + dp[i-2]
     *          否则只能分开接码
     *          dp[i] = dp[i-1]
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || "".equals(s)) return 0;
        int[] sNums = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        sNums[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    sNums[i] = sNums[i-2 < 0 ? 0 : i-2];
                }else {
                    return 0;
                }
            }else if (s.charAt(i-1) == '1') {
                sNums[i] = sNums[i-1] + sNums[i-2 < 0 ? 0 : i-2];
            }else if (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                    sNums[i] = sNums[i-1] + sNums[i-2 < 0 ? 0 : i-2];
            }else {
                sNums[i] = sNums[i-1];
            }

        }
        return sNums[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("27"));
    }

}

///  1 0 1 3 0 5 2