package com.lilike.homework;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @Author llk
 * @Date 2020/9/2 16:52
 * @Version 1.0
 */
public class MinPathSum {

    /**
     *  左上角 --> 右下角
     *  DP方程
     *  DP[i,j] = min{ grid[i-1][j], grid[i][[j-1]] } + grid[i][j]
     *  如果 i < 0 说明在边界上面,只能从左往右 DP[i,j] = DP[i,j-1] + grid[i][j]
     *  如果 j < 0 说明在边界上,只能从上往下 DP[i,j] = DP[i-1,j] + grid[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if (grid == null || grid[0].length == 0) return -1;

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j] , grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

}
