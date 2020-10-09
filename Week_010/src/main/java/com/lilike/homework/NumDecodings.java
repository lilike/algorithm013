package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/10/8 15:23
 * @Version 1.0
 */
public class NumDecodings {

    /**
     *
     *  dp[i] 表示以 i 结尾的有多少种解码的方法
     *
     *  典型的动态规划问题
     *      1. 首先如果首位是 0 直接返回 0 无法解码
     *      2. 如果首位不是 0
     *          dp[0] = 1
     *      3.  然后开始从1开始遍历
     *          如果当前的位数为0:
     *              如果前面是0: 00 直接返回0
     *              如果前面不是0并且是 1 和 2 ,那么dp[i] = dp[i-2], 因为当前位只能和 i-1位为一个整体
     *              如果前面的 > 2 那么返回0
     *
     *        4. 如果当前位数不是 0
     *              前一位是0吗?
     *                  如果是0, 那么dp[i] = dp[i-1], 因为当前位只能和自己组合
     *                  如果不是 0
     *                      那么和前面一位组合 <= 26
     *                          那么可以和前一位组合起来,也可以不组合起来
     *                              dp[i] = dp[i-2] + dp[i-1];
     *                      如果和前面一位组合起来 > 26
     *                              dp[i] = dp[i-1];
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // 为0的情况
                String sb = s.substring(i-1,i+1);
                if (!"00".equals(sb) && ("10".equals(sb) || "20".equals(sb))) {
                    dp[i] = dp[i-2 < 0 ? 0 : i-2];
                }else {
                    return 0;
                }
            }else {
                // 不为0
                String sb = s.substring(i-1,i+1);
                if (s.charAt(i-1) == '0') {
                    dp[i] = dp[i-1];
                }else {
                    if (Integer.valueOf(sb) <= 26) {
                        dp[i] = dp[i-1] + dp[i-2 < 0 ? 0 : i-2];
                    }else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}
