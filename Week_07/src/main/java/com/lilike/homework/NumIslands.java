package com.lilike.homework;

/**
 *  岛屿数量
 *  https://leetcode-cn.com/problems/number-of-islands/
 *
 * @Author llk
 * @Date 2020/9/9 21:15
 * @Version 1.0
 */
public class NumIslands {

    class MyUnionFind {

        int[] parent;
        int count;

        public MyUnionFind(char[][] grid) {
            int nr = grid.length;
            int nc = grid[0].length;
            parent = new int[nr * nc];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * nc + j] = i * nc + j;
                        count++;
                    }
                }
            }
        }


        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }


        public int union(int x, int y) {
            int xP = find(x);
            int yP = find(y);
            if (xP != yP) {
                parent[yP] = xP;
                count--;
            }
            return xP;
        }

        public int getCount() {
            return count;
        }

    }


    public int numIslands2(char[][] grid) {

        int nr = grid.length;
        int nc = grid[0].length;
        MyUnionFind myUnionFind = new MyUnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        myUnionFind.union(i * nc + j, (i - 1) * nc + j);
                    }
                    if (i + 1 < nr && grid[i + 1][j] == '1') {
                        myUnionFind.union(i * nc + j, (i + 1) * nc + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        myUnionFind.union(i * nc + j, i * nc + (j - 1));
                    }
                    if (j + 1 < nc && grid[i][j + 1] == '1') {
                        myUnionFind.union(i * nc + j, i * nc + j + 1);
                    }
                }
            }
        }
        return myUnionFind.getCount();
    }


    /**
     * 首先用DFS实现一遍
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;

        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    dfsSearch(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private void dfsSearch(char[][] grid, int i, int j) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfsSearch(grid, i - 1, j);
        dfsSearch(grid, i + 1, j);
        dfsSearch(grid, i, j - 1);
        dfsSearch(grid, i, j + 1);
    }


    public static void main(String[] args) {

    }


}
