package com.lilike.daily;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 最小路径之和
 * @Author llk
 * @Date 2020/8/31 11:49
 * @Version 1.0
 */
public class MinPathSum {

    /***
     * 没有思路,直接看的题解
     *      题解说这是典型的动态规划的题目.
     *      目前我们感受到的动态规划的特点是:
     *              1. 可以把一个大问题拆分成很多个子问题
     *              2. 一般来说是解决最优解的问题
     *              3. 一般需要用空间来换取时间
     *
     *  [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     *      这个动态规划题目需要一个矩阵grid[][] 来保存每个节点当前的最小路径和,遍历完了之后,我们取右下角的返回就可以了
     *      因为只能是向右边走或是向下走,所以
     *      分解为四类子问题:
     *          1. 如果是从左上角出发的,那么当前gird[i][j] = grid[i][j]
     *          2. 如果 i != 0 && j == 0 ,那么就是从左边过来的, grid[i][j] = grid[i-1][j] + grid[i][j]
     *          3. 如果 i == 0 && j != 0 , 那么就是从上边过来的, 那么 grid[i][j] = grid[i][j-1] + grid[i][j]
     *          4. 如果 i != 0 && j != 0 , 那么 grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j]
     *
     *      为了不浪费空间,我们直接在原来的矩阵上面操作,因为原来的矩阵不需要访问第二次了
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 ) return -1;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }else if (i == 0 && j > 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else if ( i > 0 && j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else {
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[nr-1][nc-1];
    }



}
