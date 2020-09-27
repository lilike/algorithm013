package com.lilike.homework.dynamicprogram;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @Author llk
 * @Date 2020/9/22 15:28
 * @Version 1.0
 */
public class MinPathSum {

    /**
     *  最小路径是
     *   也是限制了只能向下或是向右移动,那么空间复杂度是可以按照O(1)来搞的
     *      dp[i][j] = min{ dp[i-1][j] , dp[i][j-1] } + grid[i][j];
     *
     *      dp[i][j] 表示 在 i,j 这个位置的最小路径和
     *
     *      当 i == 0
     *          dp[i][j] = dp[i][j-1] + grid[i][j]
     *
     *      当 j == 0
     *          dp[i][j] = dp[i-1][j] + grid[i][j]
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 ) return 0;

        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 1; i < nr; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < nc; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nc; j++) {
                grid[i][j] = Math.min(grid[i-1][j] , grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[nr-1][nc-1];
    }


    public static void main(String[] args) {

    }

}
