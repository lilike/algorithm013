package com.lilike.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author llk
 * @Date 2020/9/12 9:18
 * @Version 1.0
 */
public class SolveNQueens {

    /**
     * 解决N皇后问题
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {

        // 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
        // 递归回溯查找
        dfs(board,0,result);
        return result;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> result) {

        // terminator
        if (colIndex == board.length) {
            result.add(constract(board));
            return;
        }


        // 遍历列
        for (int i = 0; i < board.length; i++) {
            if (validate(board,i,colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board,colIndex+1,result);
                board[i][colIndex] = '.';
            }
        }



    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (i == x || x + y == i + j || i + y == x + j )) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> constract(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }


    public static void main(String[] args) {

        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        for (int i = 0; i < lists.size(); i++) {
            List<String> str = lists.get(i);
            for (int j = 0; j < str.size(); j++) {
                System.out.println(str.get(j));
            }
            System.out.println();
            System.out.println();
        }
    }
}
