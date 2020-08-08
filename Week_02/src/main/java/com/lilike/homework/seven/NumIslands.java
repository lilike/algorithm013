package com.lilike.homework.seven;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿数量
 *
 * @Author llk
 * @Date 2020/8/7 17:19
 * @Version 1.0
 */
public class NumIslands {

    public static void main(String[] args) {

        char[][] nums = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(new NumIslands().numIslands2(nums));

    }

    /**
     * 广度优先算法
     * https://leetcode-cn.com/problems/number-of-islands/
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {

        // 广度优先,就是把四周的值加入到队列里面,如果是0就不要加队列了


        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nc = grid.length;
        int nr = grid[0].length;

        int numsIsland = 0;

        Deque<Zb> deque = new LinkedList<>();

        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < nr; j++) {

                if (grid[i][j] == '1') {
                    numsIsland++;
                    deque.addLast(new Zb(i, j));
                    bfs(grid, deque);
                }
            }
        }
        return numsIsland;
    }

    private void bfs(char[][] grid, Deque<Zb> deque) {
        while (deque.size() > 0) {
            Zb zb = deque.poll();
            checkZb(zb.x - 1, zb.y, grid, deque);
            checkZb(zb.x + 1, zb.y, grid, deque);
            checkZb(zb.x, zb.y - 1, grid, deque);
            checkZb(zb.x, zb.y + 1, grid, deque);
        }
    }

    private boolean checkZb(int i, int y, char[][] grid, Deque<Zb> deque) {
        int nc = grid.length - 1;
        int nr = grid[0].length - 1;

        if (i > nc || y > nr || i < 0 || y < 0 || grid[i][y] == '0') {
            return false;
        }

        deque.addLast(new Zb(i, y));
        grid[i][y] = '0';
        return true;
    }


    /**
     * 深度优先算法
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 深度优先算法的次数等于岛屿的数量

        int nc = grid.length;
        int nr = grid[0].length;

        int numIslands = 0;

        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < nr; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    // 进入dfs把这个的岛屿的变成海,如果遇到海就返回
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nc = grid.length - 1;
        int nr = grid[0].length - 1;

        if (i < 0 || j < 0 || i > nc || j > nr || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);

    }


}

class Zb {
    public int x;
    public int y;

    public Zb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}