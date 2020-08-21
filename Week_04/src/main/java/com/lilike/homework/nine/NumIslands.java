package com.lilike.homework.nine;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @Author llk
 * @Date 2020/8/18 21:38
 * @Version 1.0
 */
public class NumIslands {

    private int nums = 0;

    /**
     * 使用bfs 如果找到一个1 就进行递归
     * 递归包含上下左右
     *      去搜索四周所有的岛屿并标记为0
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid.length == 0) return nums;

        int nr = grid.length;
        int nc = grid[0].length;


        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid,i,j);
                }
            }
        }
        return nums;
    }

    // 把所有与这个 1 相连的其他 1 变成 0
    private void dfs(char[][] grid, int i, int j) {

        int nr = grid.length-1;
        int nc = grid[0].length-1;

        // terminator
        if ( i < 0 || j< 0 || i > nr || j > nc || grid[i][j] == '0' ) {
            return;
        }

        grid[i][j] = '0';


        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }

    public static void main(String[] args) {
        char[][] arg = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

       NumIslands numIslands = new NumIslands();
         numIslands.numIslands(arg);
        System.out.println(numIslands.nums);


    }
}
