package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author llk
 * @Date 2020/9/10 23:13
 * @Version 1.0
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length == 0) return false;

        Map<Integer,Integer>[] row = new HashMap[9];
        Map<Integer,Integer>[] col = new HashMap[9];
        Map<Integer,Integer>[] block = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            block[i] = new HashMap<Integer, Integer>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = Integer.valueOf(board[i][j]+"");
                    row[i].put(n,row[i].getOrDefault(n,0) + 1);
                    col[j].put(n,col[j].getOrDefault(n,0)+1);
                    int blockIndex = (i/3) * 3 + j / 3;
                    block[blockIndex].put(n,block[blockIndex].getOrDefault(n,0)+1);

                    if (row[i].get(n) > 1 || col[j].get(n) > 1 || block[blockIndex].get(n) > 1) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }


}
