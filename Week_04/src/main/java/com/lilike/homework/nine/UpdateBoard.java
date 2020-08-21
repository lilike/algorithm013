package com.lilike.homework.nine;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minesweeper/
 * 扫雷游戏
 *
 * @Author llk
 * @Date 2020/8/21 14:32
 * @Version 1.0
 */
public class UpdateBoard {


    /**
     * 扫雷游戏并不是很难
     * 关键在于理解规则:
     * 1. 如果遇到的是M , 就直接标记为X
     * 2. 如果挖出来的是空,但是四周都是有类的,标记类的数量
     * 3. 如果挖出来四周八个块都是空的,那么就递归去搜索周边
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {

        int[][] direction = new int[][]{
                {0, 1}, {0, -1}, {-1, 0}, {1, 0},
                {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
        };

        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y, direction);
        }

        return board;
    }

    private void dfs(char[][] board, int x, int y, int[][] direction) {

        int cnt = 0;
        // 首先搜索这个点的四周是否有雷
        for (int i = 0; i < direction.length; i++) {
            int xDir = x + direction[i][0];
            int yDir = y + direction[i][1];
            if (xDir < 0 || yDir < 0 || xDir >= board.length || yDir >= board[0].length) continue;
            if (board[xDir][yDir] == 'M') cnt++;
        }

        if (cnt > 0) {
            board[x][y] = (char) ('0' + cnt);
        } else {
            for (int i = 0; i < direction.length; i++) {
                board[x][y] = 'B';
                int xDir = x + direction[i][0];
                int yDir = y + direction[i][1];
                if (xDir < 0 || yDir < 0 || xDir >= board.length || yDir >= board[0].length || board[xDir][yDir] != 'E')
                    continue;
                dfs(board, xDir, yDir, direction);
            }
        }
    }

    public static void main(String[] args) {
    }
}
