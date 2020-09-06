package com.lilike.homework;

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * @Author llk
 * @Date 2020/8/31 23:05
 * @Version 1.0
 */
public class LongestCommonSubsequence {

    /**
     * 典型的动态规划问题,需要建立一个二维矩阵,然后进行递推
     * <p>
     * 递归公式:
     * 如果 字符串末尾相同,那么就等于前面的子序列的最大公共子串 + 1
     * 如果字符串末尾不同, 那么就等于 Math.max(text1.sub(0,text1.length-1),text2.sub(0,text2.length-1))
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] memory = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i < text1.length()+1; i++) {
            memory[i][0] = 0;
        }

        for (int i = 0; i < text2.length()+1; i++) {
            memory[0][i] = 0;
        }

        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    memory[i][j] = memory[i-1][j-1] + 1;
                }else {
                    memory[i][j] = Math.max(memory[i-1][j],memory[i][j-1]);
                }

            }
        }
        return memory[text1.length()][text2.length()];
    }


}
