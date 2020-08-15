package com.lilike.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author llk
 * @Date 2020/8/15 17:21
 * @Version 1.0
 */
public class NQueens {

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board,0,result);
        return result;
    }

    private void backtrack(char[][] board, int colIndex, List<List<String>> result) {

        if (colIndex == board.length) {
            result.add(constact(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(board,i,colIndex)) {
                board[i][colIndex] = 'Q';
                backtrack(board,colIndex+1,result);
                board[i][colIndex] = '.';
            }
        }
    }

    /**
     * 校验当前棋盘是否合法
     * @param board
     * @param x
     * @param y
     * @return
     */
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && ( x == i || i + y == x + j || x + y == i + j )) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> constact(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }


}
