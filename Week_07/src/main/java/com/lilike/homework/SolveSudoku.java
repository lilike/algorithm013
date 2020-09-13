package com.lilike.homework;

/**
 * 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/#/description
 *
 * @Author llk
 * @Date 2020/9/11 21:31
 * @Version 1.0
 */
public class SolveSudoku {


    /**
     * 解决数独问题,其实就是采用回溯的方法
     * @param board
     */
    public void solveSudoku(char[][] board) {

        if (board == null || board.length == 0 ) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board,i,j,k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int l = 0; l < 9; l++) {
            // row
            if (board[l][col] != '.' && board[l][col] == c) return false;
            if (board[row][l] != '.' && board[row][l] == c) return false;
            if (board[(row/3)*3+l/3][(row/3)*3+l%3] != '.' && board[(row/3)*3+l/3][(row/3)*3+l%3] == c) return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }


}
