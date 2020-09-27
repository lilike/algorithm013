package com.lilike.homework.dynamicprogram;

/**
 * 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @Author llk
 * @Date 2020/9/22 15:38
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public class ObstacleGrid {

    /**
     *  DP方程:
     *       if i == 0 { if nums[i][j] == 1 then  dp[i][j] = 0 else dp[i][j] = dp[i][j-1]  }
     *       if j == 0 { if nums[i][j] == 1 then  dp[i][j] = 0 else dp[i][j] = dp[i-1][j]  }
     *       else
     *          dp[i][j] = dp[i-1][j] + dp[i][j-1];
     *          如果 nums[i][j] = 1 then dp[i][j] = 0
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int nr = obstacleGrid.length, nc = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[nr - 1][nc - 1] == 1) return 0;

        int[][] dp = new int[nr][nc];
        dp[0][0] = 1;
        for (int i = 1; i < nr; i++) {
            if (obstacleGrid[i - 1][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }

        for (int j = 1; j < nc; j++) {
            if (obstacleGrid[0][j - 1] == 0) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nc; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                int up = obstacleGrid[i][j - 1];
                int left = obstacleGrid[i - 1][j];
                int gridIJ = 0;
                if (up == 0) {
                    gridIJ += dp[i][j - 1];
                }
                if (left == 0) {
                    gridIJ += dp[i - 1][j];
                }
                dp[i][j] = gridIJ;
            }
        }
        return dp[nr - 1][nc - 1];
    }



    public static void main(String[] args) {

    }

}
