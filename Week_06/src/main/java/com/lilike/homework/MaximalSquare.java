package com.lilike.homework;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/9/6 17:54
 * @Version 1.0
 */
public class MaximalSquare {

    /**
     * 最大的正方形
     * dp[i][j] 表示是以坐标 i,j 为右下角的正方形的变长.
     * 如果i == 0 or j == 0 ,那么 i 最多就是只能为 1
     * 否则的话 如果 matrix[i][j] == 1
     * dp[i][j] = min { dp[i-1][j], dp[i][j-1], dp[i-1][j-1] } + 1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int nr = matrix.length;
        int nc = matrix[0].length;

        int[][] dp = new int[nr][nc];
        int maxSide = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return maxSide * maxSide;
    }


    public static void main(String[] args) {

        char[][] matrix = {{'1'}};

        System.out.println(new MaximalSquare().maximalSquare(matrix));

    }

}
