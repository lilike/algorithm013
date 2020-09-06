package com.lilike.homework;

/**
 * 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @Author llk
 * @Date 2020/8/31 19:36
 * @Version 1.0
 */
public class UniquePathsWithObstacles {

    /**
     * 典型的动态规划的题目
     * 直接在原数组上面操作即可
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int nr = obstacleGrid.length;
        int nc = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;
        for (int i = 1; i < nr; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            }else {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }

        for (int i = 1; i < nc; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            }else {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }
        }

        for (int i = 1; i < nr; i++) {
            for (int j = 1; j < nc; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else if (j == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[nr - 1][nc - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

}
