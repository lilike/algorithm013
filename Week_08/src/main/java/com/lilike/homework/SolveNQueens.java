package com.lilike.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/description/
 * N皇后问题
 *
 * @Author llk
 * @Date 2020/9/15 20:56
 * @Version 1.0
 */
public class SolveNQueens {


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        backTrack(result, 0, board);
        return result;
    }

    private void backTrack(List<List<String>> result, int colIndex, char[][] board) {
        if (colIndex >= board.length) {
            result.add(contract(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            // 当前这个位置放皇后是不是合法的
            if (valid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                backTrack(result, colIndex + 1, board);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (i == row || i + col == j + row || i + j == row + col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> contract(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
