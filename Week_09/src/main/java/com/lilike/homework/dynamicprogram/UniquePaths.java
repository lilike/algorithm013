package com.lilike.homework.dynamicprogram;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 不同路径
 *
 * @Author llk
 * @Date 2020/9/22 14:51
 * @Version 1.0
 */
public class UniquePaths {

    /**
     * 因为只能向下或是向右移动,
     *   就是说一个格子只能从它的上边或是他的左边过来,那么
     *         dp[i,j] = dp[i-1,j] + dp[i,j-1]
     *
     *   当 i = 0 ,也就是只能从上边过来
     *          dp[i,j ] = dp[i,j-1]
     *
     *    当 j = 0 ,
     *          dp[i,j] = dp[i-1,j]
     *
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePaths2(int m,int n) {

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }



    public static void main(String[] args) {

    }
}
