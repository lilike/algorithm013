package com.lilike.homework;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @Author llk
 * @Date 2020/9/9 23:09
 * @Version 1.0
 */
public class Solve {


    /**
     * 使用并查集实现一遍
     * @param board
     */
    public void solve2(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;

        UnionFound unionFound = new UnionFound(nr*nc+1);
        int dummyNode = nr * nc;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == nr-1 || j == nc -1) {
                        unionFound.union(i*nc+j,dummyNode);
                    }else {
                        if (i > 0 && board[i-1][j] == 'O') {
                            unionFound.union(i*nc+j,(i-1)*nc+j);
                        }

                        if (i+1 <= nr && board[i+1][j] == 'O') {
                            unionFound.union(i*nc+j,(i+1)*nc+j);
                        }

                        if (j > 0 && board[i][j-1] == 'O' ) {
                            unionFound.union(i*nc+j,i*nc+j-1);
                        }

                        if (j <= nc && board[i][j+1] == 'O') {
                            unionFound.union(i*nc+j,i*nc+j+1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (unionFound.find(i*nc+j) == unionFound.find(dummyNode)) {
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }

        }



    }



    /**
     * 首先用DFS的方法进行解决
     * <p>
     * 从边界出发,所有和边界相连接的进行标记
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int nr = board.length;
        int nc = board[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                boolean isBianjie = i == 0 || j == 0 || i == nr - 1 || j == nc - 1;
                if (isBianjie && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {

        int nr = board.length;
        int nc = board[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        board[i][j] = '#';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }


    public static void main(String[] args) {

    }
}
