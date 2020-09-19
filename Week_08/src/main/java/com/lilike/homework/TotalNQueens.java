package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/9/15 21:25
 * @Version 1.0
 */
public class TotalNQueens {

    int ans = 0;

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board,0);
        return -1;
    }

    private void backTrack(char[][] board, int col) {
        if (col >= board.length) {
            ans++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (valid(board,i,col)) {
                board[i][col] = 'Q';
                backTrack(board,col+1);
                board[i][col] = '.';
            }
        }

    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' &&( i-j == row - col || i == row || i+j == row + col  )) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }


}
