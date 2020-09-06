package com.lilike.homework;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 不同路径
 *
 * @Author llk
 * @Date 2020/8/31 19:20
 * @Version 1.0
 */
public class UniquePaths {


    /**
     * 典型的动态规划类的题目,写出地推公式
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m*n == 0) return 0;
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[n - 1][m - 1];

    }


    public int uniquePaths2(int m, int n) {
        if (m*n == 0) return 0;
        int[] grid = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    grid[j] = 1;
                }else {
                    grid[j] = grid[j-1] + grid[j];
                }
            }

        }
        return grid[m-1];
    }


    public static void main(String[] args) {


    }


}
